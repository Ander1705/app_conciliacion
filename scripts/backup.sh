#!/bin/bash
DATE=$(date +%Y%m%d_%H%M%S)
BACKUP_DIR="$HOME/backups"
mkdir -p $BACKUP_DIR

echo "Iniciando backup de base de datos..."

# Backup de PostgreSQL
docker-compose exec -T database pg_dump -U conciliacion_admin conciliacion_prod > $BACKUP_DIR/db_backup_$DATE.sql

# Comprimir backup
gzip $BACKUP_DIR/db_backup_$DATE.sql

# Mantener solo últimos 7 días
find $BACKUP_DIR -name "db_backup_*.sql.gz" -mtime +7 -delete

echo "Backup completado: $BACKUP_DIR/db_backup_$DATE.sql.gz"