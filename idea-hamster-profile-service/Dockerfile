FROM openjdk:11
ADD ./target/idea-hamster-profile-service-0.0.1-SNAPSHOT.jar /usr/src/idea-hamster-profile-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar","idea-hamster-profile-service-0.0.1-SNAPSHOT.jar"]