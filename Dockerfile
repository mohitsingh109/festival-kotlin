# Step of instruction
FROM openjdk:21-jdk
WORKDIR /app
COPY build/quarkus-app /app
EXPOSE 9000
CMD ["java","-jar","quarkus-run.jar"]
# gradle build, gradle clean