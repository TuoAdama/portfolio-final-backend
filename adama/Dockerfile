FROM maven:3.8.5-openjdk-17 AS maven-build
LABEL authors="tuoadama"
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=maven-build /app/target/adama-0.0.1-SNAPSHOT.jar ./app-build.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app-build.jar"]