package practice.chapter1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTest {
    @Test
    void ne_peut_pas_convertir_enum_month_en_int() {
        // TODO Does not compile
        // int i = Month.MARCH;
    }

    @Test
    void peut_instancier_date_meme_dans_un_changement_d_heure() {
        // TODO Cela se transforme en 3 h car pas de 2 lors de la nuit du changement d'heure d'été
        LocalDateTime localDateTime = LocalDateTime.of(2022, 3, 13, 2, 0);
        ZoneId americaZone = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime = localDateTime.atZone(americaZone);
        System.out.println(zonedDateTime.toLocalDateTime());

        LocalDateTime localDateTime2 = LocalDateTime.of(2022, 3, 13, 3, 0);
        ZonedDateTime zonedDateTime2 = localDateTime2.atZone(americaZone);
        System.out.println(zonedDateTime2.toLocalDateTime());
    }
}
