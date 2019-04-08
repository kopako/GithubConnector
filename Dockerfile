FROM openjdk:8-slim
WORKDIR /application
COPY . .
ENTRYPOINT ["./gradlew","test"]
