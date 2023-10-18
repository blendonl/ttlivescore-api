FROM maven:latest

WORKDIR /app

COPY pom.xml .

COPY src ./src

EXPOSE 8080 5432

RUN apt-get update && apt-get install -y postgresql-client

