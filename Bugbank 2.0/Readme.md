## BugBank
Este projeto tem como objetivo automatizar os testes de uma aplicação web de um banco digital ( bugbank ). A aplicação permite aos usuários gerenciar suas transferências bancárias. Para garantir a qualidade e a funcionalidade, os testes automatizados foram implementados utilizando o java, q
# Projeto para automação de testes de uma aplicação web utilizando:
- **Selenium WebDriver** para automação do navegador.
- **Cucumber** para estruturação dos testes em BDD.
- **Page Objects e Page Factory** para organização do código.

## Estrutura do Projeto

- **features/**: Cenários de teste escritos em Gherkin.
- **pages/**: Definição de elementos e ações das páginas.
  - **steps/**: Implementação dos passos dos cenários.
- **Runner.java**: Configuração de execução dos testes.

## Tecnologias

- **Java 11+**
- **Maven**
- **Selenium**
- **Cucumber**
- **JUnit**

## Como Executar

1. Clone o repositório:
   ```bash
   git clone 
   ```
   2. Execute os testes com Maven:
      ```bash
      mvn test
      ```   

## Relatórios

Os relatórios serão gerados no diretório `reports/` nos formatos HTML, JSON e XML.

## Exemplo de Cenário

```gherkin
Funcionalidade: Finalizar compra
   
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


Cenario: Realizar transferencia de saldo
Dado que estou na página inicial
E acesso a conta "Joao"
E transfiro saldo para conta de cleito
Quando valido mensagem de transferencia
Então acesso a conta "Cleito"
E valido que foi debitado na conta a transferencia

```

