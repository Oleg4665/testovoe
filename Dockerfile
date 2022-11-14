FROM openjdk:17-alpine
ARG JAR_FILE=build/libs/innoseti-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /opt/innoseti.jar
ENTRYPOINT ["java","-jar","opt/innoseti.jar"]