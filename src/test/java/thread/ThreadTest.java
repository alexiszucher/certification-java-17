package thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
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

    // TODO A NE PAS TROP REGARDER
    @Test
    void peut_utiliser_volatile_pour_gerer_la_concurence_mais_ne_pas_de_utiliser_de_counter_plus_plus_car_non_atomic_et_thread_unsafe() {
        Runnable runnable = () -> {
            // TODO ++counter sur un volatile est thread unsafe
            System.out.println(++Counter.value);
        };
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            while (Counter.value != 100) {
                // TODO il est possible que deux valeurs soient les mêmes
                executorService.submit(runnable);
            }
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    void peut_utiliser_les_classes_atomiques_et_le_synchronized_pour_gerer_la_concurence_et_etre_thread_safe() {
        Runnable runnable = () -> {
            // TODO Cela garantit de passer un seul thread à la fois sur ce bout de code. Les threads voulant également exécuter cette méthode
            //   sont au statut BLOCKED en attendant que le thread en cours ait fini
            synchronized (CounterWithAtomic.class) {
                System.out.println(CounterWithAtomic.value.incrementAndGet());
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            while (CounterWithAtomic.value.get() != 100) {
                executorService.submit(runnable);
            }
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    void peut_mettre_une_methode_avec_le_mot_cle_synchronized() {
        Runnable runnable = CounterWithAtomic::addCountAndPrintIt;
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            while (CounterWithAtomic.value.get() != 100) {
                executorService.submit(runnable);
            }
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    void peut_mettre_un_lock_pour_verouiller_un_bout_de_code() {
        Lock lock = new ReentrantLock();
        Runnable runnable = () -> {
            lock.lock();
            System.out.println(CounterWithAtomic.value.incrementAndGet());
            lock.unlock();
        };
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            while (CounterWithAtomic.value.get() != 100) {
                executorService.submit(runnable);
            }
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    void peut_executer_des_blocks_de_code_en_attendant_que_tous_les_threads_finissent_le_block_en_cours_avant_de_passer_au_suivant() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            // TODO cela indique que 4 threads doivent passer sur les lions avant de débloquer la barrière
            CyclicBarrier lionFinished = new CyclicBarrier(4, () -> System.out.println("LION FINISHED !"));
            executorService.submit(() -> AnimalManager.performTask(lionFinished));
            executorService.submit(() -> AnimalManager.performTask(lionFinished));
            executorService.submit(() -> AnimalManager.performTask(lionFinished));
            executorService.submit(() -> AnimalManager.performTask(lionFinished));
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    void peut_faire_des_traitements_sur_des_listes_avec_les_synchronizedCollection() {
        List<String> animals = new ArrayList<>();
        Collection<String> collection = Collections.synchronizedCollection(animals);
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            executorService.submit(() -> collection.add("Lion"));
            executorService.submit(() -> collection.add("Tiger"));
            executorService.submit(() -> collection.add("Monkey"));
            collection.forEach(System.out::println);
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    void probleme_thread_nomme_deadlock() {
        // TODO Ce problème consiste à ce que deux threads s'attendent mutuellement indéfiniment avec synchronized.
        String toto = "TOTO";
        String tata = "TATA";

        Runnable afficherTotoEtTata = () -> {
            // TODO on souhaite que toto soit débloqué pour toute la durée du traitement et on veut aussi que tata soit débloqué à un moment
            synchronized (toto) {
                System.out.println(toto);

                synchronized (tata) {
                    System.out.println(tata);
                }
            }
        };
        Runnable afficherTataEtToto = () -> {
            // TODO on souhaite que tata soit débloqué pour toute la durée du traitement et on veut aussi que toto soit débloqué à un moment
            synchronized (tata) {
                System.out.println(tata);
                synchronized (toto) {
                    System.out.println(toto);
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            executorService.submit(afficherTataEtToto);
            executorService.submit(afficherTotoEtTata);
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    void probleme_thread_nomme_starvation() {
        // TODO Ce problème survient quand un thread n'arrive jamais à accéder à la ressource dû aux autres threads prenant systematiquement la place.
        //   Imaginons un animal voulant utiliser la méthode manger() mais que tous les autres threads n'arrête pas de lock cette méthode pour manger aussi
        //   L'animal peut mourrir de faim, d'où starvation
    }

    @Test
    void probleme_thread_nomme_livelock() {
        // TODO Lorsque deux threads tentent de liberer les ressources simultanément, mais reste toujours bloqué
        //  Imagine deux personnes dans un couloir étroit :
        //   Deadlock : Les deux restent immobiles, chacun bloquant l'autre.
        //   Livelock : Les deux essaient constamment de bouger pour laisser passer l'autre, mais se retrouvent encore face à face.
    }

    @Test
    void peut_utiliser_parallel_en_stream() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            numbers.add(i);
        }

        // TODO Sans thread
        Instant before = Instant.now();
        numbers.stream().map(number -> number + 1).toList();
        System.out.println("DUREE 1 : " + Duration.between(before, Instant.now()).toMillis());

        // TODO Avec thread
        before = Instant.now();
        numbers.stream().parallel().map(number -> number + 1).toList();
        System.out.println("DUREE 2 : " + Duration.between(before, Instant.now()).toMillis());
    }

    class Counter {
        // TODO Volatile permet à une variable de n'y avoir accès que par une seule entrée mémoire.
        //  Mais si nous faisons des fonctions non atomiques (plusieurs choses à la fois comme ++counter), cela devient thread unsafe
        public volatile static int value = 0;
    }

    class CounterWithAtomic {
        public static AtomicInteger value = new AtomicInteger(0);

        public static synchronized void addCountAndPrintIt() {
            System.out.println(value.incrementAndGet());
        }
    }

    class AnimalManager {
        public static void performTask(CyclicBarrier lionFinished) {
            try {
                System.out.println("Add lion");
                lionFinished.await();
                System.out.println("Add Tiger");
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
