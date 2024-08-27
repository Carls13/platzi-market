#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src

#
# Package stage
#
FROM openjdk:11-jre-slim
RUN java -jar -Dspring.profiles.active=pro build/libs/platzi-market-1.0.jar
COPY --from=build ./build/libs/platzi-market-1.0.jar /usr/local/lib/demo.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]