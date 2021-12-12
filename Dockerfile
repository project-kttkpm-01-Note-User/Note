FROM openjdk:11 
ADD /target/Note-0.0.1-SNAPSHOT.jar Note-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","Note-0.0.1-SNAPSHOT.jar"]
