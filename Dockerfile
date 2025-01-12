# Usamos una imagen base de Java 17 y Maven para construir el proyecto
FROM maven:3.8.8-amazoncorretto-17 AS builder

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar solo los archivos necesarios
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente y construir
COPY mvnw ./
COPY .mvn/ .mvn
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests

# Imagen final de ejecución
FROM openjdk:17-jdk-slim
WORKDIR /app

# Instalar nc (Netcat) para que wait-for-it.sh funcione
RUN apt-get update && apt-get install -y netcat && rm -rf /var/lib/apt/lists/*

COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
EXPOSE 8080

# Ejecutar directamente el código fuente, no el JAR
CMD ["sh", "/wait-for-it.sh", "db", "3306", "-c", "mvn spring-boot:run -Dspring-boot.run.profiles=dev"]
