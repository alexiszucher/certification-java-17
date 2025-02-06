package study.Format;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class FormatDateTest {
    @Test
    void peut_formatter_une_locale_date() {
        LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
        Assertions.assertEquals(DayOfWeek.THURSDAY, date.getDayOfWeek());
        Assertions.assertEquals(Month.OCTOBER, date.getMonth());
        Assertions.assertEquals(2022, date.getYear());
        Assertions.assertEquals(293, date.getDayOfYear());
    }

    @Test
    void peut_formatter_une_zone_date_time_avec_z() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.OCTOBER, 20, 15, 0);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Paris"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
        Assertions.assertEquals("2022-10-20 15:00:00 +0200", formatter.format(zonedDateTime));

        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        Assertions.assertEquals("2022-10-20 15:00:00 CEST", formatter.format(zonedDateTime));
    }
}
