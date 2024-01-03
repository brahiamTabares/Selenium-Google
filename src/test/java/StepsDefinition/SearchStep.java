package StepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.GmailPage;
import picoContainer.BasePageGoogle;

public class SearchStep {

    BasePageGoogle basePageGoogle;

    public SearchStep(BasePageGoogle basePageGoogle) {
        this.basePageGoogle = basePageGoogle;
    }
    WebDriver driver= HomeTest.getDriver();

    @Given("El usuario digital el correo que buscara")
    public void el_usuario_digital_el_correo_que_buscara() {
        basePageGoogle.gmailPage= new GmailPage(driver);
        String busqueda = "informe2024";
        basePageGoogle.gmailPage.searchGmail(busqueda);
    }
    @When("El usuario da click en el boton de buscar correo")
    public void el_usuario_da_click_en_el_boton_de_buscar_correo() {
        basePageGoogle.gmailPage.buttonsearch();

    }
    @Then("El usuario verifica el correo que busca")
    public void el_usuario_verifica_el_correo_que_busca() {
        String busqueda = "informe2024";
        basePageGoogle.gmailPage.buscarAsunto(busqueda);

    }
}
