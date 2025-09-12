import FormSection from '../ui/FormSection'
import Input from '../ui/Input'

const NotificacionesForm = ({ formData, updateFormData, errors }) => {
  const notificacionesData = formData.notificaciones || {}

  const handleSolicitanteChange = (field, value) => {
    updateFormData('notificaciones', { 
      ...notificacionesData, 
      solicitante: { 
        ...notificacionesData.solicitante, 
        [field]: value 
      }
    })
  }

  const handleApoderadoChange = (field, value) => {
    updateFormData('notificaciones', { 
      ...notificacionesData, 
      apoderado: { 
        ...notificacionesData.apoderado, 
        [field]: value 
      }
    })
  }

  const handleSolicitadosChange = (field, value) => {
    updateFormData('notificaciones', { 
      ...notificacionesData, 
      solicitados: { 
        ...notificacionesData.solicitados, 
        [field]: value 
      }
    })
  }

  const solicitanteData = notificacionesData.solicitante || {}
  const apoderadoData = notificacionesData.apoderado || {}
  const solicitadosData = notificacionesData.solicitados || {}

  return (
    <div style={{display: 'flex', flexDirection: 'column', gap: '2rem'}}>
      {/* Solicitante(s) */}
      <FormSection title="NOTIFICACIONES - SOLICITANTE(S)">
        <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
          <Input
            label="Nombres Completos"
            value={solicitanteData.nombres || ''}
            onChange={(e) => handleSolicitanteChange('nombres', e.target.value)}
            error={errors.solicitanteNombres}
            required
          />
          <Input
            label="Dirección"
            value={solicitanteData.direccion || ''}
            onChange={(e) => handleSolicitanteChange('direccion', e.target.value)}
            error={errors.solicitanteDireccion}
            required
          />
          <Input
            label="Ciudad"
            value={solicitanteData.ciudad || ''}
            onChange={(e) => handleSolicitanteChange('ciudad', e.target.value)}
            error={errors.solicitanteCiudad}
            required
          />
        </div>

        <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
          <Input
            label="Teléfonos"
            value={solicitanteData.telefonos || ''}
            onChange={(e) => handleSolicitanteChange('telefonos', e.target.value)}
            placeholder="Ej: 6012345678"
            error={errors.solicitanteTelefonos}
          />
          <Input
            label="Celulares"
            value={solicitanteData.celulares || ''}
            onChange={(e) => handleSolicitanteChange('celulares', e.target.value)}
            placeholder="Ej: 3001234567"
            error={errors.solicitanteCelulares}
          />
          <Input
            label="Correo Electrónico"
            type="email"
            value={solicitanteData.correo || ''}
            onChange={(e) => handleSolicitanteChange('correo', e.target.value)}
            error={errors.solicitanteCorreo}
            required
          />
        </div>
      </FormSection>

      {/* Apoderado Solicitante(s) */}
      <FormSection title="APODERADO SOLICITANTE(S)">
        <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
          <Input
            label="Nombres Completos"
            value={apoderadoData.nombres || ''}
            onChange={(e) => handleApoderadoChange('nombres', e.target.value)}
            error={errors.apoderadoNombres}
          />
          <Input
            label="Domicilio Profesional"
            value={apoderadoData.domicilio || ''}
            onChange={(e) => handleApoderadoChange('domicilio', e.target.value)}
            error={errors.apoderadoDomicilio}
          />
          <Input
            label="Ciudad"
            value={apoderadoData.ciudad || ''}
            onChange={(e) => handleApoderadoChange('ciudad', e.target.value)}
            error={errors.apoderadoCiudad}
          />
        </div>

        <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
          <Input
            label="C.C."
            value={apoderadoData.cc || ''}
            onChange={(e) => handleApoderadoChange('cc', e.target.value)}
            error={errors.apoderadoCc}
          />
          <Input
            label="T.P. (Tarjeta Profesional)"
            value={apoderadoData.tp || ''}
            onChange={(e) => handleApoderadoChange('tp', e.target.value)}
            error={errors.apoderadoTp}
          />
          <Input
            label="Teléfonos"
            value={apoderadoData.telefonos || ''}
            onChange={(e) => handleApoderadoChange('telefonos', e.target.value)}
            placeholder="Ej: 6012345678"
            error={errors.apoderadoTelefonos}
          />
        </div>

        <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
          <Input
            label="Celulares"
            value={apoderadoData.celulares || ''}
            onChange={(e) => handleApoderadoChange('celulares', e.target.value)}
            placeholder="Ej: 3001234567"
            error={errors.apoderadoCelulares}
          />
          <Input
            label="Correo Electrónico"
            type="email"
            value={apoderadoData.correo || ''}
            onChange={(e) => handleApoderadoChange('correo', e.target.value)}
            error={errors.apoderadoCorreo}
          />
        </div>
      </FormSection>

      {/* Solicitados */}
      <FormSection title="SOLICITADOS">
        <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
          <Input
            label="Nombres Completos"
            value={solicitadosData.nombres || ''}
            onChange={(e) => handleSolicitadosChange('nombres', e.target.value)}
            error={errors.solicitadosNombres}
            required
          />
          <Input
            label="Dirección"
            value={solicitadosData.direccion || ''}
            onChange={(e) => handleSolicitadosChange('direccion', e.target.value)}
            error={errors.solicitadosDireccion}
            required
          />
          <Input
            label="Ciudad"
            value={solicitadosData.ciudad || ''}
            onChange={(e) => handleSolicitadosChange('ciudad', e.target.value)}
            error={errors.solicitadosCiudad}
            required
          />
        </div>

        <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
          <Input
            label="Teléfonos"
            value={solicitadosData.telefonos || ''}
            onChange={(e) => handleSolicitadosChange('telefonos', e.target.value)}
            placeholder="Ej: 6012345678"
            error={errors.solicitadosTelefonos}
          />
          <Input
            label="Celulares"
            value={solicitadosData.celulares || ''}
            onChange={(e) => handleSolicitadosChange('celulares', e.target.value)}
            placeholder="Ej: 3001234567"
            error={errors.solicitadosCelulares}
          />
          <Input
            label="Correo Electrónico"
            type="email"
            value={solicitadosData.correo || ''}
            onChange={(e) => handleSolicitadosChange('correo', e.target.value)}
            error={errors.solicitadosCorreo}
          />
        </div>
      </FormSection>

      <div style={{padding: '1rem', backgroundColor: '#dbeafe', borderRadius: '8px', border: '1px solid #3b82f6'}}>
        <p style={{fontSize: '0.875rem', color: '#1e40af', margin: 0}}>
          <strong>Importante:</strong> Los datos de contacto son fundamentales para el proceso de conciliación. 
          Asegúrese de que toda la información sea correcta y actualizada.
        </p>
      </div>
    </div>
  )
}

export default NotificacionesForm