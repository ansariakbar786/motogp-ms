#FROM openjdk:17-jdk-slim-buster
FROM eclipse-temurin:17
EXPOSE 8285
LABEL mentainer="ansariakbar786@gmail.com"
COPY target/motogp-0.0.1-SNAPSHOT.jar springboot-motogp.jar
ENTRYPOINT ["java", "-jar", "springboot-motogp.jar"]