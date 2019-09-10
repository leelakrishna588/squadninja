FROM openjdk:11
ADD ./target/recommended-query-service-0.0.1-SNAPSHOT.jar /recommended-query-service/src/recommended-query-service-0.0.1-SNAPSHOT.jar
WORKDIR recommended-query-service/src
EXPOSE 8091
ENTRYPOINT ["java","-jar","recommended-query-service-0.0.1-SNAPSHOT.jar"]