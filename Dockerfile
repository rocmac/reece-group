FROM openjdk:8
ADD target/docker-spring-contacts-0.0.1-SNAPSHOT.jar docker-spring-contacts-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-spring-contacts-0.0.1-SNAPSHOT.jar"]