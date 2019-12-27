FROM openjdk:8-jre-alpine
MAINTAINER Swapnil Gaikwad <swapnilbgaikwad99@gmail.com>

EXPOSE 9000

#install utilities
RUN apk add --no-cache curl

COPY build/libs/LinkShare*.jar /usr/local/appPath/LinkShare.jar
COPY docker/startup.sh /startup.sh

WORKDIR /usr/local/appPath

CMD ["/startup.sh"]

