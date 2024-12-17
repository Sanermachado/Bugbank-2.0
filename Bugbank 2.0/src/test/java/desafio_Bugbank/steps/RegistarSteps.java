package desafio_Bugbank.steps;

import desafio_Bugbank.pages.*;
import desafio_Bugbank.utils.DriveManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegistarSteps {
    private String valor = "500";
    private String senhaJoao = "123456";
    private String senhaCleito = "654321";

    private WebDriver navegador;

    private RegistrarPage registrarPage;

    @Before
    public void setUp() {
        // Inicializa o navegador usando o DriveManager
        navegador = DriveManager.getDriver();

        // Inicializa as páginas
        registrarPage = new RegistrarPage(navegador);
    }
    @Dado("que estou na página inicial")
    public void queEstouNaPaginaInicial() {
        navegador.get("https://bugbank.netlify.app/");
    }



    @E("clico em registrar")
    public void queClicoNoBotaoRegistrar() throws InterruptedException {
        registrarPage.BtcRegistra.click();
        Thread.sleep(1000);
    }
    @E("preencho email {string}")
    public void preenchoEmail(String email1) {
    registrarPage.inputEmail.sendKeys(email1);
    }
    @E("preencho nome {string}")
    public void preenchonome(String nome1)  {
        registrarPage.inputNome.sendKeys(nome1);
    }
    @E("preencho senha")
    public void preenchoSenha() {
        registrarPage.inputSenha.sendKeys(senhaJoao);
    }
    @E("confirmo senha")
    public void confirmoSenha() {
        registrarPage.confirmaSenha.sendKeys(senhaJoao);
    }
    @E("preencho senha cleito")
    public void preenchoSenhaCleito() {
        registrarPage.inputSenha.sendKeys(senhaCleito);
    }
    @E("confirmo senha cleito")
    public void confirmoSenhaCleito() {
        registrarPage.confirmaSenha.sendKeys(senhaCleito);
    }
    @E("adiciono saldo")
    public void AddSaldo() {
        registrarPage.BtcAddSaldo.click();
    }
    @E("clico em cadastrar")
    public void clicoBtcCadastrar() {
        RegistrarPage.BtcCadastrar.click();
    }

    @E("acesso a conta {string}" )
    public void acessoContaDeJoao(String Cliente){
        switch (Cliente){
            case "Cleito":
                registrarPage.LoguinEmail.sendKeys("cleito@gmail.com");
                registrarPage.Loguinpaswword.sendKeys(senhaCleito);
                break;
            case "Joao":
                registrarPage.LoguinEmail.sendKeys("joao@gmail.com");
                registrarPage.Loguinpaswword.sendKeys(senhaJoao);
                break;}
        registrarPage.BtcAcessar.click();
    }
    @E("transfiro saldo para conta de cleito")
    public void transfiroSandoParaContaDeCleito() throws InterruptedException {
        registrarPage.BtcTransferencia.click();
        Thread.sleep(400);
        registrarPage.inputcontaTransferencia.sendKeys(registrarPage.conta2);
        registrarPage.inputDigitTransferencia.sendKeys(registrarPage.digito2);
        registrarPage.valorTransferencia.sendKeys(valor);
        registrarPage.descricaoTransferencia.sendKeys("envio de "+valor+" para cleito");
        registrarPage.BtcTransferir.click();

    }
    @E("valido que foi debitado na conta a transferencia")
    public void validoQueFoiDebitadoDaContaATransferencia(){
        DriveManager.quitDriver();

    }

    @Entao("armazeno numero da conta um")
    public WebElement armazenaContaUsuarioUm() throws InterruptedException {
        Thread.sleep(500);

        String numeroConta = registrarPage.ModalTexto.getText().replaceAll("\\D", "");
        String[] numerosConta = numeroConta.split("(?<=\\G.{3})");

        if (numerosConta.length == 2) {
            registrarPage.conta1 = numerosConta[0];
            registrarPage.digito1 = numerosConta[1];
            System.out.println(registrarPage.conta1+"-"+registrarPage.digito1);

        }
        return registrarPage.ModalTexto;
    }
    @Entao("armazeno numero da conta dois")
    public WebElement armazenaContaUsuariodois() throws InterruptedException {
        Thread.sleep(500);
        WebElement elemento = navegador.findElement(By.id("modalText"));
        String numeroConta = elemento.getText().replaceAll("\\D", "");
        String[] numerosConta = numeroConta.split("(?<=\\G.{3})");

        if (numerosConta.length == 2) {
            registrarPage. conta2 = numerosConta[0];
            registrarPage.digito2 = numerosConta[1];
            System.out.println(registrarPage.conta2+"-"+registrarPage.digito2);
        }
        return elemento;

    }


    @Quando("abrir modal de registro")
    public void abrorModalDeRegistro(){
        if (registrarPage.BtcCadastrar != null) {
            System.out.println("Elemento encontrado, você está na página correta.");
        } else {
            System.out.println("Elemento não encontrado.");
        }
    }
    @Quando("valido mensagem de transferencia")
        public void ValidoMensagemDeTransferencia() throws InterruptedException {
        Thread.sleep(1000);
        String mensagemExibida = registrarPage.ModalTexto.getText();
        String mensagemEsperada = "Transferencia realizada com sucesso";
        Assert.assertEquals("A mensagem exibida não é a esperada!", mensagemEsperada, mensagemExibida);
        registrarPage.btnCloseModal.click();
        registrarPage.CloseTransferencia.click();
    }

}
