

FROM maven:latest
WORKDIR /workspace
EXPOSE 8080
COPY ../ api
CMD ["mvn", "spring-boot:run"]

#RUN --mount=type=cache,target=/root/.m2 ./mvnw -f pom.xml clean package
#
##FROM eclipse-temurin:21-jdk-jammy
##ARG JAR_FILE=/user/app/target/*.jar
##COPY --from=build $JAR_FILE /app/runner.jar
##EXPOSE 8080
##ENTRYPOINT java -jar /app/runner.jar
#




