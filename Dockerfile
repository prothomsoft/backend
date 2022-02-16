# Dockerfile
FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/backend-1.1.jar backend-1.1.jar
ENTRYPOINT ["java","-jar","/backend-1.1.jar"]