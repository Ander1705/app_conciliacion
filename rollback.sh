#!/bin/bash
# Find last successful backup
LAST_BACKUP=$(ls -t ~/backup-*.log 2>/dev/null | head -1)
if [ -n "$LAST_BACKUP" ]; then
    echo "Rolling back to state from: $LAST_BACKUP"
else
    echo "No backup found, showing recent commits"
fi

cd ~/app_conciliacion

# Get previous commit
echo "📋 Recent commits:"
git log --oneline -10
echo ""
echo "Enter commit hash to rollback to:"
read COMMIT_HASH

if [ -z "$COMMIT_HASH" ]; then
    echo "❌ No commit hash provided, aborting rollback"
    exit 1
fi

echo "🔄 Rolling back to commit: $COMMIT_HASH"
git checkout $COMMIT_HASH

echo "🛑 Stopping current services..."
docker-compose down

echo "🔨 Building and starting with previous version..."
docker-compose up --build -d

echo "⏳ Waiting for services to start..."
sleep 30

# Health check
if curl -f http://localhost:8082/api/ > /dev/null 2>&1; then
    echo "✅ Rollback successful!"
    docker-compose ps
else
    echo "❌ Rollback failed - services not responding"
    docker-compose logs --tail=20
    exit 1
fi