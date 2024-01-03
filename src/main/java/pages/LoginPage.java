package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By correoLocator= By.name("identifier");
  // By buttonSiguiente =By.cssSelector("#identifierNext > div > button");
   By buttonSiguiente = By.id("identifierNext");
   By passwordLocator= By.name("Passwd");

   By buttonSiguientePass= By.cssSelector("#passwordNext > div > button");

    By bandejaLocator= By.cssSelector("a.gb_d");

    public void GmailUser(String correo) {
        type(correo,correoLocator);
        click(buttonSiguiente);
    }

    public void passwordUser (String password){

        type(password,passwordLocator);
        click(buttonSiguientePass);
    }

    public void isDisplayeGmailPage() {
        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(bandejaLocator));
        isDisplayed(bandejaLocator);
    }

}
