package thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
    void doit_obligatoirement_fermer_le_executor_sinon_l_application_ne_s_eteint_jamais() {
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
}
