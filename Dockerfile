FROM openjdk:18-jdk-oraclelinux8

WORKDIR ./

COPY . .

RUN mvn clean install -DskipTests

CMD mvn spring-boot:run