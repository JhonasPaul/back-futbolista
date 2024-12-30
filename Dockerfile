FROM alpine/java:17-jdk

# aca se copia el jar
WORKDIR /app

# copia el back-futbolistas-0.0.1-SNAPSHOT.jar en la carpeta app representada por el .
COPY ./target/back-futbolistas-0.0.1-SNAPSHOT.jar .

# solo documentacion, es opcional
EXPOSE 8080


# con docker ran invoca el ENTRYPOINT
ENTRYPOINT ["java", "-jar", "back-futbolistas-0.0.1-SNAPSHOT.jar"]