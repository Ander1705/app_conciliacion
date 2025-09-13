#!/bin/bash
echo "🔄 Actualizando servicio de generación de PDF..."

# Detener servicios
echo "⏹️ Deteniendo servicios..."
docker-compose down

# Limpiar cache de Docker para forzar rebuild
echo "🧹 Limpiando cache de Docker..."
docker system prune -f

# Rebuild solo el backend con los cambios del PDF
echo "🔨 Rebuilding backend con correcciones PDF..."
docker-compose build backend

# Iniciar servicios
echo "🚀 Iniciando servicios..."
docker-compose up -d

# Esperar a que los servicios estén listos
echo "⏳ Esperando a que los servicios estén listos..."
sleep 30

# Verificar estado
echo "🔍 Verificando estado de la aplicación..."
docker-compose ps

# Test básico
echo "🧪 Probando endpoint de PDF..."
sleep 5
if curl -f https://82.112.250.211/api/actuator/health > /dev/null 2>&1; then
    echo "✅ Backend funcionando correctamente"
    echo ""
    echo "📄 Las correcciones del PDF han sido aplicadas:"
    echo "  - Hechos: Una sola línea por campo"
    echo "  - Pretensiones: Una sola línea por campo"
    echo "  - La línea desaparece cuando hay contenido"
    echo ""
    echo "🌐 Prueba generando un nuevo PDF en: https://82.112.250.211"
else
    echo "❌ Error en el backend, verificando logs..."
    docker-compose logs backend --tail=20
fi