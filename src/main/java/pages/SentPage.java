package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SentPage extends BasePage{
    public SentPage(WebDriver driver) {
        super(driver);
    }

    By redactarLocator= By.cssSelector("div.T-I.T-I-KE.L3");
    By destinatariosLocator = By.cssSelector("input[peoplekit-id='BbVjBd']");

    By asuntoLocator = By.cssSelector("input[aria-label='Asunto']");

    By cuerpoMensajeLocator = By.cssSelector("div[aria-label='Cuerpo del mensaje']");


    By botonEnviarLocator = By.xpath("//div[contains(@class, 'T-I') and @role='button' and contains(text(), 'Enviar')]");


    By mensajeEnviadoLocator = By.cssSelector("span.bAq");


    public void redactarGmail() {
        click(redactarLocator);

    }

    public void datosGmail (String destinario,String asunto){
        type(destinario,destinatariosLocator);
        type(asunto,asuntoLocator);
    }

    public void  cuerpoGmail(String mensaje){

        type(mensaje,cuerpoMensajeLocator);
    }
    public void sentGmail(){

        click(botonEnviarLocator);
    }

    public String verificarGmail(){

        getEwait().until(ExpectedConditions.textToBePresentInElementLocated(mensajeEnviadoLocator, "Mensaje enviado"));
        return getText(mensajeEnviadoLocator);

    }



}
