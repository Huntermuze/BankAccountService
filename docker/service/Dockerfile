FROM openjdk:18-jdk-oraclelinux8
FROM maven:3.8.6

WORKDIR ./

COPY ./ ./

CMD mvn clean install -DskipTests

CMD mvn spring-boot:run