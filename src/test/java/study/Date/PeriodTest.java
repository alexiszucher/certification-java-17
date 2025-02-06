package study.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.*;

public class PeriodTest {
    @Test
    void ne_peut_pas_ajouter_une_duration_a_une_periode() {
        Period period = Period.ofDays(10);
        Duration duration = Duration.ofDays(10);
        Assertions.assertThrows(DateTimeException.class, () -> {
            period.plus(duration);
        });
        var y = Year.of(2025);
        var ym = y.atMonthDay(MonthDay.of(2, 2));
        System.out.println(ym);
    }
}
