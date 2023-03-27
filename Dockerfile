FROM maven:3.8.3-openjdk-17

WORKDIR /

COPY ./ ./

RUN mvn clean package

EXPOSE 8080

CMD ["java", "-jar", "/Patient-Management-0.0.1-SNAPSHOT.jar"]
