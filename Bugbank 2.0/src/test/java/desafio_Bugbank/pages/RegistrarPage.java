package desafio_Bugbank.pages;

import desafio_Bugbank.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrarPage extends BasePage {
    public static String conta1;
    public static String digito1;
    public static String conta2;
    public  static String digito2;
    @FindBy(css = ".ihdmxA")
    public static WebElement BtcRegistra;
    @FindBy(css = ".CMabB")
    public static WebElement BtcCadastrar;

    @FindBy(css = ".style__ContainerFieldInput-sc-s3e9ea-0:nth-child(2) > .input__default")
    public static WebElement inputEmail;
    @FindBy(css = ".style__ContainerFieldInput-sc-s3e9ea-0:nth-child(3) > .input__default")
    public static WebElement inputNome;
    @FindBy(css = ".login__password:nth-child(4) .input__default")
    public static WebElement inputSenha;
    @FindBy(id = "toggleAddBalance")
    public static WebElement BtcAddSaldo;
    @FindBy(name = "passwordConfirmation")
    public static WebElement confirmaSenha;
    @FindBy(id = "modalText")
    public static WebElement ModalTexto;
    @FindBy(name = "email")
    public static WebElement LoguinEmail;
    @FindBy(name = "password")
    public static WebElement Loguinpaswword;
    @FindBy(css = ".otUnI")
    public static WebElement BtcAcessar;
    @FindBy(css = "#btn-TRANSFER\\CANCIA > span > img")
    public static WebElement BtcTransferencia;
    @FindBy(name = "accountNumber")
    public static WebElement inputcontaTransferencia;
    @FindBy(name = "digit")
    public static WebElement inputDigitTransferencia;
    @FindBy(name = "transferValue")
    public static WebElement valorTransferencia;
    @FindBy(name = "description")
    public static WebElement descricaoTransferencia;
    @FindBy(css = ".style__ContainerButton-sc-1wsixal-0")
    public static WebElement BtcTransferir;
    @FindBy(id = "btnCloseModal")
    public static WebElement btnCloseModal;
    @FindBy(css = ".transfer__ContainerLink-sc-1yjpf2r-2")
    public static WebElement CloseTransferencia;
    @FindBy(id = "btn-EXTRATO")
    public static WebElement BtcExtrato;
    @FindBy(id = "textBalanceAvailable")
    public static WebElement TextSaldo;
    public RegistrarPage(WebDriver navegador) {
        super(navegador);
    }

}
