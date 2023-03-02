FROM amazoncorretto:11-alpine-jdk
ENV TZ="Europe/Moscow"
COPY target/*.jar mgroup-gateway.jar
ENTRYPOINT ["java","-jar","/mgroup-gateway.jar"]