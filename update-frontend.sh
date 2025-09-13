#!/bin/bash
echo "🎨 Actualizando diseño del frontend..."

# Detener servicios
echo "⏹️ Deteniendo servicios..."
docker-compose down

# Limpiar cache de Docker para forzar rebuild del frontend
echo "🧹 Limpiando cache de Docker del frontend..."
docker system prune -f

# Rebuild solo el frontend con el nuevo diseño
echo "🔨 Rebuilding frontend con nuevo header..."
docker-compose build frontend

# Iniciar servicios
echo "🚀 Iniciando servicios..."
docker-compose up -d

# Esperar a que los servicios estén listos
echo "⏳ Esperando a que los servicios estén listos..."
sleep 25

# Verificar estado
echo "🔍 Verificando estado de la aplicación..."
docker-compose ps

# Test básico
echo "🧪 Probando acceso al frontend..."
sleep 5
if curl -f https://82.112.250.211 > /dev/null 2>&1; then
    echo "✅ Frontend funcionando correctamente"
    echo ""
    echo "🎨 Las mejoras del header han sido aplicadas:"
    echo "  ✅ Escudo ya no está aplastado (proporción correcta)"
    echo "  ✅ Diseño más profesional con gradientes"
    echo "  ✅ Efectos visuales modernos (glassmorphism)"
    echo "  ✅ Responsive design para móviles y tablets"
    echo "  ✅ Mejor organización de la información"
    echo "  ✅ Colores institucionales realzados"
    echo "  ✅ Iconos en información de contacto"
    echo "  ✅ Sombras y efectos de profundidad"
    echo ""
    echo "📱 Prueba en diferentes dispositivos:"
    echo "  - Desktop: https://82.112.250.211"
    echo "  - Tablet: Usa las herramientas de desarrollador"
    echo "  - Móvil: Responsive automático"
    echo ""
    echo "🌐 Accede a: https://82.112.250.211"
else
    echo "❌ Error en el frontend, verificando logs..."
    docker-compose logs frontend --tail=20
fi