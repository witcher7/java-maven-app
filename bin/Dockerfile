FROM openjdk:8-jdk-alpine

WORKDIR /usr/app

COPY ./target/java-maven-app-1.1.0-SNAPSHOT.jar ./

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "java-maven-app-1.1.0-SNAPSHOT.jar" ]