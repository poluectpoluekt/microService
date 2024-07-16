FROM maven:3.9.4-eclipse-temurin-17 as build
WORKDIR /micro
COPY . /micro/.
RUN mvn clean package
FROM bellsoft/liberica-openjre-alpine:17
WORKDIR /micro
RUN adduser -S spring-user
USER spring-user
COPY --from=build /micro/target/MicroSrvSec.jar MicroSrvSec.jar
ENTRYPOINT ["java", "-jar", "MicroSrvSec.jar"]