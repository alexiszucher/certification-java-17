package Format;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

public class DecimalFormatTest {
    @Test
    void peut_formatter_les_nombre_avec_les_diese() {
        double decimal = 1234.5678;
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
        Assertions.assertEquals("1 234,57", decimalFormat.format(decimal));
    }

    @Test
    void peut_formatter_les_nombre_avec_les_0() {
        double decimal = 1234.5678;
        DecimalFormat decimalFormat = new DecimalFormat("000,000,000.00");
        Assertions.assertEquals("000 001 234,57", decimalFormat.format(decimal));
    }
}
