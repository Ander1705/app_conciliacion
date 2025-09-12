#!/bin/bash
set -e

echo "🚀 Manual deployment started at $(date)"

cd ~/app_conciliacion

# Backup
docker-compose ps > ~/manual-backup-$(date +%Y%m%d_%H%M%S).log

# Pull changes
git pull origin main

# Deploy
docker-compose down
docker-compose up --build -d

# Wait and check
sleep 30
if curl -f http://localhost:8082/api/ > /dev/null 2>&1; then
    echo "✅ Manual deployment successful!"
    docker-compose ps
else
    echo "❌ Manual deployment failed"
    docker-compose logs --tail=20
    exit 1
fi