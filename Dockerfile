# Build stage
FROM maven:3.8.1-openjdk-11-slim AS build
WORKDIR /app
COPY . /app
RUN mvn clean install

# Package stage
FROM amazoncorretto:8
COPY --from=build /app/target/Chagiya-SOAP-1.0-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]

