package Instant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantTest {
    @Test
    void doit_convertir_date_en_instant() {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2024, 1, 1, 15, 0, 0, 0, ZoneId.systemDefault());
        Instant instant = zonedDateTime.toInstant();
        Assertions.assertEquals("2024-01-01T14:00:00Z", instant.toString());

        // Il faut obligatoirement la date, le temps et la zone pour convertir avec toInstant().
    }
}
