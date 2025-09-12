#!/bin/bash

# ====================
# SCRIPT DE INICIO - APP CONCILIACIÓN UCMC
# ====================

set -e

echo "🚀 Iniciando App Conciliación UCMC..."
echo "======================================"

# Colores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Verificar si Docker está instalado
if ! command -v docker &> /dev/null; then
    echo -e "${RED}❌ Docker no está instalado${NC}"
    echo "Por favor instale Docker primero: https://docs.docker.com/get-docker/"
    exit 1
fi

# Verificar si Docker Compose está disponible
if ! command -v docker-compose &> /dev/null && ! docker compose version &> /dev/null; then
    echo -e "${RED}❌ Docker Compose no está disponible${NC}"
    echo "Por favor instale Docker Compose primero"
    exit 1
fi

# Crear archivo .env si no existe
if [ ! -f .env ]; then
    echo -e "${YELLOW}📋 Creando archivo .env desde .env.example${NC}"
    cp .env.example .env
    echo -e "${YELLOW}⚠️  Por favor revise y ajuste las variables en .env${NC}"
fi

# Crear directorios necesarios
echo -e "${GREEN}📁 Creando directorios necesarios...${NC}"
mkdir -p backend/logs
mkdir -p backend/uploads
mkdir -p database/init

# Construir y ejecutar contenedores
echo -e "${GREEN}🔨 Construyendo contenedores...${NC}"
docker-compose build

echo -e "${GREEN}🚀 Iniciando servicios...${NC}"
docker-compose up -d

# Esperar a que los servicios estén listos
echo -e "${GREEN}⏳ Esperando a que los servicios estén listos...${NC}"
sleep 30

# Verificar estado de los servicios
echo -e "${GREEN}📊 Estado de los servicios:${NC}"
docker-compose ps

# URLs de acceso
echo -e "${GREEN}✅ ¡Aplicación iniciada exitosamente!${NC}"
echo "======================================"
echo "🌐 Frontend: http://localhost"
echo "🚀 Backend API: http://localhost:8082/api"
echo "💾 Base de datos: localhost:5432"
echo ""
echo "📋 Para ver logs: docker-compose logs -f"
echo "🛑 Para detener: docker-compose down"
echo "🔄 Para reiniciar: docker-compose restart"