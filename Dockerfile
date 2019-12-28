FROM openjdk:8-jre-alpine
MAINTAINER Swapnil Gaikwad <swapnilbgaikwad99@gmail.com>

EXPOSE 9000

#install utilities
RUN apk add --no-cache curl

WORKDIR /usr/local/appPath

COPY target/CreditApp-*.jar app.jar
COPY src/main/resources/prod/application.yaml application.yaml

CMD ["java", "-jar", "app.jar", "server", "application.yaml"]

