FROM openjdk:18-jdk-oraclelinux8
FROM maven:3.8.6
WORKDIR ./
COPY ./target/BankAccountService-0.0.1-SNAPSHOT.jar BankAccountService-0.0.1.jar
ENTRYPOINT ["java","-jar","/BankAccountService-0.0.1.jar"]