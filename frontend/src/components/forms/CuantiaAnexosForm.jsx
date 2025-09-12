import FormSection from '../ui/FormSection'
import Input from '../ui/Input'
import Checkbox from '../ui/Checkbox'

const CuantiaAnexosForm = ({ formData, updateFormData, errors }) => {
  const cuantiaData = formData.cuantia || {}
  const anexosData = formData.anexos || {}

  const handleCuantiaChange = (field, value) => {
    updateFormData('cuantia', { [field]: value })
  }

  const handleAnexoChange = (field, checked) => {
    updateFormData('anexos', { [field]: checked })
  }

  return (
    <div style={{display: 'flex', flexDirection: 'column', gap: '2rem'}}>
      {/* Estimación de Cuantía */}
      <FormSection title="ESTIMACIÓN RAZONADA DE LA CUANTÍA">
        <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(250px, 1fr))', gap: '1.5rem'}}>
          <div>
            <Input
              label="Cuantía Estimada ($)"
              type="number"
              value={cuantiaData.estimada || ''}
              onChange={(e) => handleCuantiaChange('estimada', e.target.value)}
              placeholder="Ej: 5000000"
              error={errors.cuantiaEstimada}
            />
            <p style={{fontSize: '0.75rem', color: '#6b7280', marginTop: '0.25rem'}}>
              Valor económico aproximado del conflicto
            </p>
          </div>
          
          <div style={{display: 'flex', alignItems: 'center', paddingTop: '1.5rem'}}>
            <Checkbox
              label="Indeterminada/sin cuantía"
              checked={cuantiaData.indeterminada || false}
              onChange={(e) => handleCuantiaChange('indeterminada', e.target.checked)}
            />
          </div>
        </div>

        <Input
          label="¿Cuánto tiempo hace que inició el conflicto?"
          value={cuantiaData.tiempoConflicto || ''}
          onChange={(e) => handleCuantiaChange('tiempoConflicto', e.target.value)}
          placeholder="Ej: 6 meses, 1 año, etc."
          error={errors.tiempoConflicto}
        />

        <div style={{marginTop: '1rem'}}>
          <label style={{display: 'block', fontSize: '0.875rem', fontWeight: '500', color: '#374151', marginBottom: '0.5rem'}}>
            Existencia de Acta de Conciliación Previa
          </label>
          <div style={{display: 'flex', gap: '1rem'}}>
            <Checkbox
              label="SÍ"
              checked={cuantiaData.actaPrevia === true}
              onChange={() => handleCuantiaChange('actaPrevia', true)}
            />
            <Checkbox
              label="NO"
              checked={cuantiaData.actaPrevia === false}
              onChange={() => handleCuantiaChange('actaPrevia', false)}
            />
          </div>
        </div>
      </FormSection>

      {/* Anexos */}
      <FormSection title="ANEXOS">
        <div style={{marginBottom: '1rem'}}>
          <p style={{fontSize: '0.875rem', color: '#6b7280'}}>
            Marque los documentos que adjunta con su solicitud:
          </p>
        </div>

        <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1rem'}}>
          <Checkbox
            label="Copia Serv./Pco"
            checked={anexosData.copiaServ || false}
            onChange={(e) => handleAnexoChange('copiaServ', e.target.checked)}
          />
          
          <Checkbox
            label="C.C. Convocante"
            checked={anexosData.ccConvocante || false}
            onChange={(e) => handleAnexoChange('ccConvocante', e.target.checked)}
          />
          
          <Checkbox
            label="R/Civil"
            checked={anexosData.rcivil || false}
            onChange={(e) => handleAnexoChange('rcivil', e.target.checked)}
          />
          
          <Checkbox
            label="Contrato"
            checked={anexosData.contrato || false}
            onChange={(e) => handleAnexoChange('contrato', e.target.checked)}
          />
          
          <Checkbox
            label="Cert/Represt"
            checked={anexosData.certReprest || false}
            onChange={(e) => handleAnexoChange('certReprest', e.target.checked)}
          />
          
          <Checkbox
            label="Título./Vr"
            checked={anexosData.tituloVr || false}
            onChange={(e) => handleAnexoChange('tituloVr', e.target.checked)}
          />
          
          <Checkbox
            label="Sentencia"
            checked={anexosData.sentencia || false}
            onChange={(e) => handleAnexoChange('sentencia', e.target.checked)}
          />
        </div>

        <div style={{marginTop: '1.5rem'}}>
          <Input
            label="Otros (especifique)"
            value={anexosData.otros || ''}
            onChange={(e) => handleAnexoChange('otros', e.target.value)}
            placeholder="Indique otros documentos que adjunta..."
            error={errors.anexosOtros}
          />
        </div>

        <div style={{marginTop: '1.5rem', padding: '1rem', backgroundColor: '#fef3c7', borderRadius: '8px', border: '1px solid #f59e0b'}}>
          <p style={{fontSize: '0.875rem', color: '#92400e', margin: 0}}>
            <strong>Importante:</strong> Adjunte todos los documentos relevantes que soporten su solicitud. 
            Los documentos incompletos pueden retrasar el proceso de conciliación.
          </p>
        </div>
      </FormSection>
    </div>
  )
}

export default CuantiaAnexosForm