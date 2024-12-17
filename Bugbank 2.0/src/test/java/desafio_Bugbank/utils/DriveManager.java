package desafio_Bugbank.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class DriveManager {
    private static WebDriver navegador;
    public static WebDriver getDriver() {
        if (navegador == null) {
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();
            navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            navegador.manage().window().maximize();
        }
        return navegador;
    }

    public static void quitDriver() {
        if (navegador != null) {
            navegador.quit();
            navegador = null;
        }
    }
}