FROM openjdk
MAINTAINER javaApp

RUN mkdir -p /var/www/app

CMD ["java","-jar","/var/www/app/server.jar"]
