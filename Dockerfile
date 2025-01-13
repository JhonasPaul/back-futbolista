# Etapa 1: Construcción del proyecto
FROM maven:3.8.8-amazoncorretto-17 AS builder
WORKDIR /app

# Copiar solo los archivos necesarios para descargar dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el resto del proyecto y construir el artefacto
COPY mvnw ./
COPY .mvn/ .mvn
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen base para desarrollo (con recarga en caliente)
FROM openjdk:17-jdk-slim AS dev
WORKDIR /app

# Instalar netcat y Maven para wait-for-it.sh
RUN apt-get update && apt-get install -y netcat maven && rm -rf /var/lib/apt/lists/*

# Copiar el código fuente para permitir hot reload (sin JAR)
COPY . .

# Copiar el script wait-for-it.sh
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Configurar el puerto expuesto
EXPOSE 8080

# Aquí se usa Maven para iniciar la aplicación en lugar de buscar un JAR
CMD ["sh", "-c", "/wait-for-it.sh db 3306 -- ./mvnw spring-boot:run -Dspring-boot.run.profiles"]

# Etapa 3: Imagen base para producción
FROM openjdk:17-jdk-slim AS prod
WORKDIR /app

# Instalar netcat para wait-for-it.sh
RUN apt-get update && apt-get install -y netcat && rm -rf /var/lib/apt/lists/*

# Copiar el JAR desde la etapa de construcción para producción
COPY --from=builder /app/target/back-futbolistas-0.0.1-SNAPSHOT.jar /app/app.jar

# Copiar el script wait-for-it.sh
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Configurar el puerto expuesto
EXPOSE 8080

# Comando para producción (usando el JAR)
ENTRYPOINT ["sh", "-c", "/wait-for-it.sh db 3306 -- java -jar /app/app.jar"]
