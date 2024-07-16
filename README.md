#Challenge Forum-Hub-API

É uma aplicação desenvolvida em Java utilizando o framework Spring Boot. Esta API foi projetada para fornecer serviços de autenticação e gerenciamento de usuários para um fórum.

#Requisitos de Sistema
Java: Versão 21 ou superior
Maven: Para gerenciamento de dependências
#Dependências Principais
Spring Boot: 3.1.1
Spring Boot Starter Web: 3.1.1
Auth0 Java JWT: 4.2.1
#Recursos Utilizados
Spring Boot: Framework para criação de aplicações standalone e de produção em Spring.
Spring Boot Starter Web: Starter para construir aplicações web, incluindo RESTful, utilizando Spring MVC.
Auth0 Java JWT: Biblioteca para criação e verificação de tokens JWT.
#Configurações de Segurança
A segurança é um dos aspectos mais críticos desta API. Abaixo estão alguns dos principais recursos de segurança utilizados:

Token JWT (JSON Web Token):

Utilizado para autenticação de usuários.
Os tokens são assinados usando o algoritmo HMAC256.
Tokens possuem um tempo de expiração configurado para garantir a segurança.
Configurações de Segurança do Spring:

A aplicação utiliza as configurações de segurança do Spring para proteger os endpoints.
O token JWT é validado para cada requisição, garantindo que apenas usuários autenticados possam acessar determinados recursos.
Estrutura do Projeto
com.forum.hub.model

Contém as classes de modelo, incluindo AuthUser.
com.forum.hub.service

Contém as classes de serviço, incluindo TokenService que é responsável pela geração e validação de tokens JWT.
Classe TokenService
A classe TokenService é central para o gerenciamento de tokens JWT na aplicação. Ela inclui métodos para gerar e validar tokens.
