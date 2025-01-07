package Localisation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalisationTest {
    @Test
    void peut_recuperer_le_locale() {
        Locale language = Locale.FRENCH;
        Locale country = Locale.FRANCE;

        // TODO la langue est toujours en minuscule et le pays est toujours en majuscule séparé par _ : fr_FR ou en_US etc...
        Assertions.assertEquals("fr", language.toString());
        Assertions.assertEquals("fr_FR", country.toString());
    }

    @Test
    void peut_changer_le_default_locale() {
        Assertions.assertEquals("fr_FR", Locale.getDefault().toString());
        Locale locale = new Locale.Builder()
                .setRegion("FR")
                .setLanguage("en")
                .build();
        Locale.setDefault(locale);
        Assertions.assertEquals("en_FR", Locale.getDefault().toString());
    }

    @Test
    void doit_recuperer_le_message_properties_en_fonction_du_locale() {
        ResourceBundle resourceBundleFr = ResourceBundle.getBundle("message");
        Assertions.assertEquals("Bonjour", resourceBundleFr.getString("hello"));
        Locale.setDefault(Locale.ENGLISH);
        ResourceBundle resourceBundleEn = ResourceBundle.getBundle("message");
        Assertions.assertEquals("Hello", resourceBundleEn.getString("hello"));
    }
}
