#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/platzi-market-1.0.jar /usr/local/lib/demo.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]