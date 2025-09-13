import escudo from '../../assets/escudo.png'

const Header = () => {
  return (
    <header style={{
      backgroundColor: '#003366',
      color: 'white',
      padding: '1.5rem 1rem',
      borderBottom: '3px solid #FFD700',
      boxShadow: '0 2px 4px rgba(0,0,0,0.1)'
    }}>
      <div style={{ maxWidth: '1200px', margin: '0 auto' }}>
        <div style={{ 
          display: 'flex', 
          alignItems: 'center', 
          gap: '1.5rem',
          marginBottom: '1rem',
          flexWrap: 'wrap'
        }}>
          <img 
            src={escudo} 
            alt="Universidad Colegio Mayor de Cundinamarca" 
            style={{
              height: '4rem',
              width: 'auto',
              objectFit: 'contain'
            }}
          />
          
          <div style={{ flex: 1, textAlign: 'center' }}>
            <h1 style={{ 
              fontSize: '1.4rem', 
              fontWeight: '700', 
              margin: '0 0 0.5rem 0',
              lineHeight: '1.2'
            }}>
              UNIVERSIDAD COLEGIO MAYOR DE CUNDINAMARCA
            </h1>
            <h2 style={{ 
              fontSize: '1.1rem', 
              fontWeight: '600', 
              color: '#FFD700',
              margin: '0 0 0.25rem 0'
            }}>
              CENTRO DE CONCILIACIÓN
            </h2>
            <p style={{ 
              fontSize: '0.8rem', 
              opacity: '0.9',
              margin: '0'
            }}>
              SOLICITUD DE CONCILIACIÓN - MPMFO-04 Versión 2
            </p>
          </div>
        </div>
        
        <div style={{ 
          display: 'flex', 
          justifyContent: 'center', 
          gap: '2rem',
          fontSize: '0.8rem',
          opacity: '0.9',
          flexWrap: 'wrap'
        }}>
          <span>📍 Diagonal 34 No. 5-71, Bogotá D.C.</span>
          <span>📞 2457169</span>
          <span>✉️ conciliacion@universidadmayor.edu.co</span>
        </div>
      </div>
    </header>
  )
}

export default Header