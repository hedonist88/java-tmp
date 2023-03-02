FROM amazoncorretto:11-alpine-jdk
COPY target/*.jar mgroup-onec-service.jar
ENTRYPOINT ["java","-jar","/mgroup-onec-service.jar"]