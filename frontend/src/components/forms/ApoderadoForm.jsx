import FormSection from '../ui/FormSection'
import Input from '../ui/Input'

const ApoderadoForm = ({ formData, updateFormData, errors }) => {
  const apoderadoData = formData.apoderado || {}

  const handleInputChange = (field, value) => {
    updateFormData('apoderado', { [field]: value })
  }

  return (
    <FormSection title="SI SE ACTÚA POR APODERADO">
      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
        <Input
          label="Nombres y Apellidos"
          value={apoderadoData.nombres || ''}
          onChange={(e) => handleInputChange('nombres', e.target.value)}
          error={errors.nombres}
        />
        <Input
          label="C.C."
          value={apoderadoData.cc || ''}
          onChange={(e) => handleInputChange('cc', e.target.value)}
          error={errors.cc}
        />
        <Input
          label="T.P. (Tarjeta Profesional)"
          value={apoderadoData.tp || ''}
          onChange={(e) => handleInputChange('tp', e.target.value)}
          error={errors.tp}
        />
      </div>

      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
        <Input
          label="Dirección"
          value={apoderadoData.direccion || ''}
          onChange={(e) => handleInputChange('direccion', e.target.value)}
          error={errors.direccion}
        />
        <Input
          label="Ciudad"
          value={apoderadoData.ciudad || ''}
          onChange={(e) => handleInputChange('ciudad', e.target.value)}
          error={errors.ciudad}
        />
        <Input
          label="Teléfono"
          value={apoderadoData.telefono || ''}
          onChange={(e) => handleInputChange('telefono', e.target.value)}
          placeholder="Ej: 6012345678"
          error={errors.telefono}
        />
        <Input
          label="Correo Electrónico"
          type="email"
          value={apoderadoData.correo || ''}
          onChange={(e) => handleInputChange('correo', e.target.value)}
          error={errors.correo}
        />
      </div>
    </FormSection>
  )
}

export default ApoderadoForm