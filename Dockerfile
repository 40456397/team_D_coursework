FROM openjdk:latest
COPY ./target/Team_D_Coursework-0.1.0.1.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Team_D_Coursework-0.1.0.1.jar"]