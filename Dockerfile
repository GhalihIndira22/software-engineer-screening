FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the correct JAR file into the container
COPY target/software-engineer-screening-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]