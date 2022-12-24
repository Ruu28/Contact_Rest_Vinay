FROM openjdk:8

COPY target/Contact_Rest.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","Contact_Rest.jar"]

EXPOSE 8080