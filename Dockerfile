# Build stage
FROM maven:3-openjdk-8 AS build
WORKDIR /app
COPY . .
RUN --mount=type=cache,target=/root/.m2 mvn clean install assembly:single

# Package stage
FROM openjdk:8
COPY --from=build /app/target/chagiya-soap-service-jar-with-dependencies.jar /usr/local/lib/app.jar
COPY --from=build /app/.env /.env
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]

