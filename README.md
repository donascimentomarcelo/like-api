# like-api

## Pré requisitos
- possuir java 8
- possuir o maven

## Configuração Docker
- mvn clean install
- docker build -t like .
- docker-compose up -d

## Criar banco separado
- docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=1234 -e POSTGRES_USER=postgres -e POSTGRES_DB=like postgres:13.1-alpine
