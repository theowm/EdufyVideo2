FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/*.jar /app.jar
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
ENV SPRING_PROFILES_ACTIVE=prod
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]