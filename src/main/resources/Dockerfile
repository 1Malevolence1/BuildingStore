
FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /opt/app

COPY ../../.. .

RUN chmod +x mvnw && ./mvnw clean install -DskipTests


FROM eclipse-temurin:21-jre-jammy
WORKDIR /opt/app
EXPOSE 8091


COPY --from=builder /opt/app/target/*.jar /opt/app/app.jar

ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]
