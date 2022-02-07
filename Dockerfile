FROM openjdk:11
EXPOSE 8082
ADD target/taxifa.jar taxifa.jar
ENTRYPOINT ["java","-jar","/taxifa.jar"]