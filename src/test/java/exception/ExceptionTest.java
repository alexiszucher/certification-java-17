package exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.OptionalInt;
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
}
