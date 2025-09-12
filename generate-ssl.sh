#!/bin/bash
echo "Generando certificados SSL auto-firmados..."

# Crear directorios
sudo mkdir -p /etc/ssl/certs /etc/ssl/private

# Generar certificado auto-firmado
sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 \
    -keyout /etc/ssl/private/nginx-selfsigned.key \
    -out /etc/ssl/certs/nginx-selfsigned.crt \
    -subj "/C=CO/ST=Cundinamarca/L=Bogota/O=UCMC/CN=82.112.250.211" \
    -addext "subjectAltName=IP:82.112.250.211"

# Establecer permisos
sudo chmod 600 /etc/ssl/private/nginx-selfsigned.key
sudo chmod 644 /etc/ssl/certs/nginx-selfsigned.crt

echo "Certificados SSL generados correctamente"
ls -la /etc/ssl/certs/nginx-selfsigned.crt
ls -la /etc/ssl/private/nginx-selfsigned.key