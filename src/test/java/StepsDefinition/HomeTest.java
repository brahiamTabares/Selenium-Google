package StepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeTest {

    private  static WebDriver driver;
    public  static WebDriver getDriver(){
        return  driver;
    }
    @Before
    public void setUp(Scenario scenario){

        driver = chromeDriverConecction();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://mail.google.com/");
        screeShotStepBefore(scenario);

    }

    private WebDriver chromeDriverConecction() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        return  driver;
    }
    @After
    public void tearDown(Scenario scenario){
        screeShotStepBefore(scenario);
    }
    @BeforeStep
    private void screeShotStepBefore(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","screeshot step");
    }

}
