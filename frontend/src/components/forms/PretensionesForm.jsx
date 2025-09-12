import FormSection from '../ui/FormSection'
import Textarea from '../ui/Textarea'

const PretensionesForm = ({ formData, updateFormData, errors }) => {
  const pretensionesData = formData.pretensiones || {}

  const handleInputChange = (field, value) => {
    // Límite de 100 caracteres por pretensión para garantizar PDF en 2 páginas
    const limitedValue = value.slice(0, 100)
    updateFormData('pretensiones', { [field]: limitedValue })
  }

  return (
    <FormSection title="PRETENSIONES">
      <div style={{marginBottom: '1.5rem'}}>
        <p style={{fontSize: '0.875rem', color: '#6b7280', marginBottom: '1rem'}}>
          Indique claramente qué espera obtener con esta conciliación. 
          Especifique sus pretensiones de manera concreta y realizable:
        </p>
      </div>

      <div style={{display: 'flex', flexDirection: 'column', gap: '1.5rem'}}>
        <Textarea
          label="PRIMERA"
          value={pretensionesData.primera || ''}
          onChange={(e) => handleInputChange('primera', e.target.value)}
          placeholder="Indique su primera pretensión... (máx. 100 caracteres)"
          rows={4}
          error={errors.primera}
          required
          maxLength={100}
        />
        <div style={{textAlign: 'right', fontSize: '0.75rem', color: '#6b7280', marginTop: '0.25rem'}}>
          {(pretensionesData.primera || '').length}/100 caracteres
        </div>

        <Textarea
          label="SEGUNDA"
          value={pretensionesData.segunda || ''}
          onChange={(e) => handleInputChange('segunda', e.target.value)}
          placeholder="Indique su segunda pretensión... (máx. 100 caracteres)"
          rows={4}
          error={errors.segunda}
          maxLength={100}
        />
        <div style={{textAlign: 'right', fontSize: '0.75rem', color: '#6b7280', marginTop: '0.25rem'}}>
          {(pretensionesData.segunda || '').length}/100 caracteres
        </div>

        <Textarea
          label="TERCERA"
          value={pretensionesData.tercera || ''}
          onChange={(e) => handleInputChange('tercera', e.target.value)}
          placeholder="Indique su tercera pretensión... (máx. 100 caracteres)"
          rows={4}
          error={errors.tercera}
          maxLength={100}
        />
        <div style={{textAlign: 'right', fontSize: '0.75rem', color: '#6b7280', marginTop: '0.25rem'}}>
          {(pretensionesData.tercera || '').length}/100 caracteres
        </div>
      </div>

      <div style={{marginTop: '1.5rem', padding: '1rem', backgroundColor: '#fef3c7', borderRadius: '8px', border: '1px solid #f59e0b'}}>
        <p style={{fontSize: '0.875rem', color: '#92400e', margin: 0}}>
          <strong>Recomendación:</strong> Las pretensiones deben ser claras, específicas y factibles. 
          Evite pretensiones que no puedan ser objeto de conciliación (como asuntos penales no conciliables). 
          <strong>Máximo 100 caracteres por pretensión para mantener el PDF en 2 páginas.</strong>
        </p>
      </div>
    </FormSection>
  )
}

export default PretensionesForm