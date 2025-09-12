import FormSection from '../ui/FormSection'
import Input from '../ui/Input'

const ResumenForm = ({ formData, updateFormData, errors }) => {
  const firmasData = formData.firmas || {}

  const handleFirmaChange = (field, value) => {
    updateFormData('firmas', { [field]: value })
  }

  return (
    <div style={{display: 'flex', flexDirection: 'column', gap: '2rem'}}>
      {/* Resumen de la Solicitud */}
      <FormSection title="RESUMEN DE LA SOLICITUD">
        <div style={{padding: '1.5rem', backgroundColor: '#f8fafc', border: '1px solid #e2e8f0', borderRadius: '8px'}}>
          <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1rem', marginBottom: '1rem'}}>
            <div>
              <span style={{fontSize: '0.75rem', color: '#6b7280', textTransform: 'uppercase', fontWeight: '600'}}>
                Ciudad y Fecha
              </span>
              <p style={{fontSize: '0.875rem', color: '#374151', margin: '0.25rem 0'}}>
                {formData.general?.ciudadFecha || 'No especificado'}
              </p>
            </div>
            <div>
              <span style={{fontSize: '0.75rem', color: '#6b7280', textTransform: 'uppercase', fontWeight: '600'}}>
                Convocante
              </span>
              <p style={{fontSize: '0.875rem', color: '#374151', margin: '0.25rem 0'}}>
                {`${formData.convocante?.primerNombre || ''} ${formData.convocante?.primerApellido || ''}`}
              </p>
            </div>
            <div>
              <span style={{fontSize: '0.75rem', color: '#6b7280', textTransform: 'uppercase', fontWeight: '600'}}>
                Convocado
              </span>
              <p style={{fontSize: '0.875rem', color: '#374151', margin: '0.25rem 0'}}>
                {`${formData.convocado?.primerNombre || ''} ${formData.convocado?.primerApellido || ''}`}
              </p>
            </div>
          </div>
          
          <div style={{marginBottom: '1rem'}}>
            <span style={{fontSize: '0.75rem', color: '#6b7280', textTransform: 'uppercase', fontWeight: '600'}}>
              Áreas del Conflicto
            </span>
            <p style={{fontSize: '0.875rem', color: '#374151', margin: '0.25rem 0'}}>
              {Object.entries(formData.area || {})
                .filter(([key, value]) => value === true)
                .map(([key]) => key.toUpperCase())
                .join(', ') || 'No especificado'}
            </p>
          </div>
          
          <div style={{marginBottom: '1rem'}}>
            <span style={{fontSize: '0.75rem', color: '#6b7280', textTransform: 'uppercase', fontWeight: '600'}}>
              Cuantía
            </span>
            <p style={{fontSize: '0.875rem', color: '#374151', margin: '0.25rem 0'}}>
              {formData.cuantia?.indeterminada 
                ? 'Indeterminada/sin cuantía' 
                : `$${formData.cuantia?.estimada || 'No especificado'}`}
            </p>
          </div>
        </div>
      </FormSection>

      {/* Información Adicional */}
      <FormSection title="INFORMACIÓN ADICIONAL">
        <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(250px, 1fr))', gap: '1.5rem'}}>
          <Input
            label="C.C. No."
            value={firmasData.solicitanteCc || ''}
            onChange={(e) => handleFirmaChange('solicitanteCc', e.target.value)}
            placeholder="Número de cédula del solicitante"
            error={errors.solicitanteCc}
            required
          />

          <Input
            label="Asesor (Nombre y Celular)"
            value={firmasData.asesorNombreCelular || ''}
            onChange={(e) => handleFirmaChange('asesorNombreCelular', e.target.value)}
            placeholder="Ej: Juan Pérez - 3001234567"
            error={errors.asesorNombreCelular}
          />
        </div>
      </FormSection>

      {/* Términos y Condiciones */}
      <div style={{padding: '1.5rem', backgroundColor: '#fef7cd', border: '1px solid #f59e0b', borderRadius: '8px'}}>
        <h4 style={{color: '#92400e', fontSize: '1rem', fontWeight: '600', marginBottom: '1rem'}}>
          Declaración y Autorización
        </h4>
        <div style={{fontSize: '0.875rem', color: '#92400e', lineHeight: '1.6'}}>
          <p style={{marginBottom: '0.5rem'}}>
            • Declaro bajo la gravedad del juramento que la información suministrada es veraz.
          </p>
          <p style={{marginBottom: '0.5rem'}}>
            • Autorizo el tratamiento de mis datos personales conforme a la Ley 1581 de 2012.
          </p>
          <p style={{marginBottom: '0.5rem'}}>
            • Acepto que la Universidad Colegio Mayor de Cundinamarca actúe como centro de conciliación.
          </p>
          <p style={{margin: 0}}>
            • Entiendo que este es un servicio gratuito y me comprometo a asistir a las audiencias programadas.
          </p>
        </div>
      </div>

      {/* Botón para generar PDF */}
      <div style={{padding: '1.5rem', backgroundColor: '#dbeafe', border: '1px solid #3b82f6', borderRadius: '8px', textAlign: 'center'}}>
        <h4 style={{color: '#1e40af', fontSize: '1.125rem', fontWeight: '600', marginBottom: '0.5rem'}}>
          ¡Listo para Generar!
        </h4>
        <p style={{color: '#1e40af', fontSize: '0.875rem', margin: 0}}>
          Su solicitud está completa y lista para generar el PDF oficial.
        </p>
      </div>
    </div>
  )
}

export default ResumenForm