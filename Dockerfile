FROM openjdk:15
ADD target/Todo_Web_Application-0.0.1-SNAPSHOT.jar docker-todo_web_application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-todo_web_application.jar"]