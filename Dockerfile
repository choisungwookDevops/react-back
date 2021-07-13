FROM openjdk:8-jdk-alpine
ARG JAR_FILE=*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]