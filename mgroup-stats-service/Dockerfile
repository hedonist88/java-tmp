FROM amazoncorretto:11-alpine-jdk
ENV TZ="Europe/Moscow"
COPY target/*.jar mgroup-stats-service.jar
ENTRYPOINT ["java","-jar","/mgroup-stats-service.jar"]