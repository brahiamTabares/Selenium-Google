package StepsDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"src/test/resources/features"}, // Ruta a tus archivos .feature
            glue = {"StepsDefinition"}, // Ruta a tus step definitions
            plugin = {"json:src/test/resources/reportucumber/cucumber_report.json", "html:src/test/resources/reportucumber/cucumber-html-report.html"}

    )
    public class RunCucumberTest {
        @AfterClass
        public static void report(){
            try {
                System.out.println("Generando reporte  report.html");
                String[] cmd = {"cmd.exe", "/c", "npm run report"};
                Runtime.getRuntime().exec(cmd);
                System.out.println("¡Reporte generado!");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }


    }

