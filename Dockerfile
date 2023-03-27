FROM java:17
WORKDIR /
ADD /home/runner/work/Microservices-assignment-1/Microservices-assignment-1/target/Patient-Management-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
CMD ["java", "-jar", "/demo.jar"]
