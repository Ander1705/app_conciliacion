import { useEffect } from 'react'
import Button from './Button'

const PdfConfirmationModal = ({ isOpen, onClose, onDownload, pdfResult }) => {
  useEffect(() => {
    const handleEscape = (e) => {
      if (e.key === 'Escape') {
        onClose()
      }
    }

    if (isOpen) {
      document.addEventListener('keydown', handleEscape)
      document.body.style.overflow = 'hidden'
    } else {
      document.body.style.overflow = 'unset'
    }

    return () => {
      document.removeEventListener('keydown', handleEscape)
      document.body.style.overflow = 'unset'
    }
  }, [isOpen, onClose])

  if (!isOpen) return null

  const handleBackdropClick = (e) => {
    if (e.target === e.currentTarget) {
      onClose()
    }
  }

  const handleDownloadAndClose = () => {
    onDownload()
    onClose()
  }

  return (
    <div 
      style={{
        position: 'fixed',
        top: 0,
        left: 0,
        right: 0,
        bottom: 0,
        backgroundColor: 'rgba(0, 0, 0, 0.5)',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        zIndex: 1000,
        padding: '1rem'
      }}
      onClick={handleBackdropClick}
    >
      <div 
        style={{
          backgroundColor: 'white',
          borderRadius: '12px',
          padding: '2rem',
          maxWidth: '500px',
          width: '100%',
          boxShadow: '0 25px 50px -12px rgba(0, 0, 0, 0.25)',
          position: 'relative'
        }}
        onClick={(e) => e.stopPropagation()}
      >
        {/* Icono de éxito */}
        <div style={{
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center',
          marginBottom: '1.5rem'
        }}>
          <div style={{
            width: '4rem',
            height: '4rem',
            backgroundColor: '#d1fae5',
            borderRadius: '50%',
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center'
          }}>
            <svg 
              width="24" 
              height="24" 
              viewBox="0 0 24 24" 
              fill="none" 
              stroke="#10b981" 
              strokeWidth="2"
            >
              <path d="M20 6L9 17l-5-5"/>
            </svg>
          </div>
        </div>

        {/* Título */}
        <h2 style={{
          fontSize: '1.5rem',
          fontWeight: '600',
          textAlign: 'center',
          color: '#111827',
          marginBottom: '0.5rem'
        }}>
          ¡PDF Generado Exitosamente!
        </h2>

        {/* Mensaje */}
        <p style={{
          fontSize: '1rem',
          color: '#6b7280',
          textAlign: 'center',
          marginBottom: '2rem',
          lineHeight: '1.5'
        }}>
          Su solicitud de conciliación ha sido generada correctamente. 
          Puede descargar el documento PDF o visualizarlo antes de descargarlo.
        </p>

        {/* Información del archivo */}
        {pdfResult?.fileName && (
          <div style={{
            backgroundColor: '#f9fafb',
            border: '1px solid #e5e7eb',
            borderRadius: '8px',
            padding: '1rem',
            marginBottom: '2rem'
          }}>
            <div style={{
              fontSize: '0.875rem',
              color: '#374151',
              marginBottom: '0.25rem'
            }}>
              <strong>Archivo:</strong>
            </div>
            <div style={{
              fontSize: '0.875rem',
              color: '#6b7280',
              fontFamily: 'monospace'
            }}>
              {pdfResult.fileName}
            </div>
          </div>
        )}

        {/* Botones */}
        <div style={{
          display: 'flex',
          gap: '1rem',
          justifyContent: 'center',
          flexWrap: 'wrap'
        }}>
          {pdfResult?.pdfUrl && (
            <Button
              variant="secondary"
              onClick={() => window.open(pdfResult.pdfUrl, '_blank')}
              style={{ minWidth: '140px' }}
            >
              Ver PDF
            </Button>
          )}
          
          <Button
            variant="primary"
            onClick={handleDownloadAndClose}
            style={{ minWidth: '140px' }}
          >
            Descargar PDF
          </Button>
        </div>

        {/* Botón cerrar */}
        <button
          onClick={onClose}
          style={{
            position: 'absolute',
            top: '1rem',
            right: '1rem',
            backgroundColor: 'transparent',
            border: 'none',
            color: '#9ca3af',
            cursor: 'pointer',
            padding: '0.5rem',
            borderRadius: '4px',
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center'
          }}
          onMouseOver={(e) => e.target.style.backgroundColor = '#f3f4f6'}
          onMouseOut={(e) => e.target.style.backgroundColor = 'transparent'}
        >
          <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
            <line x1="18" y1="6" x2="6" y2="18"></line>
            <line x1="6" y1="6" x2="18" y2="18"></line>
          </svg>
        </button>
      </div>
    </div>
  )
}

export default PdfConfirmationModal