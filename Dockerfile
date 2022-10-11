FROM maven:3.6.3-jdk-18-openj9

WORKDIR ./

COPY . .

RUN mvn clean install -DskipTests

CMD mvn spring-boot:run