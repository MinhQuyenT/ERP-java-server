FROM openjdk:8
EXPOSE 85
ADD target/hpr-server-java-0.0.1-SNAPSHOT.jar hpr-server-java.jar
ENTRYPOINT ["java", "-jar","/hpr-server-java.jar"]