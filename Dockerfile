FROM gradle:8.12-jdk-21-and-23 AS builder

WORKDIR /app

COPY . .

RUN gradle clean build -x test

FROM openjdk:21-jdk-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/spring-library-microservice-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-library-microservice-0.0.1-SNAPSHOT.jar"]
