package desafio_Bugbank;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "desafio_Bugbank.steps",
        tags = "@Regressivo",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "html:reports/cucumber.html",
                "json:reports/cucumber.json",
                "junit:reports/cucumber.xml"
        },
        dryRun = false
)
public class Runner {

        @AfterClass
        public static void openReport() {
                try {
                        // Caminho do relatório gerado
                        File reportFile = new File("reports/cucumber.html");

                        // Verifica se o Desktop é suportado (para abrir arquivos no navegador)
                        if (Desktop.isDesktopSupported()) {
                                Desktop desktop = Desktop.getDesktop();
                                if (reportFile.exists()) {
                                        // Abre o arquivo HTML no navegador padrão
                                        desktop.open(reportFile);
                                } else {
                                        System.out.println("O relatório não foi encontrado em: " + reportFile.getAbsolutePath());
                                }
                        } else {
                                System.out.println("A função Desktop não é suportada no sistema operacional.");
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}
