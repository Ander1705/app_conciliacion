import { useState } from 'react'
import FormSection from '../ui/FormSection'
import Input from '../ui/Input'
import Select from '../ui/Select'
import RadioGroup from '../ui/RadioGroup'
import { DOCUMENT_TYPES, GENDER_OPTIONS, SEX_OPTIONS, CIVIL_STATUS_OPTIONS, EDUCATION_LEVELS, COLOMBIAN_DEPARTMENTS } from '../../utils/constants'

const ConvocanteForm = ({ formData, updateFormData, errors = {} }) => {
  const handleInputChange = (field) => (e) => {
    const value = e.target.type === 'checkbox' ? e.target.checked : e.target.value
    updateFormData('convocante', { [field]: value })
  }

  const handleDepartmentChange = (e) => {
    const value = e.target.value
    const newData = { departamento: value }
    if (value === 'Distrito Capital') {
      newData.ciudad = 'Bogotá D.C.'
    }
    updateFormData('convocante', newData)
  }

  const handleDocumentTypeChange = (type) => {
    updateFormData('convocante', { 
      tipoDocumento: formData.convocante?.tipoDocumento === type ? '' : type,
      tipoDocumentoCc: type === 'CC',
      tipoDocumentoCe: type === 'CE',
      tipoDocumentoPasaporte: type === 'Pasaporte'
    })
  }

  const handleGenderChange = (gender) => {
    updateFormData('convocante', { 
      genero: formData.convocante?.genero === gender ? '' : gender,
      generoMasculino: gender === 'Masculino',
      generoFemenino: gender === 'Femenino',
      generoTransgenero: gender === 'Transgénero'
    })
  }

  const handleSexChange = (sex) => {
    updateFormData('convocante', { 
      sexo: formData.convocante?.sexo === sex ? '' : sex,
      sexoHombre: sex === 'Hombre',
      sexoMujer: sex === 'Mujer',
      sexoIntersexual: sex === 'Intersexual'
    })
  }

  const convocante = formData.convocante || {}

  return (
    <FormSection title="DATOS DEL CONVOCANTE">
      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
        <Input
          label="Primer Nombre"
          required
          value={convocante.primerNombre || ''}
          onChange={handleInputChange('primerNombre')}
          error={errors.primerNombre}
        />
        <Input
          label="Segundo Nombre"
          value={convocante.segundoNombre || ''}
          onChange={handleInputChange('segundoNombre')}
          error={errors.segundoNombre}
        />
        <Input
          label="Primer Apellido"
          required
          value={convocante.primerApellido || ''}
          onChange={handleInputChange('primerApellido')}
          error={errors.primerApellido}
        />
        <Input
          label="Segundo Apellido"
          value={convocante.segundoApellido || ''}
          onChange={handleInputChange('segundoApellido')}
          error={errors.segundoApellido}
        />
      </div>

      <div style={{marginTop: '1.5rem'}}>
        <RadioGroup
          label="Documento de Identidad"
          name="tipoDocumento"
          options={DOCUMENT_TYPES}
          value={convocante.tipoDocumento || ''}
          onChange={(value) => updateFormData('convocante', { tipoDocumento: value })}
          error={errors.tipoDocumento}
          required
        />
        <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem'}}>
          <Input
            label="Número de Documento"
            required
            value={convocante.numeroDocumento || ''}
            onChange={handleInputChange('numeroDocumento')}
            error={errors.numeroDocumento}
          />
          <Input
            label="Fecha y Lugar de Expedición"
            value={convocante.fechaExpedicion || ''}
            onChange={handleInputChange('fechaExpedicion')}
            error={errors.fechaExpedicion}
          />
        </div>
      </div>

      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem', marginTop: '1.5rem'}}>
        <Input
          label="Fecha de Nacimiento"
          type="date"
          value={convocante.fechaNacimiento || ''}
          onChange={handleInputChange('fechaNacimiento')}
          error={errors.fechaNacimiento}
        />
        <Input
          label="Edad"
          type="number"
          min="0"
          max="120"
          value={convocante.edad || ''}
          onChange={handleInputChange('edad')}
          error={errors.edad}
        />
        <Input
          label="Celular"
          value={convocante.celular || ''}
          onChange={handleInputChange('celular')}
          error={errors.celular}
        />
      </div>

      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem', marginTop: '1.5rem'}}>
        <Input
          label="WhatsApp"
          value={convocante.whatsapp || ''}
          onChange={handleInputChange('whatsapp')}
          error={errors.whatsapp}
        />
        <Select
          label="Estado Civil"
          options={CIVIL_STATUS_OPTIONS}
          value={convocante.estadoCivil || ''}
          onChange={handleInputChange('estadoCivil')}
          placeholder="Seleccione estado civil"
          error={errors.estadoCivil}
        />
      </div>

      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem', marginTop: '1.5rem'}}>
        <RadioGroup
          label="Género"
          name="genero"
          options={GENDER_OPTIONS}
          value={convocante.genero || ''}
          onChange={(value) => updateFormData('convocante', { genero: value })}
          error={errors.genero}
        />
        
        <RadioGroup
          label="Sexo"
          name="sexo"
          options={SEX_OPTIONS}
          value={convocante.sexo || ''}
          onChange={(value) => updateFormData('convocante', { sexo: value })}
          error={errors.sexo}
        />
      </div>

      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem', marginTop: '1.5rem'}}>
        <Input
          label="Grupo Étnico"
          value={convocante.grupoEtnico || ''}
          onChange={handleInputChange('grupoEtnico')}
          error={errors.grupoEtnico}
        />
        <div>
          <RadioGroup
            label="Discapacidad"
            name="discapacidad"
            options={[
              { value: 'false', label: 'No' },
              { value: 'true', label: 'Sí' }
            ]}
            value={convocante.discapacidad ? 'true' : 'false'}
            onChange={(value) => updateFormData('convocante', { 
              discapacidad: value === 'true',
              cualDiscapacidad: value === 'false' ? '' : convocante.cualDiscapacidad 
            })}
            error={errors.discapacidad}
          />
          {convocante.discapacidad && (
            <Input
              label="¿Cuál?"
              value={convocante.cualDiscapacidad || ''}
              onChange={handleInputChange('cualDiscapacidad')}
              error={errors.cualDiscapacidad}
            />
          )}
        </div>
      </div>

      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem', marginTop: '1.5rem'}}>
        <Input
          label="Estrato"
          type="number"
          min="1"
          max="6"
          value={convocante.estrato || ''}
          onChange={handleInputChange('estrato')}
          error={errors.estrato}
        />
        <Select
          label="Nivel de Escolaridad"
          options={EDUCATION_LEVELS}
          value={convocante.nivelEscolaridad || ''}
          onChange={handleInputChange('nivelEscolaridad')}
          placeholder="Seleccione nivel"
          error={errors.nivelEscolaridad}
        />
        <Input
          label="Ocupación"
          value={convocante.ocupacion || ''}
          onChange={handleInputChange('ocupacion')}
          error={errors.ocupacion}
        />
      </div>

      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem', marginTop: '1.5rem'}}>
        <Input
          label="País"
          value={convocante.pais || 'Colombia'}
          onChange={handleInputChange('pais')}
          error={errors.pais}
        />
        <Select
          label="Departamento"
          options={COLOMBIAN_DEPARTMENTS}
          value={convocante.departamento || ''}
          onChange={handleDepartmentChange}
          placeholder="Seleccione departamento"
          error={errors.departamento}
        />
      </div>

      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem', marginTop: '1.5rem'}}>
        <Input
          label="Ciudad"
          value={convocante.ciudad || ''}
          onChange={handleInputChange('ciudad')}
          error={errors.ciudad}
        />
        <Input
          label="Municipio"
          value={convocante.municipio || ''}
          onChange={handleInputChange('municipio')}
          error={errors.municipio}
        />
      </div>

      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1.5rem', marginTop: '1.5rem'}}>
        <Input
          label="Dirección"
          value={convocante.direccion || ''}
          onChange={handleInputChange('direccion')}
          error={errors.direccion}
        />
        <Input
          label="Localidad"
          value={convocante.localidad || ''}
          onChange={handleInputChange('localidad')}
          error={errors.localidad}
        />
        <Input
          label="Barrio"
          value={convocante.barrio || ''}
          onChange={handleInputChange('barrio')}
          error={errors.barrio}
        />
      </div>

      <div style={{marginTop: '1.5rem'}}>
        <Input
          label="Correo Electrónico"
          type="email"
          value={convocante.correo || ''}
          onChange={handleInputChange('correo')}
          error={errors.correo}
        />
      </div>
    </FormSection>
  )
}

export default ConvocanteForm