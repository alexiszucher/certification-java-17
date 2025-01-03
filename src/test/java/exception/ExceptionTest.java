package exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionTest {
    @Test
    void doit_faire_un_try_a_l_appel_d_une_methode_renvoyant_une_exception() {
        // TODO Ne compile pas car doit gérer l'exception IOException
        // Supplier<Integer> result = () -> CountList.count();

        // TODO peut marcher dans ce cas-ci mais code moche
        Supplier<Integer> result = () -> {
            try {
                return CountList.count();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        // TODO création d'une méthode privé countSafe encapsulant l'exception
        result = CountList::countSafe;
    }

    @Test
    void doit_lever_une_ArithmeticException_lors_d_une_division_par_zero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int i = 11 / 0;
        });
    }

    @Test
    void doit_retourner_la_valeur_du_finally_et_jamais_du_try_catch() {
        Supplier<Integer> result = () -> {
            try {
                System.out.println("Try");
                return 0;
            } catch (Exception e) {
                System.out.println("Catch");
                return 1;
            } finally {
                System.out.println("Finally");
                return 2;
            }
        };

        Assertions.assertEquals(2, result.get());
    }

    @Test
    void peut_faire_un_try_with_resources_pour_fermer_automatiquement_une_connexion() {
        // TODO sans try with resources
        FileInputStream file = null;
        try {
            file = new FileInputStream("file.txt");
            // Traitement
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // TODO avec try with resources
        try (FileInputStream file2 = new FileInputStream("file.txt")) {
            // Traitement
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // TODO avec try with resources avec multiples ressources
        try (FileInputStream file2 = new FileInputStream("file2.txt");
        FileInputStream file3 = new FileInputStream("file3.txt")) {
            // Traitement
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
