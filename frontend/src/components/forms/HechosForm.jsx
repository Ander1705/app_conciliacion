import FormSection from '../ui/FormSection'
import Textarea from '../ui/Textarea'

const HechosForm = ({ formData, updateFormData, errors }) => {
  const hechosData = formData.hechos || {}

  const handleInputChange = (field, value) => {
    // Límite de 100 caracteres por hecho para garantizar PDF en 2 páginas
    const limitedValue = value.slice(0, 100)
    updateFormData('hechos', { [field]: limitedValue })
  }

  return (
    <FormSection title="HECHOS">
      <div style={{marginBottom: '1.5rem'}}>
        <p style={{fontSize: '0.875rem', color: '#6b7280', marginBottom: '1rem'}}>
          Describa de manera clara y cronológica los hechos que dieron origen al conflicto:
        </p>
      </div>

      <div style={{display: 'flex', flexDirection: 'column', gap: '1.5rem'}}>
        <Textarea
          label="PRIMERO"
          value={hechosData.primero || ''}
          onChange={(e) => handleInputChange('primero', e.target.value)}
          placeholder="Describa el primer hecho relevante... (máx. 100 caracteres)"
          rows={4}
          error={errors.primero}
          required
          maxLength={100}
        />
        <div style={{textAlign: 'right', fontSize: '0.75rem', color: '#6b7280', marginTop: '0.25rem'}}>
          {(hechosData.primero || '').length}/100 caracteres
        </div>

        <Textarea
          label="SEGUNDO"
          value={hechosData.segundo || ''}
          onChange={(e) => handleInputChange('segundo', e.target.value)}
          placeholder="Describa el segundo hecho relevante... (máx. 100 caracteres)"
          rows={4}
          error={errors.segundo}
          maxLength={100}
        />
        <div style={{textAlign: 'right', fontSize: '0.75rem', color: '#6b7280', marginTop: '0.25rem'}}>
          {(hechosData.segundo || '').length}/100 caracteres
        </div>

        <Textarea
          label="TERCERO"
          value={hechosData.tercero || ''}
          onChange={(e) => handleInputChange('tercero', e.target.value)}
          placeholder="Describa el tercer hecho relevante... (máx. 100 caracteres)"
          rows={4}
          error={errors.tercero}
          maxLength={100}
        />
        <div style={{textAlign: 'right', fontSize: '0.75rem', color: '#6b7280', marginTop: '0.25rem'}}>
          {(hechosData.tercero || '').length}/100 caracteres
        </div>

        <Textarea
          label="CUARTO"
          value={hechosData.cuarto || ''}
          onChange={(e) => handleInputChange('cuarto', e.target.value)}
          placeholder="Describa el cuarto hecho relevante... (máx. 100 caracteres)"
          rows={4}
          error={errors.cuarto}
          maxLength={100}
        />
        <div style={{textAlign: 'right', fontSize: '0.75rem', color: '#6b7280', marginTop: '0.25rem'}}>
          {(hechosData.cuarto || '').length}/100 caracteres
        </div>

        <Textarea
          label="QUINTO"
          value={hechosData.quinto || ''}
          onChange={(e) => handleInputChange('quinto', e.target.value)}
          placeholder="Describa el quinto hecho relevante... (máx. 100 caracteres)"
          rows={4}
          error={errors.quinto}
          maxLength={100}
        />
        <div style={{textAlign: 'right', fontSize: '0.75rem', color: '#6b7280', marginTop: '0.25rem'}}>
          {(hechosData.quinto || '').length}/100 caracteres
        </div>
      </div>

      <div style={{marginTop: '1.5rem', padding: '1rem', backgroundColor: '#dbeafe', borderRadius: '8px', border: '1px solid #3b82f6'}}>
        <p style={{fontSize: '0.875rem', color: '#1e40af', margin: 0}}>
          <strong>Importante:</strong> Sea específico en fechas, lugares y personas involucradas. 
          Estos hechos serán la base de su solicitud de conciliación. <strong>Máximo 100 caracteres por hecho para mantener el PDF en 2 páginas.</strong>
        </p>
      </div>
    </FormSection>
  )
}

export default HechosForm