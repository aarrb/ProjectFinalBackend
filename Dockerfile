FROM eclipse-temurin:17
WORKDIR /home
COPY ./flowers ./flowers
COPY ./target/C322-FinalBackend-0.0.1-SNAPSHOT.jar C322-FinalBackend.jar
ENTRYPOINT ["java", "-jar", "C322-FinalBackend.jar"]