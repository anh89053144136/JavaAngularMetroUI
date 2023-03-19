FROM eclipse-temurin:19-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} AngularMetroUI-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","AngularMetroUI-1.0.0.jar"]