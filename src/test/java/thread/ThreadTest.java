package thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class ThreadTest {
    Runnable printHello = () -> {
        System.out.println("Hello");
    };
    Runnable printBonjour = () -> {
        System.out.println("Bonjour");
    };
    Runnable printHola = () -> {
        System.out.println("Hola");
    };
    Runnable infiniteLoop = () -> {
        while (true) {

        }
    };

    @Test
    void peut_utiliser_un_executor_service_avec_un_thread_pour_avoir_un_thread_a_part_qui_execute_des_runnable() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.execute(printHello);
            executorService.execute(printBonjour);
            executorService.execute(printHola);
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    void doit_obligatoirement_fermer_le_executor_sinon_le_thread_ne_se_ferme_jamais() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.execute(printHello);
            executorService.execute(printBonjour);
            executorService.execute(printHola);
        } finally {
            // TODO Doit toujours shutdown ! Attention shutdown n'eteint pas les threads, ils se termineront avec que le shutdown prennent vraiment effet
            executorService.shutdown();
        }
    }

    @Test
    void peut_utiliser_submit_au_lieu_de_execute() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<?> future = executorService.submit(printHello);
            Future<?> future2 = executorService.submit(printBonjour);
            Future<?> future3 = executorService.submit(printHola);
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    void peut_mettre_un_temps_pour_un_thread_avec_le_concurrency_api() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<?> future = executorService.submit(printHello);
            future.get(10, TimeUnit.SECONDS);
        } catch (TimeoutException | ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    void peut_faire_des_callable_au_lieu_de_runnable() {
        Callable<String> returnHello = () -> "Hello";
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<String> future = executorService.submit(returnHello);
            String result = future.get(10, TimeUnit.SECONDS);
            Assertions.assertEquals("Hello", result);
        } catch (TimeoutException | ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    void peut_faire_des_callable_avec_thread_sans_timeout() {
        Callable<List<String>> returnList1 = () -> List.of("Hello", "Hi");
        Callable<List<String>> returnList2 = () -> List.of("Bonjour", "Salut");
        Callable<List<String>> returnList3 = () -> List.of("Hola", "Hole");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            List<String> result1 = executorService.submit(returnList1).get();
            List<String> result2 = executorService.submit(returnList2).get();
            List<String> result3 = executorService.submit(returnList3).get();
            List<String> results = Stream.of(result1, result2, result3).flatMap(List::stream).toList();
            Assertions.assertEquals(List.of("Hello", "Hi", "Bonjour", "Salut", "Hola", "Hole"), results);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdownNow();
        }
    }

    @Test
    void peut_verifier_que_toutes_les_taches_sont_terminees() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<?> future = executorService.submit(printHello);
            Future<?> future2 = executorService.submit(printBonjour);
            Future<?> future3 = executorService.submit(printHola);
            Future<?> future4 = executorService.submit(infiniteLoop);
        } finally {
            executorService.shutdown();
        }
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        if (executorService.isTerminated()) {
            System.out.println("Terminé !");
        } else {
            System.out.println("Une tâche était encore en cours mais nous avons forcé son arrêt");
        }
    }

    @Test
    void peut_planifier_une_tache() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(printHello, 10, TimeUnit.SECONDS);

        // TODO ATTENTION A CETTE METHODE !!! Si la fonction prend plus de temps que 5 secondes (Le temps mis en période), cela vire au cauchemar !
        scheduler.scheduleAtFixedRate(printHello, 0, 5, TimeUnit.SECONDS);
    }
}
