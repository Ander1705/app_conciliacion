import escudo from '../../assets/escudo.png'

const Header = () => {
  return (
    <header className="university-header">
      <div className="header-container">
        {/* Banner superior */}
        <div className="header-banner">
          <span className="service-badge">Servicio Gratuito</span>
        </div>
        
        {/* Contenido principal del header */}
        <div className="header-main">
          <div className="header-content">
            {/* Logo y título principal */}
            <div className="header-identity">
              <div className="logo-container">
                <img 
                  src={escudo} 
                  alt="Universidad Colegio Mayor de Cundinamarca" 
                  className="university-logo"
                />
              </div>
              <div className="title-section">
                <h1 className="university-title">UNIVERSIDAD COLEGIO MAYOR DE CUNDINAMARCA</h1>
                <h2 className="center-title">CENTRO DE CONCILIACIÓN</h2>
                <p className="subtitle">Resolución No. 2099 de diciembre 12 de 2003 Ministerio del Interior y de Justicia – Código 05 110012180</p>
              </div>
            </div>
            
            {/* Información de contacto */}
            <div className="contact-info">
              <div className="contact-item">
                <span className="contact-icon">📍</span>
                <span>Diagonal 34 No. 5-71, Bogotá D.C.</span>
              </div>
              <div className="contact-item">
                <span className="contact-icon">📞</span>
                <span>Teléfono: 2457169</span>
              </div>
              <div className="contact-item">
                <span className="contact-icon">✉️</span>
                <span>conciliacion@universidadmayor.edu.co</span>
              </div>
            </div>
          </div>
        </div>
        
        {/* Footer del header */}
        <div className="header-footer">
          <div className="document-title">
            <h3>SOLICITUD DE CONCILIACIÓN</h3>
          </div>
          <div className="document-info">
            <span className="document-code">MPMFO-04 Versión 2</span>
          </div>
        </div>
      </div>
    </header>
  )
}

export default Header