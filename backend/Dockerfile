# ====================
# BACKEND DOCKERFILE - Spring Boot
# ====================

# Usar OpenJDK 17 como imagen base
FROM openjdk:17-jdk-slim as build

# Información del mantenedor
LABEL maintainer="App Conciliación UCMC"

# Instalar herramientas necesarias
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Establecer directorio de trabajo
WORKDIR /app

# Copiar archivos de Gradle
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Dar permisos de ejecución al gradlew
RUN chmod +x ./gradlew

# Copiar código fuente
COPY src src

# Construir la aplicación
RUN ./gradlew clean build -x test

# ====================
# IMAGEN FINAL
# ====================
FROM openjdk:17-jdk-slim

# Instalar dependencias del sistema para generación de PDFs
RUN apt-get update && apt-get install -y \
    fontconfig \
    fonts-dejavu-core \
    fonts-dejavu-extra \
    && rm -rf /var/lib/apt/lists/*

# Crear usuario no-root para seguridad
RUN groupadd -r appuser && useradd -r -g appuser appuser

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el JAR desde el stage de build
COPY --from=build /app/build/libs/ ./libs/
RUN ls libs/*.jar | head -1 | xargs -I {} cp {} app.jar

# Crear directorio para logs y darle permisos
RUN mkdir -p /app/logs && chown -R appuser:appuser /app

# Cambiar al usuario no-root
USER appuser

# Exponer puerto 8082
EXPOSE 8082

# Variables de entorno
ENV JAVA_OPTS="-Xms256m -Xmx512m -Dspring.profiles.active=production"
ENV SERVER_PORT=8082

# Comando de inicio con opciones optimizadas
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8082/actuator/health || exit 1