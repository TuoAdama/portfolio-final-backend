FROM maven:3.8.5-openjdk-17 AS maven-build
LABEL authors="tuoadama"
WORKDIR /app
COPY pom.xml /app/pom.xml
COPY src /app/src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=maven-build /app/target/*.jar /app/app-build.jar
EXPOSE 8443
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app-build.jar"]