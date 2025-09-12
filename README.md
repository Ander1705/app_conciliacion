# 📋 App Conciliación UCMC

Sistema web para la gestión de solicitudes de conciliación extrajudicial de la Universidad Católica Mayor de Colombia (UCMC).

![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)
![React](https://img.shields.io/badge/React-18.0+-61dafb.svg)
![Docker](https://img.shields.io/badge/Docker-Ready-blue.svg)

## 🚀 Características

- ✅ **Frontend React**: Interfaz moderna y responsiva con Vite
- ✅ **Backend Spring Boot**: API REST robusta con validaciones
- ✅ **Generación de PDF**: Documentos legales automatizados con iText7
- ✅ **Base de datos**: PostgreSQL para producción, H2 para desarrollo
- ✅ **Dockerizado**: Deployable con Docker Compose
- ✅ **HTTPS Ready**: Configurado para SSL con certificados auto-firmados
- ✅ **VPS Deployment**: Optimizado para despliegue en IP 82.112.250.211
- ✅ **CI/CD GitHub Actions**: Despliegue automático desde GitHub
- ✅ **Health Checks**: Monitoreo de servicios con Spring Actuator
- ✅ **Rollback Support**: Scripts de recuperación automática
- ✅ **Formularios completos**: Todos los campos requeridos para conciliación
- ✅ **Validaciones**: Frontend y backend completamente validados

## 🏗️ Arquitectura

```
app_conciliacion/
├── backend/              # Spring Boot API
│   ├── src/main/java/    # Código fuente Java
│   ├── Dockerfile        # Container backend
│   └── build.gradle      # Dependencias
├── frontend/             # React Application
│   ├── src/              # Código fuente React
│   ├── Dockerfile        # Container frontend
│   └── package.json      # Dependencias npm
├── docker-compose.yml    # Orquestación de servicios
├── .env                  # Variables de entorno
├── .github/workflows/    # GitHub Actions CI/CD
├── scripts/              # Scripts de utilidad
├── deploy.sh            # Script de despliegue
├── manual-deploy.sh     # Despliegue manual
└── rollback.sh          # Script de rollback
```

## 🛠️ Tecnologías

### Backend
- **Java 17** - Lenguaje de programación
- **Spring Boot 3.5.5** - Framework principal
- **Spring Data JPA** - Persistencia de datos
- **PostgreSQL** - Base de datos principal
- **H2 Database** - Base de datos para desarrollo
- **iText7** - Generación de documentos PDF
- **Maven/Gradle** - Gestión de dependencias

### Frontend
- **React 18+** - Librería de UI
- **Vite** - Build tool y dev server
- **JavaScript/JSX** - Lenguaje
- **CSS Modules** - Estilos
- **Axios** - Cliente HTTP

### DevOps
- **Docker & Docker Compose** - Containerización
- **GitHub Actions** - CI/CD automatizado
- **Nginx** - Servidor web para frontend con SSL
- **PostgreSQL** - Base de datos de producción
- **SSL/TLS** - Certificados auto-firmados para HTTPS

## 🚀 Inicio Rápido

### Con Docker (Recomendado)

1. **Clonar el repositorio**
```bash
git clone <repository-url>
cd app_conciliacion
```

2. **Configurar variables de entorno**
```bash
cp .env.example .env
# Editar .env con sus configuraciones
```

3. **Ejecutar con Docker Compose**
```bash
# Usar el script automatizado
chmod +x scripts/start.sh
./scripts/start.sh

# O manualmente
docker-compose up --build -d
```

4. **Acceder a la aplicación**
- Frontend: http://localhost
- Backend API: http://localhost:8082/api
- Health Check: http://localhost:8082/api/actuator/health

**Para despliegue en VPS (82.112.250.211):**
- Frontend HTTPS: https://82.112.250.211
- Frontend HTTP: http://82.112.250.211 (redirige a HTTPS)
- Backend API: https://82.112.250.211/api
- Health Check: https://82.112.250.211/api/actuator/health

### Desarrollo Local

#### Backend (Spring Boot)

**Prerrequisitos:**
- Java 17 o superior
- Gradle 7.6+

**Comandos:**
```bash
cd backend

# Desarrollo con H2 (en memoria)
./gradlew bootRun

# Producción con PostgreSQL
SPRING_PROFILES_ACTIVE=production ./gradlew bootRun

# Ejecutar tests
./gradlew test

# Construir JAR
./gradlew build
```

#### Frontend (React)

**Prerrequisitos:**
- Node.js 18+
- npm 9+

**Comandos:**
```bash
cd frontend

# Instalar dependencias
npm install

# Desarrollo
npm run dev

# Construir para producción
npm run build

# Preview de producción
npm run preview

# Linting
npm run lint
```

## 🐳 Despliegue con Docker

### Desarrollo

```bash
# Construir y ejecutar todos los servicios
docker-compose up --build

# Ver logs en tiempo real
docker-compose logs -f

# Ejecutar en segundo plano
docker-compose up -d
```

### Producción

```bash
# Usar variables de entorno de producción
cp .env.example .env.production
# Configurar .env.production

# Ejecutar en producción
docker-compose --env-file .env.production up -d --build
```

### Comandos útiles de Docker

```bash
# Ver estado de contenedores
docker-compose ps

# Reiniciar servicios
docker-compose restart

# Detener servicios
docker-compose down

# Eliminar todo (incluyendo volúmenes)
docker-compose down -v --remove-orphans

# Ver logs de un servicio específico
docker-compose logs -f backend
docker-compose logs -f frontend
docker-compose logs -f database

# Acceder al contenedor backend
docker-compose exec backend bash

# Backup de la base de datos
docker-compose exec database pg_dump -U conciliacion_user conciliacion_db > backup.sql
```

## 🌐 Despliegue en VPS

### Despliegue para IP 82.112.250.211 con HTTPS

El proyecto ha sido configurado específicamente para desplegarse en el VPS con IP **82.112.250.211** usando certificados SSL auto-firmados.

### 1. Preparar el servidor

**Actualizar sistema:**
```bash
sudo apt update && sudo apt upgrade -y
sudo apt install curl wget git openssl -y
```

**Instalar Docker:**
```bash
# Desinstalar versiones antiguas
sudo apt-get remove docker docker-engine docker.io containerd runc

# Instalar Docker
curl -fsSL https://get.docker.com -o get-docker.sh
sudo sh get-docker.sh

# Agregar usuario al grupo docker
sudo usermod -aG docker $USER

# Instalar Docker Compose
sudo curl -L "https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

# Verificar instalación
docker --version
docker-compose --version
```

### 2. Configurar certificados SSL

**Crear certificados auto-firmados:**
```bash
# Crear directorio para certificados
sudo mkdir -p /etc/ssl/certs /etc/ssl/private

# Generar certificado auto-firmado para la IP
sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 \
  -keyout /etc/ssl/private/nginx-selfsigned.key \
  -out /etc/ssl/certs/nginx-selfsigned.crt \
  -subj "/C=CO/ST=Cundinamarca/L=Bogota/O=UCMC/CN=82.112.250.211"

# Configurar permisos
sudo chmod 600 /etc/ssl/private/nginx-selfsigned.key
sudo chmod 644 /etc/ssl/certs/nginx-selfsigned.crt
```

### 3. Configurar el proyecto

```bash
# Clonar repositorio
git clone <your-repository-url>
cd app_conciliacion

# El proyecto ya incluye el archivo .env configurado para la IP
# Los siguientes archivos ya están configurados:
# - docker-compose.yml (con SSL volumes y configuración corregida)
# - .env (configurado para IP 82.112.250.211)
# - nginx/nginx-ssl.conf (configuración HTTPS)
# - backend/Dockerfile (corregido para JAR copy)
# - frontend/Dockerfile (corregido para build)
```

**Variables de entorno ya configuradas en .env:**
```env
POSTGRES_DB=conciliacion_prod
POSTGRES_USER=conciliacion_admin
POSTGRES_PASSWORD=SecurePassword2024!@#$
POSTGRES_PORT=5432
FRONTEND_PORT=80
FRONTEND_SSL_PORT=443
BACKEND_PORT=8082
SPRING_PROFILES_ACTIVE=production
CORS_ALLOWED_ORIGINS=https://82.112.250.211,http://82.112.250.211
JAVA_OPTS=-Xms256m -Xmx512m
```

### 4. Configurar firewall

```bash
# Habilitar UFW
sudo ufw enable

# Permitir SSH
sudo ufw allow ssh

# Permitir HTTP y HTTPS
sudo ufw allow 80
sudo ufw allow 443

# Permitir puertos de la aplicación (opcional, solo si es necesario acceso directo)
sudo ufw allow 8082

# Ver reglas
sudo ufw status
```

### 5. Ejecutar la aplicación

```bash
# Construir y ejecutar
docker-compose up --build -d

# Verificar que todo esté funcionando
docker-compose ps
docker-compose logs -f
```

### 6. Acceder a la aplicación

Una vez desplegada, la aplicación estará disponible en:

- **Frontend HTTPS**: https://82.112.250.211 (recomendado)
- **Frontend HTTP**: http://82.112.250.211 (redirige automáticamente a HTTPS)
- **Backend API**: https://82.112.250.211/api
- **Health Check**: https://82.112.250.211/api/actuator/health

⚠️ **Nota sobre certificados auto-firmados**: Los navegadores mostrarán una advertencia de seguridad. Esto es normal con certificados auto-firmados. Haga clic en "Avanzado" → "Continuar al sitio" para acceder.

### 7. Configurar backup automático

```bash
# Crear script de backup
cat > /home/$(whoami)/backup.sh << 'EOF'
#!/bin/bash
DATE=$(date +%Y%m%d_%H%M%S)
BACKUP_DIR="/home/$(whoami)/backups"
mkdir -p $BACKUP_DIR

# Backup de la base de datos
docker-compose exec -T database pg_dump -U conciliacion_admin conciliacion_prod > $BACKUP_DIR/db_backup_$DATE.sql

# Comprimir y mantener solo los últimos 7 días
gzip $BACKUP_DIR/db_backup_$DATE.sql
find $BACKUP_DIR -name "db_backup_*.sql.gz" -mtime +7 -delete
EOF

chmod +x /home/$(whoami)/backup.sh

# Configurar cron para backup diario a las 2:00 AM
(crontab -l 2>/dev/null; echo "0 2 * * * /home/$(whoami)/backup.sh") | crontab -
```

### 8. Monitoreo y mantenimiento

**Ver logs:**
```bash
# Logs generales
docker-compose logs -f

# Logs específicos
docker-compose logs -f backend
docker-compose logs -f frontend
docker-compose logs -f database
```

**Reiniciar servicios:**
```bash
# Reinicio completo
docker-compose restart

# Reinicio de servicio específico
docker-compose restart backend

# Actualizar aplicación
git pull
docker-compose up --build -d
```

## 🤖 CI/CD con GitHub Actions

### Configuración Inicial

**1. Generar clave SSH en el VPS:**
```bash
# En el VPS (82.112.250.211)
ssh-keygen -t rsa -b 4096 -C "github-actions@deploy" -f ~/.ssh/github-actions
cat ~/.ssh/github-actions.pub >> ~/.ssh/authorized_keys
```

**2. Configurar Secrets en GitHub:**
- Ve a tu repositorio → Settings → Secrets and variables → Actions
- Agrega estos secrets:

| Secret | Valor |
|--------|-------|
| `VPS_HOST` | `82.112.250.211` |
| `VPS_USER` | `root` (o tu usuario del VPS) |
| `VPS_SSH_KEY` | (contenido completo de `~/.ssh/github-actions`) |

**3. Workflow Automático:**
El archivo `.github/workflows/deploy.yml` ya está configurado y se ejecutará automáticamente cuando:
- Hagas push a la rama `main`
- Ejecutes manualmente desde GitHub Actions

### Scripts de Mantenimiento

**Despliegue manual (si falla CI/CD):**
```bash
./manual-deploy.sh
```

**Rollback a versión anterior:**
```bash
./rollback.sh
```

**Ver estado del despliegue:**
```bash
# Ver logs de GitHub Actions
tail -f ~/deployment.log

# Estado de contenedores
docker-compose ps

# Logs específicos
docker-compose logs --tail=20 backend
```

### Flujo de Trabajo CI/CD

1. **Desarrollo** → Hacer cambios localmente
2. **Git push** → Subir cambios a GitHub
3. **GitHub Actions** → Se ejecuta automáticamente el workflow
4. **VPS** → Se actualiza automáticamente la aplicación
5. **Verificación** → La app está disponible en https://82.112.250.211

## 📝 API Endpoints

### Solicitudes de Conciliación

- `POST /api/solicitudes` - Crear nueva solicitud
- `GET /api/solicitudes/{id}` - Obtener solicitud por ID
- `PUT /api/solicitudes/{id}` - Actualizar solicitud
- `POST /api/solicitudes/generar-pdf` - Generar PDF de solicitud

### Health Check

- `GET /api/actuator/health` - Estado de la aplicación
- `GET /api/actuator/info` - Información de la aplicación

## 🔧 Configuración

### Variables de Entorno

| Variable | Descripción | Valor por defecto |
|----------|-------------|-------------------|
| `POSTGRES_DB` | Nombre de la base de datos | `conciliacion_db` |
| `POSTGRES_USER` | Usuario de PostgreSQL | `conciliacion_user` |
| `POSTGRES_PASSWORD` | Contraseña de PostgreSQL | `conciliacion_pass_2024` |
| `FRONTEND_PORT` | Puerto del frontend | `80` |
| `BACKEND_PORT` | Puerto del backend | `8082` |
| `SPRING_PROFILES_ACTIVE` | Perfil de Spring | `production` |

## 🔍 Solución de Problemas

### Backend no inicia

```bash
# Verificar logs
docker-compose logs backend

# Verificar conectividad a la base de datos
docker-compose exec backend curl localhost:8082/actuator/health
```

### Frontend no carga

```bash
# Verificar logs de nginx
docker-compose logs frontend

# Verificar que el backend esté respondiendo
curl http://localhost:8082/api/actuator/health
```

### Base de datos no conecta

```bash
# Verificar estado de PostgreSQL
docker-compose exec database pg_isready -U conciliacion_user

# Reiniciar la base de datos
docker-compose restart database
```

## 📄 Licencia

Este proyecto está bajo la Licencia MIT.

## 👥 Autores

- **Universidad Católica Mayor de Colombia (UCMC)** - *Conciliación Extrajudicial*

## 📞 Soporte

Para soporte técnico o consultas:
- 📧 Email: soporte@ucmc.edu.co
- 🌐 Web: https://www.ucmc.edu.co


DESARROLLADOR GENERAL: Anderson Felipe Montaña Castelblanco
CORREO: Andersoncastelblanco@gmail.com