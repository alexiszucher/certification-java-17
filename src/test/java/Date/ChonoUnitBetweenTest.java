package Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ChonoUnitBetweenTest {

    public static final ZonedDateTime MARCH_13TH_AT_3_30_AM = ZonedDateTime.of(2022, 3, 13, 3, 30, 0, 0, ZoneId.of("US/Eastern"));

    @Test
    void doit_prendre_en_compte_le_changement_d_heure() {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2022, 3, 13, 1, 30, 0, 0, ZoneId.of("US/Eastern"));
        ZonedDateTime zonedDateTime2 = zonedDateTime.plus(1, ChronoUnit.HOURS);

        Assertions.assertEquals(MARCH_13TH_AT_3_30_AM, zonedDateTime2);
        Assertions.assertEquals(1, ChronoUnit.HOURS.between(zonedDateTime, zonedDateTime2));
    }
}
