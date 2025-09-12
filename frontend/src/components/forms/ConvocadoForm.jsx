import FormSection from '../ui/FormSection'
import Input from '../ui/Input'
import Select from '../ui/Select'
import Checkbox from '../ui/Checkbox'
import { CIVIL_STATUS_OPTIONS, EDUCATION_LEVELS } from '../../utils/constants'

const ConvocadoForm = ({ formData, updateFormData, errors }) => {
  const convocadoData = formData.convocado || {}

  const handleInputChange = (field, value) => {
    updateFormData('convocado', { [field]: value })
  }

  const tiposDocumento = [
    { value: 'CC', label: 'Cédula de Ciudadanía' },
    { value: 'CE', label: 'Cédula de Extranjería' },
    { value: 'Pasaporte', label: 'Pasaporte' }
  ]

  const generos = [
    { value: 'Masculino', label: 'Masculino' },
    { value: 'Femenino', label: 'Femenino' },
    { value: 'Transgénero', label: 'Transgénero' }
  ]

  const sexos = [
    { value: 'Hombre', label: 'Hombre' },
    { value: 'Mujer', label: 'Mujer' },
    { value: 'Intersexual', label: 'Intersexual' }
  ]

  const estratos = [
    { value: '1', label: 'Estrato 1' },
    { value: '2', label: 'Estrato 2' },
    { value: '3', label: 'Estrato 3' },
    { value: '4', label: 'Estrato 4' },
    { value: '5', label: 'Estrato 5' },
    { value: '6', label: 'Estrato 6' }
  ]

  return (
    <FormSection title="DATOS DEL CONVOCADO">
      {/* Nombres y Apellidos */}
      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
        <Input
          label="Primer Nombre"
          value={convocadoData.primerNombre || ''}
          onChange={(e) => handleInputChange('primerNombre', e.target.value)}
          required
          error={errors.primerNombre}
        />
        <Input
          label="Segundo Nombre"
          value={convocadoData.segundoNombre || ''}
          onChange={(e) => handleInputChange('segundoNombre', e.target.value)}
          error={errors.segundoNombre}
        />
        <Input
          label="Primer Apellido"
          value={convocadoData.primerApellido || ''}
          onChange={(e) => handleInputChange('primerApellido', e.target.value)}
          required
          error={errors.primerApellido}
        />
        <Input
          label="Segundo Apellido"
          value={convocadoData.segundoApellido || ''}
          onChange={(e) => handleInputChange('segundoApellido', e.target.value)}
          error={errors.segundoApellido}
        />
      </div>

      {/* Documento de Identidad */}
      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
        <Select
          label="Tipo de Documento"
          value={convocadoData.tipoDocumento || ''}
          onChange={(e) => handleInputChange('tipoDocumento', e.target.value)}
          options={tiposDocumento}
          required
          error={errors.tipoDocumento}
        />
        <Input
          label="Número de Documento"
          value={convocadoData.numeroDocumento || ''}
          onChange={(e) => handleInputChange('numeroDocumento', e.target.value)}
          required
          error={errors.numeroDocumento}
        />
        <Input
          label="Fecha y Lugar de Expedición"
          value={convocadoData.fechaExpedicion || ''}
          onChange={(e) => handleInputChange('fechaExpedicion', e.target.value)}
          placeholder="Ej: 15/01/2020 - Bogotá"
          error={errors.fechaExpedicion}
        />
      </div>

      {/* Fecha Nacimiento y Edad */}
      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
        <Input
          label="Fecha de Nacimiento"
          type="date"
          value={convocadoData.fechaNacimiento || ''}
          onChange={(e) => handleInputChange('fechaNacimiento', e.target.value)}
          error={errors.fechaNacimiento}
        />
        <Input
          label="Edad"
          type="number"
          value={convocadoData.edad || ''}
          onChange={(e) => handleInputChange('edad', e.target.value)}
          error={errors.edad}
        />
        <Input
          label="Celular"
          value={convocadoData.celular || ''}
          onChange={(e) => handleInputChange('celular', e.target.value)}
          placeholder="Ej: 3001234567"
          error={errors.celular}
        />
        <Input
          label="WhatsApp"
          value={convocadoData.whatsapp || ''}
          onChange={(e) => handleInputChange('whatsapp', e.target.value)}
          placeholder="Ej: 3001234567"
          error={errors.whatsapp}
        />
      </div>

      {/* Estado Civil y Género */}
      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
        <Select
          label="Estado Civil:"
          value={convocadoData.estadoCivil || ''}
          onChange={(e) => handleInputChange('estadoCivil', e.target.value)}
          options={CIVIL_STATUS_OPTIONS}
          error={errors.estadoCivil}
        />
        <Select
          label="Género"
          value={convocadoData.genero || ''}
          onChange={(e) => handleInputChange('genero', e.target.value)}
          options={generos}
          error={errors.genero}
        />
        <Select
          label="Sexo"
          value={convocadoData.sexo || ''}
          onChange={(e) => handleInputChange('sexo', e.target.value)}
          options={sexos}
          error={errors.sexo}
        />
        <Input
          label="Grupo Étnico"
          value={convocadoData.grupoEtnico || ''}
          onChange={(e) => handleInputChange('grupoEtnico', e.target.value)}
          error={errors.grupoEtnico}
        />
      </div>

      {/* Discapacidad */}
      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem', alignItems: 'end'}}>
        <div>
          <label style={{display: 'block', fontSize: '0.875rem', fontWeight: '500', color: '#374151', marginBottom: '0.5rem'}}>
            Discapacidad
          </label>
          <div style={{display: 'flex', gap: '1rem', alignItems: 'center'}}>
            <Checkbox
              label="No"
              checked={convocadoData.discapacidad === false}
              onChange={() => handleInputChange('discapacidad', false)}
            />
            <Checkbox
              label="Sí"
              checked={convocadoData.discapacidad === true}
              onChange={() => handleInputChange('discapacidad', true)}
            />
          </div>
        </div>
        {convocadoData.discapacidad && (
          <Input
            label="¿Cuál?"
            value={convocadoData.cualDiscapacidad || ''}
            onChange={(e) => handleInputChange('cualDiscapacidad', e.target.value)}
            error={errors.cualDiscapacidad}
          />
        )}
      </div>

      {/* Datos Socioeconómicos */}
      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
        <Select
          label="Estrato"
          value={convocadoData.estrato || ''}
          onChange={(e) => handleInputChange('estrato', e.target.value)}
          options={estratos}
          error={errors.estrato}
        />
        <Select
          label="Nivel de escolaridad:"
          value={convocadoData.nivelEscolaridad || ''}
          onChange={(e) => handleInputChange('nivelEscolaridad', e.target.value)}
          options={EDUCATION_LEVELS}
          error={errors.nivelEscolaridad}
        />
        <Input
          label="Ocupación"
          value={convocadoData.ocupacion || ''}
          onChange={(e) => handleInputChange('ocupacion', e.target.value)}
          error={errors.ocupacion}
        />
      </div>

      {/* Ubicación */}
      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
        <Input
          label="País"
          value={convocadoData.pais || ''}
          onChange={(e) => handleInputChange('pais', e.target.value)}
          error={errors.pais}
        />
        <Input
          label="Departamento:"
          value={convocadoData.departamento || ''}
          onChange={(e) => handleInputChange('departamento', e.target.value)}
          error={errors.departamento}
        />
        <Input
          label="Ciudad"
          value={convocadoData.ciudad || ''}
          onChange={(e) => handleInputChange('ciudad', e.target.value)}
          error={errors.ciudad}
        />
        <Input
          label="Municipio"
          value={convocadoData.municipio || ''}
          onChange={(e) => handleInputChange('municipio', e.target.value)}
          error={errors.municipio}
        />
      </div>

      {/* Dirección y Contacto */}
      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
        <Input
          label="Dirección"
          value={convocadoData.direccion || ''}
          onChange={(e) => handleInputChange('direccion', e.target.value)}
          error={errors.direccion}
        />
        <Input
          label="Localidad"
          value={convocadoData.localidad || ''}
          onChange={(e) => handleInputChange('localidad', e.target.value)}
          error={errors.localidad}
        />
        <Input
          label="Barrio"
          value={convocadoData.barrio || ''}
          onChange={(e) => handleInputChange('barrio', e.target.value)}
          error={errors.barrio}
        />
        <Input
          label="Correo Electrónico"
          type="email"
          value={convocadoData.correo || ''}
          onChange={(e) => handleInputChange('correo', e.target.value)}
          error={errors.correo}
        />
      </div>
    </FormSection>
  )
}

export default ConvocadoForm