FROM openjdk:11-jdk-oracle

WORKDIR /usr/app

COPY ./target/java-maven-app-1.1.0-SNAPSHOT ./

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "java-maven-app-1.1.0-SNAPSHOT"]
