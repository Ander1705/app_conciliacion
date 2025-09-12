#!/bin/bash
echo "🧪 Testing API endpoints..."

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Test function
test_endpoint() {
    local url=$1
    local description=$2
    local expected_code=${3:-200}
    
    echo -n "Testing $description... "
    
    response=$(curl -s -w "%{http_code}" "$url")
    http_code="${response: -3}"
    
    if [ "$http_code" = "$expected_code" ]; then
        echo -e "${GREEN}✅ PASS${NC} ($http_code)"
        return 0
    else
        echo -e "${RED}❌ FAIL${NC} ($http_code)"
        return 1
    fi
}

# Test CORS with OPTIONS preflight
test_cors() {
    local url=$1
    local origin=$2
    local description=$3
    
    echo -n "Testing CORS for $description... "
    
    response=$(curl -s -I -X OPTIONS \
        -H "Origin: $origin" \
        -H "Access-Control-Request-Method: POST" \
        -H "Access-Control-Request-Headers: Content-Type" \
        "$url")
    
    if echo "$response" | grep -q "Access-Control-Allow-Origin"; then
        echo -e "${GREEN}✅ PASS${NC}"
        return 0
    else
        echo -e "${RED}❌ FAIL${NC}"
        echo "Response headers:"
        echo "$response"
        return 1
    fi
}

BASE_URL="https://82.112.250.211"
API_URL="$BASE_URL/api"

echo "🔍 Testing endpoints for: $BASE_URL"
echo "=========================================="

# Test frontend
test_endpoint "$BASE_URL/" "Frontend (HTTPS)"

# Test backend health check via proxy
test_endpoint "$BASE_URL/actuator/health" "Backend health via nginx proxy"

# Test API root
test_endpoint "$API_URL/" "API root via proxy"

# Test CORS for different origins
echo ""
echo "🌐 Testing CORS configuration..."
echo "=================================="
test_cors "$API_URL/solicitudes" "$BASE_URL" "VPS HTTPS origin"
test_cors "$API_URL/solicitudes" "http://82.112.250.211" "VPS HTTP origin"
test_cors "$API_URL/solicitudes" "http://localhost:5173" "Local dev origin"

# Test PDF generation endpoint (should return 404 or 405 for GET, but not CORS error)
echo ""
echo "📄 Testing PDF generation endpoint..."
echo "====================================="
test_endpoint "$API_URL/solicitudes/generar-pdf" "PDF generation endpoint" 405

echo ""
echo "🏁 API testing completed!"
echo ""
echo "💡 If you see CORS failures, run: docker-compose restart backend"
echo "💡 If frontend fails, check: docker-compose logs frontend"
echo "💡 If backend fails, check: docker-compose logs backend"