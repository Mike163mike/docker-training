#FROM amazoncorretto:17-al2-jdk
#WORKDIR /app
#COPY . .
##ARG JAR_FILE=target/*.jar
##COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","target/docker-training-1.0-SNAPSHOT.jar"]