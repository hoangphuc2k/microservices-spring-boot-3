FROM maven:3.8.4-openjdk-17

RUN mkdir /app

COPY . /app

WORKDIR /app

RUN mvn clean package -DskipTests -U

CMD ["java", "-jar", "target/user-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8082

