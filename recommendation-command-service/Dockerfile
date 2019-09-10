FROM openjdk:11

ADD ./target/squad-0.0.1-SNAPSHOT.jar /usr/src/squad-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "squad-0.0.1-SNAPSHOT.jar"]