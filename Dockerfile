FROM openjdk:11-oracle
ARG JAR_FILE=build/libs/orglist-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]