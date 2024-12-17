package desafio_Bugbank.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void tirarScreenshot(WebDriver driver,String nomeArquivo) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destino = new File("reports/screenshots/" + nomeArquivo + ".png");
        FileHandler.copy(screenshot, destino);
    }

}
