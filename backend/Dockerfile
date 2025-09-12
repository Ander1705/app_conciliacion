# Build stage
FROM openjdk:17-jdk-slim as build

LABEL maintainer="App Conciliación UCMC"

# Install build tools
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copy gradle wrapper and build files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Make gradlew executable
RUN chmod +x ./gradlew

# Copy source code
COPY src src

# Build application
RUN ./gradlew clean build -x test

# Runtime stage
FROM openjdk:17-jdk-slim

# Install runtime dependencies
RUN apt-get update && apt-get install -y \
    fontconfig \
    fonts-dejavu-core \
    fonts-dejavu-extra \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Create application user
RUN groupadd -r appuser && useradd -r -g appuser appuser

WORKDIR /app

# Copy JAR file (corregido para manejar múltiples JARs)
COPY --from=build /app/build/libs/ ./libs/
RUN find libs/ -name "*.jar" ! -name "*-plain.jar" | head -1 | xargs -I {} cp {} app.jar

# Create logs directory and set permissions
RUN mkdir -p /app/logs && chown -R appuser:appuser /app

# Switch to non-root user
USER appuser

# Expose port
EXPOSE 8082

# Environment variables
ENV JAVA_OPTS="-Xms256m -Xmx512m -Dspring.profiles.active=production"
ENV SERVER_PORT=8082

# Start application
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]