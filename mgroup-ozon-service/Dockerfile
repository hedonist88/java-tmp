FROM amazoncorretto:11-alpine-jdk
COPY target/*.jar mgroup-ozon-service.jar
ENTRYPOINT ["java","-jar","/mgroup-ozon-service.jar"]