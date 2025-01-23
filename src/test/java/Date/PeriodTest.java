package Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Period;

public class PeriodTest {
    @Test
    void ne_peut_pas_ajouter_une_duration_a_une_periode() {
        Period period = Period.ofDays(10);
        Duration duration = Duration.ofDays(10);
        Assertions.assertThrows(DateTimeException.class, () -> {
            period.plus(duration);
        });
    }
}
