# ====================
# FRONTEND DOCKERFILE - React/Vite
# ====================

# Usar Node.js 18 como imagen base para build
FROM node:18-alpine as build

# Información del mantenedor
LABEL maintainer="App Conciliación UCMC"

# Establecer directorio de trabajo
WORKDIR /app

# Copiar archivos de dependencias
COPY package*.json ./

# Instalar dependencias
RUN npm ci --only=production

# Copiar código fuente
COPY . .

# Construir la aplicación para producción
RUN npm run build

# ====================
# IMAGEN FINAL - NGINX
# ====================
FROM nginx:alpine

# Instalar curl para health checks
RUN apk --no-cache add curl

# Copiar archivos de build al directorio de nginx
COPY --from=build /app/dist /usr/share/nginx/html

# Copiar configuración personalizada de nginx
COPY nginx.conf /etc/nginx/nginx.conf

# Crear usuario no-root para nginx
RUN addgroup -g 1001 -S nginx && \
    adduser -S -D -H -u 1001 -h /var/cache/nginx -s /sbin/nologin -G nginx -g nginx nginx

# Exponer puerto 80
EXPOSE 80

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD curl -f http://localhost/ || exit 1

# Comando para iniciar nginx
CMD ["nginx", "-g", "daemon off;"]