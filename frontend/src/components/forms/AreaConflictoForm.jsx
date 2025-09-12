import FormSection from '../ui/FormSection'
import MultiSelect from '../ui/MultiSelect'

const AreaConflictoForm = ({ formData, updateFormData, errors }) => {
  const areaData = formData.area || {}

  const areasOptions = [
    {
      key: 'civil',
      label: 'CIVIL',
      description: 'Contratos, responsabilidad civil, daños y perjuicios'
    },
    {
      key: 'familia',
      label: 'FAMILIA', 
      description: 'Alimentos, custodia, régimen de visitas, patrimonio familiar'
    },
    {
      key: 'comercial',
      label: 'COMERCIAL',
      description: 'Contratos mercantiles, sociedades, títulos valores'
    },
    {
      key: 'penal',
      label: 'PENAL',
      description: 'Delitos querellables y conciliables'
    },
    {
      key: 'convivencia',
      label: 'CONVIVENCIA',
      description: 'Conflictos comunitarios, vecinales, propiedad horizontal'
    }
  ]

  return (
    <FormSection title="ÁREA DEL CONFLICTO">
      <div style={{marginBottom: '1rem'}}>
        <p style={{fontSize: '0.875rem', color: '#6b7280', marginBottom: '1.5rem'}}>
          Seleccione el área o áreas que corresponden al conflicto a conciliar:
        </p>
        
        <MultiSelect
          label="Áreas del Conflicto"
          options={areasOptions}
          values={areaData}
          onChange={(key, value) => updateFormData('area', { [key]: value })}
          error={errors.area}
          required
        />

        <div style={{marginTop: '1.5rem', padding: '1rem', backgroundColor: '#fef3c7', borderRadius: '8px', border: '1px solid #f59e0b'}}>
          <p style={{fontSize: '0.875rem', color: '#92400e', margin: 0}}>
            <strong>Nota:</strong> Debe seleccionar al menos un área del conflicto para continuar.
          </p>
        </div>
      </div>
    </FormSection>
  )
}

export default AreaConflictoForm