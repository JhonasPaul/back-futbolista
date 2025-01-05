# Imagen base para Java
FROM openjdk:17-jdk-slim AS base

# Definimos el argumento ENVIRONMENT con un valor por defecto 'dev'
ARG ENVIRONMENT=dev
ENV SPRING_PROFILES_ACTIVE=${ENVIRONMENT}

WORKDIR /app

# Instalar netcat (nc) para usar en wait-for-it.sh
RUN apt-get update && \
    apt-get install -y netcat && \
    rm -rf /var/lib/apt/lists/*

# Copiar el script wait-for-it.sh para manejar la dependencia de la base de datos
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Copiar los archivos necesarios para ejecutar Maven Wrapper y Spring Boot
COPY mvnw ./
COPY .mvn/ .mvn
COPY pom.xml ./
COPY src ./src

# Asegurarse de que mvnw tenga permisos de ejecución
RUN chmod +x ./mvnw

# Verificar si el archivo mvnw tiene permisos de ejecución
RUN ls -l ./mvnw

# Si el entorno es producción, se ejecuta el proceso de construcción
FROM base AS builder

# Si estamos en producción, se compila el JAR
RUN if [ "$ENVIRONMENT" = "prod" ]; then \
      ./mvnw clean package -Dmaven.test.skip -Dspring-boot.repackage.skip; \
    fi

# Fase de producción: si es producción, solo copiar el JAR y ejecutar
FROM openjdk:17-jdk-slim AS prod

WORKDIR /app

# Copiar el archivo JAR desde la fase de construcción (solo si es producción)
COPY --from=builder /app/target/back-futbolistas-0.0.1-SNAPSHOT.jar /app/

# Copiar el script wait-for-it.sh desde la fase de construcción
COPY --from=builder /wait-for-it.sh /wait-for-it.sh

# Exponer el puerto
EXPOSE 8080

# Si estamos en producción, ejecutamos el JAR empaquetado
ENTRYPOINT ["sh", "/wait-for-it.sh", "db:3306", "--", "java", "-jar", "back-futbolistas-0.0.1-SNAPSHOT.jar"]

# Si estamos en desarrollo, ejecutamos la aplicación en modo "dev" (sin empaquetar)
FROM base AS dev

WORKDIR /app

# Si el entorno es desarrollo, se ejecuta la aplicación en modo "dev" (sin empaquetar)
ENTRYPOINT ["sh", "/wait-for-it.sh", "db", "3306"]
