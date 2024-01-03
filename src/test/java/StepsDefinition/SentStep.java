package StepsDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SentPage;
import picoContainer.BasePageGoogle;

import static org.junit.Assert.assertEquals;

public class SentStep {

    BasePageGoogle basePageGoogle;
    WebDriver driver = HomeTest.getDriver();
    Faker faker = new Faker();


    public SentStep(BasePageGoogle basePageGoogle) {
        this.basePageGoogle = basePageGoogle;
    }

    @Given("El usuario selecciona la opcion de redactar  en la bandeja de entrada")
    public void el_usuario_selecciona_la_opcion_de_redactar_en_la_bandeja_de_entrada() {
        basePageGoogle.sentPage= new SentPage(driver);
        basePageGoogle.sentPage.redactarGmail();

    }

    @When("El usuario ingresa los destinatarios del correo con un asunto")
    public void el_usuario_ingresa_el_correo_o_los_correos_de_los_destinatarios_en_el_campo_para() {
        String correo = "brahiamdtabaresv@gmail.com";
        String asunto = faker.lorem().sentence();
        basePageGoogle.sentPage.datosGmail(correo,asunto);
    }

    @And("El usuario diligencia el correo")
    public void el_usuario_diligencia_el_correo() {
        String mensaje= faker.lorem().sentence();
        basePageGoogle.sentPage.cuerpoGmail(mensaje);
    }

    @Then("El usuario envia el mensaje")
    public void el_usuario_envia_el_mensaje() {
        basePageGoogle.sentPage.sentGmail();

    }

    @And("El usuario verifica que se envio el mensaje")
    public void el_usuario_verifica_que_se_envio_el_mensaje() {
        String mensaje2= basePageGoogle.sentPage.verificarGmail();
        assertEquals("Mensaje enviado",mensaje2);


    }
}
