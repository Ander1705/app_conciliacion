import escudo from '../../assets/escudo.png'

const Header = () => {
  return (
    <header className="university-header" style={{padding: '1.5rem 1rem'}}>
      <div style={{maxWidth: '64rem', margin: '0 auto'}}>
        <div style={{display: 'flex', alignItems: 'center', justifyContent: 'center', marginBottom: '1rem'}}>
          <img 
            src={escudo} 
            alt="Universidad Colegio Mayor de Cundinamarca" 
            style={{height: '4rem', width: '4rem', marginRight: '1rem'}}
          />
          <div style={{textAlign: 'center'}}>
            <h1 style={{fontSize: '1.5rem', fontWeight: 'bold', marginBottom: '0.25rem'}}>CENTRO DE CONCILIACIÓN</h1>
            <p style={{fontSize: '0.875rem', opacity: 0.9}}>Universidad Colegio Mayor de Cundinamarca</p>
          </div>
        </div>
        
        <div style={{textAlign: 'center', fontSize: '0.875rem'}}>
          <p style={{marginBottom: '0.25rem'}}>Resolución No. 2099 de diciembre 12 de 2003</p>
          <p style={{marginBottom: '0.25rem'}}>Diagonal 34 No. 5-71 Teléfono 2457169 Bogotá, D.C.</p>
          <p style={{marginBottom: '0.5rem'}}>conciliacion@universidadmayor.edu.co</p>
          <div style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginTop: '0.5rem', paddingTop: '0.5rem', borderTop: '1px solid #60a5fa'}}>
            <span>Código: MPMFO-04 Versión 2</span>
            <span style={{backgroundColor: 'var(--color-university-gold)', color: 'var(--color-university-blue)', padding: '0.25rem 0.5rem', borderRadius: '0.25rem', fontSize: '0.75rem', fontWeight: '600'}}>
              Servicio Gratuito
            </span>
          </div>
        </div>
      </div>
    </header>
  )
}

export default Header