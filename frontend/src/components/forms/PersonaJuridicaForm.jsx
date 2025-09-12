import FormSection from '../ui/FormSection'
import Input from '../ui/Input'

const PersonaJuridicaForm = ({ formData, updateFormData, errors }) => {
  const empresaData = formData.empresa || {}

  const handleInputChange = (field, value) => {
    updateFormData('empresa', { [field]: value })
  }

  return (
    <FormSection title="DATOS DEL CONVOCADO (PERSONA JURÍDICA)">
      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
        <Input
          label="Nombre de la Empresa"
          value={empresaData.nombre || ''}
          onChange={(e) => handleInputChange('nombre', e.target.value)}
          error={errors.nombre}
        />
        <Input
          label="NIT"
          value={empresaData.nit || ''}
          onChange={(e) => handleInputChange('nit', e.target.value)}
          placeholder="Ej: 900123456-7"
          error={errors.nit}
        />
        <Input
          label="Representante Legal"
          value={empresaData.representante || ''}
          onChange={(e) => handleInputChange('representante', e.target.value)}
          error={errors.representante}
        />
        <Input
          label="C.C. Representante"
          value={empresaData.ccRepresentante || ''}
          onChange={(e) => handleInputChange('ccRepresentante', e.target.value)}
          error={errors.ccRepresentante}
        />
      </div>

      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
        <Input
          label="Dirección"
          value={empresaData.direccion || ''}
          onChange={(e) => handleInputChange('direccion', e.target.value)}
          error={errors.direccion}
        />
        <Input
          label="Teléfono"
          value={empresaData.telefono || ''}
          onChange={(e) => handleInputChange('telefono', e.target.value)}
          placeholder="Ej: 6012345678"
          error={errors.telefono}
        />
        <Input
          label="Correo Electrónico"
          type="email"
          value={empresaData.correo || ''}
          onChange={(e) => handleInputChange('correo', e.target.value)}
          error={errors.correo}
        />
      </div>
    </FormSection>
  )
}

export default PersonaJuridicaForm