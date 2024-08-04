#
# Build stage
#
FROM eclipse-temurin:21.0.4_7-jdk

#
# DIR ROOT
#
RUN mkdir -p /usr/app
WORKDIR /usr/app

#
# COPY FILES powm
#
COPY ./pom.xml /usr/app
COPY ./.mvn /usr/app/.mvn
COPY ./mvnw /usr/app/

#
# Download dependencies
#
RUN ./mvnw dependency:go-offline

#
# Code main
#
COPY ./src /usr/app/src/

#
# build proyect
#
RUN ./mvnw clean package -DskipTests

#
# Configure port
#
EXPOSE 8080

#
# Run app
#
CMD ["java", "-jar", "/usr/app/target/schedule-app-RELEASE-0.0.1.jar"]
