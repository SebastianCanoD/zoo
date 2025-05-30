FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/zoologico-0.0.1-SNAPSHOT.jar  # Nombre correcto
COPY ${JAR_FILE} appZoo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "appZoo.jar"]