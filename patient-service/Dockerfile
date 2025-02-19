FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/patient-service.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
