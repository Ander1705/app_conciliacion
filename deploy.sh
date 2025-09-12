#!/bin/bash
set -e

echo "Iniciando despliegue completo..."

# Detener PostgreSQL local si existe
sudo systemctl stop postgresql 2>/dev/null || true

# Generar certificados SSL
echo "Generando certificados SSL..."
./generate-ssl.sh

# Limpiar contenedores existentes
echo "Limpiando contenedores anteriores..."
docker-compose down -v 2>/dev/null || true
docker system prune -f

# Construir y ejecutar
echo "Construyendo y ejecutando aplicación..."
docker-compose up --build -d

# Esperar a que los servicios estén listos
echo "Esperando a que los servicios estén listos..."
sleep 30

# Verificar estado
echo "Verificando estado de la aplicación..."
docker-compose ps

# Probar acceso
echo "Probando acceso a la aplicación..."
sleep 10
curl -k https://82.112.250.211 -I || echo "Frontend aún no disponible"
curl http://82.112.250.211:8082/api/ || echo "Backend aún no disponible"

echo "Despliegue completado!"
echo "Frontend: https://82.112.250.211"
echo "Backend: https://82.112.250.211/api/"
echo "Logs: docker-compose logs -f"