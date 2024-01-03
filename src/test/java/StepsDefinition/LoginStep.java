package StepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import picoContainer.BasePageGoogle;

public class LoginStep {

    BasePageGoogle basePageGoogle;
    WebDriver driver = HomeTest.getDriver();

    public LoginStep(BasePageGoogle basePageGoogle) {
        this.basePageGoogle = basePageGoogle;
    }

    @Given("El usuario  esta registrado en Gmail")
    public void el_usuario_esta_registrado_en_gmail() {
        basePageGoogle.loginPage = new LoginPage(driver);
    }
    @When("El usuario ingresa su correo electronico y le da en el boton siguinete")
    public void el_usuario_ingresa_su_correo_electronico_y_le_da_en_el_boton_siguinete() {
       String correo= "brahiamdtabaresv@gmail.com";
        basePageGoogle.loginPage.GmailUser(correo);
    }
    @When("El usuario ingresa su contrasenia y le da en siguiente")
    public void el_usuario_ingre_su_contrasenia_y_le_da_en_siguiente() {
        String password = "Superkillingfloor2";
        basePageGoogle.loginPage.passwordUser(password);
    }
    @Then("El usuario se encuentra en la bandeja de entrada de su correo")
    public void el_usuario_se_en_su_bandeja_de_entrada_de_su_correo() {

        basePageGoogle.loginPage.isDisplayeGmailPage();

    }
}
