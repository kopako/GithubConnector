FROM openjdk:8-slim
WORKDIR /application
COPY . .
ENTRYPOINT ["/bin/sh"]
