package study.Format;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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

    @Test
    void peut_formatter_les_nombres_avec_les_methodes_par_defaut_de_NumberFormat() {
        Locale.setDefault(Locale.US);
        double t = 100_102.2;
        Assertions.assertEquals("100K", NumberFormat.getCompactNumberInstance().format(t));
        Assertions.assertEquals("100K", NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.SHORT).format(t));
        Assertions.assertEquals("$100,102.20", NumberFormat.getCurrencyInstance().format(t));
    }
}
