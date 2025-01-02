# Usamos una imagen base de Java 17 y Maven para construir el proyecto
FROM alpine/java:17-jdk AS builder

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo pom.xml y los archivos fuente del proyecto
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

# Ejecutamos Maven para construir la aplicación y generar el JAR
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
RUN ./mvnw clean package -DskipTests

# Copiamos el archivo JAR de la aplicación en el contenedor
COPY ./target/back-futbolistas-0.0.1-SNAPSHOT.jar .

# Copiamos el script wait-for-it.sh al contenedor
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh


FROM alpine/java:17-jdk
WORKDIR /app

# Copiamos el archivo JAR desde el contenedor de construcción
COPY --from=builder /app/target/back-futbolistas-0.0.1-SNAPSHOT.jar .

# Copiamos el script wait-for-it.sh desde el contenedor de construcción
COPY --from=builder /wait-for-it.sh /wait-for-it.sh
EXPOSE 8080

# Cambiar ENTRYPOINT para usar el shell y ejecutar wait-for-it.sh
ENTRYPOINT ["sh", "/wait-for-it.sh", "db:3306", "--", "java", "-jar", "back-futbolistas-0.0.1-SNAPSHOT.jar"]
