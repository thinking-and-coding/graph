#syntax=docker/dockerfile:1

FROM openjdk:8-jdk-alpine

WORKDIR /app

ARG JAR_FILE=start/target/*.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]