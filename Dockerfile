FROM openjdk:17-oracle

WORKDIR /

COPY ./ ./

RUN mvn clean package

EXPOSE 8080

CMD ["java", "-jar", "/demo.jar"]
