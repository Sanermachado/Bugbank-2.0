#language: pt

@Regressivo
Funcionalidade: Teste cadastro
  @Cenario1
  Cenario: Realizar Cadastro conta 1
    Dado que estou na página inicial
    E clico em registrar
    Quando abrir modal de registro
    E preencho email "joao@gmail.com"
    E preencho nome "joao"
    E preencho senha
    E confirmo senha
    E adiciono saldo
    E clico em cadastrar
    Então armazeno numero da conta um


  @Cenario2
  Cenario: Realizar Cadastro conta 2
    Dado que estou na página inicial
    E clico em registrar
    Quando abrir modal de registro
    E preencho email "cleito@gmail.com"
    E preencho nome "cleito"
    E preencho senha cleito
    E confirmo senha cleito
    E adiciono saldo
    E clico em cadastrar
    Então armazeno numero da conta dois


  @Cenario3
  Cenario: Realizar transferencia de saldo
    Dado que estou na página inicial
    E acesso a conta "Joao"
    E transfiro saldo para conta de cleito
    Quando valido mensagem de transferencia


  @Cenario4
  Cenario: Validando transferencia
    Dado que estou na página inicial
    E acesso a conta "Cleito"
    E clico em Extrato
    Então o saldo deve ser de "1500,00" reais



