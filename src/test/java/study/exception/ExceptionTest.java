package study.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @Test
    void peut_catcher_plusieurs_exceptions() {
        try {
            int i = 1 + 1;
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void peut_avoir_un_try_simple_car_un_finally_se_cache_derriere_la_compilation() throws IOException {
        try (var writer = Files.newBufferedWriter(Path.of(""))) {
            int i = 1 + 1;
        }
    }

    @Test
    void doit_avoir_throw_en_code_local_et_throws_en_declaration_methode() throws Exception {
        // TODO throws est sur la déclaration, throw est sur le code local
        throw new Exception();
    }

    @Test
    void souleve_un_RuntimeException_quand_on_parse_pour_une_LocalDate_un_format_ISO_DATE_TIME() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            LocalDate localDate = LocalDate.parse("2025-01-08", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        });
    }

    @Test
    void tout_ce_qui_herite_de_exception_doit_etre_declare_en_throws_de_la_methode() throws Exception {
        throw new Exception();
    }

    @Test
    void ne_peut_pas_souveler_un_RuntimeException_apres_une_Exception() {
        try {

        } catch (Exception e) {
        } // catch (RuntimeException e) {
        // TODO ne peut pas compiler
        // }


    }
}
