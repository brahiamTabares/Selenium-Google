package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.IntStream;

public class GmailPage extends BasePage{

    By correoLocator= By.name("identifier");
   // By buscarCorreoLocator = By.cssSelector("input.gb_re[aria-label='Buscar en el correo']");
   By buscarCorreoLocator = By.name("q");
    By buscarCorreoButtonLocator = By.cssSelector("#aso_search_form_anchor > button.gb_De.gb_Ee.bEP");
    By tableSearchLocator= By.cssSelector("#\\:ah");


    public GmailPage(WebDriver driver) {
        super(driver);
    }


    public void searchGmail(String texto){
       type(texto,buscarCorreoLocator);
    }
    public void buttonsearch(){

        click(buscarCorreoButtonLocator);

    }
   public boolean buscarAsunto(String asunto) {
        // Espera a que la tabla esté presente en la página
        if (buscarAsuntoPos(asunto) >= 0) {
            return true;
        } else {
            return false;
        }
    }
    public int buscarAsuntoPos(String texto) {

        getEwait().until(ExpectedConditions.presenceOfElementLocated(tableSearchLocator));

        List<WebElement> filas = findElements(By.cssSelector("tr.zA.zE[jscontroller='ZdOxDb']"));

        if (filas.size() == 1 && filas.get(0).getText().contains("No hay ningún mensaje que coincida con tu búsqueda. Prueba a utilizar opciones de búsqueda como remitente, fecha o tamaño, entre otras.")) {
            System.out.println("La tabla está vacía. No se encontraron registros.");
            return 0;
        }
        // se crea un flujo de enteros para iterar atravez de la tabla y se filtra las filas que cumplen con las condiciones
        int posicionAsunto = IntStream.range(0, filas.size())
                .filter(i -> {
                    WebElement fila = filas.get(i);
                    List<WebElement> celdas = fila.findElements(By.tagName("td"));

                    if (celdas.size() >= 2) {
                        String asunto = getText(celdas.get(5));


                        if (asunto.equalsIgnoreCase(texto)) {
                            System.out.println("Asunto encontrado en la tabla: " + texto);
                            return true;
                        }
                    }
                    return false;
                })

                //recupera el primer índice de fila que cumple con las condiciones o devuelve -1 si no se encontró.
                .findFirst()
                .orElse(-1);

        if (posicionAsunto == -1) {
            System.out.println("asunto no encontrado en la tabla.");
        }
        System.out.println(posicionAsunto);
        return posicionAsunto - 1;
    }


    }


