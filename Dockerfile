FROM openjdk:latest
COPY ./target/Team_D_Coursework-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Team_D_Coursework-0.1.0.2-jar-with-dependencies.jar"]