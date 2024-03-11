# Pokémon Team Builder API

Esta é uma API desenvolvida em Java 17 utilizando Spring Boot para montar times de Pokémon. Ela interage com a [PokeAPI](https://pokeapi.co/) para obter informações sobre os Pokémon.

## Funcionalidades

- Criação de times de Pokémon
- Listagem de todos os times registrados
- Busca de um time por usuário

## Como usar

### Pré-requisitos

- Java 17
- Spring Boot
- Docker
- Docker Compose

### Instalação

1. Clone este repositório:

git clone https://github.com/esther0012/Desafio

2. Navegue até o diretório do projeto:

cd /desafio

3. Construa a imagem Docker:

docker build -t desafio-builder .

4. Execute o contêiner Docker:

docker run -p 8081:8081 desafio-builder

### Rotas

- GET /api/teams: Lista todos os times registrados.
- GET /api/teams/{user}: Busca um time registrado pelo nome de usuário.
- POST /api/teams: Cria um novo time. O corpo da requisição deve ser um JSON no seguinte formato:

{
  "owner": "sleao",
  "team": [
    "blastoise",
    "pikachu",
    "charizard",
    "venusaur",
    "lapras",
    "dragonite"
  ]
}

## Exemplo de uso


Para listar todos os times registrados:

curl http://localhost:8081/api/teams

Isso retornará uma lista com todos os times registrados.

3. Para buscar um time por usuário:

curl http://localhost:8080/api/teams/ash

Isso retornará o time registrado pelo usuário "ash".

## Contribuição

Sinta-se à vontade para contribuir com novos recursos, correções de bugs ou melhorias nesta API. Basta abrir uma [issue](https://github.com/esther0012/Desafio/issues) ou enviar um [pull request](https://github.com/esther0012/Desafio/pulls).

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
