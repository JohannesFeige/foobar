# Superhero - Api

Spring Boot GraphQL API build with 
[Spring Boot Starter GraphQL](https://docs.spring.io/spring-graphql/docs/1.2.0-RC1/reference/html/)

## Vorbedingungen
- min. Java 17 installiert 
- JAVA_HOME ist auf diese Java Version gesetzt sein
- Docker

## Anwendungen starten
1. Projekt ist ausgecheckt
2. `docker compose -f dev_support/docker-compose.yml up -d`
3. `./gradlew bootRun` startet die SpringBoot App


## API's

### GraphQL

- [GraphiQL UI - http://localhost:8080/graphiql](http://localhost:8080/graphiql)
- [Graph Schema - http://localhost:8080/graphql/schema](http://localhost:8080/graphql/schema)
