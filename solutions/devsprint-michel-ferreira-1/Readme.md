# Transactions API

Projeto desenvolvido no padrão MVC, no qual será refatorado usando a arquitetura hexagonal e implementando novas funcionalidades. 

### Recursos
- Efetivar transação 

### Executando o programa

**Importante:** Não se esqueça de configurar o JDK do projeto com a versão 11.

Após a configuração da JDK, suba o container do docker utilizando o comando abaixo:
```shell
docker-compose up -d  
```

### Conectar no Banco Mysql
* Hostname: localhost
* Port: 3306
* Username: root
* Password: secret

#### Criar a Base de Dados 'dev-pass'
```
CREATE SCHEMA `dev-pass`;
```
---

### Executar a Aplicação

Rodar a classe ChallengeHexagonalKotlinApplication.
Após iniciada, acessar [http://localhost:8080/](http://localhost:8080/) para visualizar a aplicação rodando no padrão MVC.
