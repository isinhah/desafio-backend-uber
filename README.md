<h1 align="center">
  Desafio Técnico Uber
</h1>

<p align="center">
  <a href="https://github.com/uber-archive/coding-challenge-tools/blob/master/coding_challenge.md">Link para o Desafio</a>
</p>

## Desafio 1: Serviço de e-mail
Serviço de e-mail desenvolvida com Java e Spring Boot, utilizando o AWS SDK para envio de mensagens via Amazon Simple Email Service.

### Endpoint

`POST /api/email`

Este endpoint permite o envio de e-mails usando o Amazon SES. Basta enviar uma requisição POST com o seguinte corpo JSON:

```json
{
  "to": "seuemail@email.com",
  "subject": "assunto do email",
  "body": "mensagem do email"
}
```

### Tecnologias
- Java
- Spring Boot
- AWS SDK - SES (Simple Email Service)
- Maven
- DevTools
- Lombok

<hr>

## Desafio 2: SF Filmes
Aplicação que exibe locais de filmagem de filmes de ficção científica em São Francisco. Usuários podem filtrar a visualização por título através de uma busca com preenchimento automático. A API consume dados diretamente do [DataSF](https://data.sfgov.org/Culture-and-Recreation/Film-Locations-in-San-Francisco/yitu-d5am/about_data).

### Endpoints

`GET /api/movies?title={title}`

Este endpoint retorna informações sobre os filmes e suas respectivas localizações de filmagem. Opcionalmente inclua o título do filme como um parâmetro de busca:

```json
[
  {
    "title": "Star Trek VI: The Undiscovered Country",
    "release_year": "1991",
    "locations": "Golden Gate Bridge",
    "director": "Nicholas Meyer"
  },
  {
    "title": "Star Trek IV: The Voyage Home",
    "release_year": "1986",
    "locations": "Kearny & Pacific Streets",
    "director": "Leonard Nimoy"
  },
  {
    "title": "Star Trek IV: The Voyage Home",
    "release_year": "1986",
    "locations": "Intersection of Columbus & Kearney Streets",
    "director": "Leonard Nimoy"
  }
]
```

`GET /api/movies/autocomplete?prefix={title}`

Este endpoint retorna sugestões de títulos de filmes para preenchimento automático. Basta enviar uma requisição GET com o início do título desejado no parâmetro prefix:

```json
[
  "The Assassination of Richard Nixon",
  "The Bachelor",
  "The Caine Mutiny",
  "The Californians",
  "The Competition",
  "The Conversation",
  "The Core",
  "The Dead Pool",
  "The Diary of a Teenage Girl",
  "The Doors"
]
```

### Tecnologias
- Java
- Spring Boot
- Spring Reactive WebFlux
- Maven
- DevTools
- Lombok

## Autor
- Projeto desenvolvido por [Isabel Henrique](https://www.linkedin.com/in/isabel-henrique/)
- Fique à vontade para contribuir!
