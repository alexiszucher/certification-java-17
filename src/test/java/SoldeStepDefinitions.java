import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import org.junit.jupiter.api.Assertions;

public class SoldeStepDefinitions {
    private static int SOLDE = 0;

    @Etantdonnéque("j'ai un solde de {int} €")
    public void j_ai_un_solde_de_€(Integer int1) {
        SOLDE = int1;
    }

    @Quand("j'ajoute {int} €")
    public void j_ajoute_euros(Integer int1) {
        SOLDE += int1;
    }

    @Alors("mon solde est de {int} €")
    public void mon_solde_est_de_€(Integer int1) {
        Assertions.assertEquals(int1, SOLDE);
    }
}
