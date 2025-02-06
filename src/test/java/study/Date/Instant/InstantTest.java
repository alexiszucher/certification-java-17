package study.Date.Instant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayDeque;
import java.util.Deque;

public class InstantTest {
    @Test
    void doit_convertir_date_en_instant() {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2024, 1, 1, 15, 0, 0, 0, ZoneId.systemDefault());
        Instant instant = zonedDateTime.toInstant();
        Assertions.assertEquals("2024-01-01T14:00:00Z", instant.toString());

        // Il faut obligatoirement la date, le temps et la zone pour convertir avec toInstant().
    }

    @Test
    void ne_doit_pas_changer_un_instant_quand_on_ajoute_un_jour() {
        Instant instant = Instant.parse("2024-01-01T23:00:00Z");
        instant.plus(1, ChronoUnit.DAYS);
        System.out.println(instant.plusSeconds(10));
        LocalDate localDate = LocalDate.ofInstant(instant, ZoneId.of("GMT+1"));
        System.out.println(localDate);
        Deque<Integer> numbers = new ArrayDeque<>();
        numbers.offer(1);
        numbers.add(2);
        numbers.remove();
        Assertions.assertEquals("2024-01-01T23:00:00Z", instant.toString());
    }
}
