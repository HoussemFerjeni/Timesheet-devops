FROM openjdk:8-jdk-alpine
EXPOSE 8082
COPY target /target
ENTRYPOINT ["java","-jar","/target/timesheet-devops-1.jar"]