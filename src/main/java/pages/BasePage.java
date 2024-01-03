package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private WebDriver driver;

    private final WebDriverWait ewait;
    public WebDriverWait getEwait(){
        return ewait;
    }

    public BasePage (WebDriver driver){
        this.driver = driver;
        ewait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebElement fingElement(By locator){
        return  driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {

        return driver.findElements(locator);
    }

    // Este metodo devulve el texto del elemento que se pasa por parametro
    public String getText(WebElement element) {
        return element.getText();
    }

    //Este metodo nos devuelve el texto del elemento que estamos buscando por medio del locator
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Este metodo nos permite escribir texto en la prueba con el comando sendkeys o type(teclear)
    public void type(String inputText, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        ewait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }


    /* Este metodo nos dice si el elemento esta listo para ser utilizado, en el caso que no existe nos devuelve
    una excepcion de que el elemento no existe, no a cargado o fue modificado*/

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
