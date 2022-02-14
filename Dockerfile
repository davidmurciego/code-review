FROM maven:3.6.3-openjdk-8-slim as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8-alpine
COPY --from=build "home/app/target/sequrademo-0.0.3.jar" "sequrademo.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sequrademo.jar"]