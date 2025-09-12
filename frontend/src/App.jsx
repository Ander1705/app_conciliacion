
import { useState, useEffect } from 'react'
import Layout from './components/layout/Layout'
import ConvocanteForm from './components/forms/ConvocanteForm'
import ConvocadoForm from './components/forms/ConvocadoForm'
import PersonaJuridicaForm from './components/forms/PersonaJuridicaForm'
import ApoderadoForm from './components/forms/ApoderadoForm'
import AreaConflictoForm from './components/forms/AreaConflictoForm'
import HechosForm from './components/forms/HechosForm'
import PretensionesForm from './components/forms/PretensionesForm'
import CuantiaAnexosForm from './components/forms/CuantiaAnexosForm'
import NotificacionesForm from './components/forms/NotificacionesForm'
import ResumenForm from './components/forms/ResumenForm'
import Button from './components/ui/Button'
import PdfConfirmationModal from './components/ui/PdfConfirmationModal'
import { usePdfGeneration } from './hooks/usePdfGeneration'
import { generateCityAndDate } from './utils/formatters'

const STEPS = [
  { id: 1, title: 'Datos del Convocante', component: 'ConvocanteForm' },
  { id: 2, title: 'Datos del Convocado', component: 'ConvocadoForm' },
  { id: 3, title: 'Área del Conflicto', component: 'AreaConflictoForm' },
  { id: 4, title: 'Hechos', component: 'HechosForm' },
  { id: 5, title: 'Pretensiones', component: 'PretensionesForm' },
  { id: 6, title: 'Cuantía y Anexos', component: 'CuantiaAnexosForm' },
  { id: 7, title: 'Notificaciones', component: 'NotificacionesForm' },
  { id: 8, title: 'Resumen', component: 'ResumenForm' }
]

function App() {
  const [currentStep, setCurrentStep] = useState(1)
  const [formData, setFormData] = useState({})
  const [errors] = useState({})
  const { generatePDF, loading: pdfLoading, error: pdfError, clearError, showModal, pdfResult, closeModal, downloadPDF } = usePdfGeneration()

  // Generar automáticamente ciudad y fecha
  useEffect(() => {
    const cityAndDate = generateCityAndDate()
    setFormData(prev => ({
      ...prev,
      general: {
        ...prev.general,
        ciudadFecha: cityAndDate
      }
    }))
  }, [])

  const updateFormData = (section, data) => {
    setFormData(prev => ({
      ...prev,
      [section]: {
        ...prev[section],
        ...data
      }
    }))
  }

  const nextStep = () => {
    if (currentStep < STEPS.length) {
      setCurrentStep(currentStep + 1)
    }
  }

  const prevStep = () => {
    if (currentStep > 1) {
      setCurrentStep(currentStep - 1)
    }
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    
    if (currentStep === STEPS.length) {
      // Generar PDF en el último paso
      try {
        clearError()
        await generatePDF(formData)
        // El modal se mostrará automáticamente desde el hook
      } catch (error) {
        console.error('Error al generar PDF:', error)
      }
    } else {
      // Ir al siguiente paso
      nextStep()
    }
  }

  const currentStepData = STEPS.find(step => step.id === currentStep)

  const renderCurrentStep = () => {
    switch (currentStep) {
      case 1:
        return (
          <>
            <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(250px, 1fr))', gap: '1.5rem', marginBottom: '2rem'}}>
              <div>
                <label style={{display: 'block', fontSize: '0.875rem', fontWeight: '500', color: '#374151', marginBottom: '0.25rem'}}>
                  Ciudad y Fecha
                </label>
                <div 
                  style={{
                    padding: '0.75rem 1rem',
                    backgroundColor: '#f9fafb',
                    border: '1px solid #d1d5db',
                    borderRadius: '6px',
                    fontSize: '0.875rem',
                    color: '#374151'
                  }}
                >
                  {formData.general?.ciudadFecha || generateCityAndDate()}
                </div>
              </div>
              <div>
                <label style={{display: 'block', fontSize: '0.875rem', fontWeight: '500', color: '#374151', marginBottom: '0.25rem'}}>
                  Solicitud de Conciliación No.
                </label>
                <div 
                  style={{
                    padding: '0.75rem 1rem',
                    backgroundColor: '#f9fafb',
                    border: '1px solid #d1d5db',
                    borderRadius: '6px',
                    fontSize: '0.875rem',
                    color: '#9ca3af',
                    fontStyle: 'italic'
                  }}
                >
                  (Se completará al imprimir el documento)
                </div>
              </div>
            </div>
            <ConvocanteForm 
              formData={formData}
              updateFormData={updateFormData}
              errors={errors.convocante || {}}
            />
          </>
        )
      case 2:
        return (
          <>
            <ConvocadoForm 
              formData={formData}
              updateFormData={updateFormData}
              errors={errors.convocado || {}}
            />
            <PersonaJuridicaForm 
              formData={formData}
              updateFormData={updateFormData}
              errors={errors.empresa || {}}
            />
            <ApoderadoForm 
              formData={formData}
              updateFormData={updateFormData}
              errors={errors.apoderado || {}}
            />
          </>
        )
      case 3:
        return (
          <AreaConflictoForm 
            formData={formData}
            updateFormData={updateFormData}
            errors={errors.area || {}}
          />
        )
      case 4:
        return (
          <HechosForm 
            formData={formData}
            updateFormData={updateFormData}
            errors={errors.hechos || {}}
          />
        )
      case 5:
        return (
          <PretensionesForm 
            formData={formData}
            updateFormData={updateFormData}
            errors={errors.pretensiones || {}}
          />
        )
      case 6:
        return (
          <CuantiaAnexosForm 
            formData={formData}
            updateFormData={updateFormData}
            errors={errors.cuantia || {}}
          />
        )
      case 7:
        return (
          <NotificacionesForm 
            formData={formData}
            updateFormData={updateFormData}
            errors={errors.notificaciones || {}}
          />
        )
      case 8:
        return (
          <ResumenForm 
            formData={formData}
            updateFormData={updateFormData}
            errors={errors.firmas || {}}
          />
        )
      default:
        return (
          <div style={{padding: '2rem', textAlign: 'center', backgroundColor: '#f9fafb', borderRadius: '8px'}}>
            <h3 style={{fontSize: '1.25rem', fontWeight: '600', marginBottom: '1rem', color: '#374151'}}>
              {currentStepData?.title}
            </h3>
            <p style={{color: '#6b7280', marginBottom: '2rem'}}>
              Paso no encontrado
            </p>
          </div>
        )
    }
  }

  return (
    <Layout>
      <div style={{maxWidth: '64rem', margin: '0 auto'}}>
        {/* Indicador de Progreso */}
        <div style={{backgroundColor: 'white', borderRadius: '0.5rem', boxShadow: '0 4px 6px -1px rgba(0, 0, 0, 0.1)', padding: '1.5rem', marginBottom: '2rem'}}>
          <div style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '1rem'}}>
            <h2 style={{fontSize: '1.5rem', fontWeight: 'bold', color: 'var(--primary-color)'}}>
              Solicitud de Conciliación
            </h2>
            <span style={{fontSize: '0.875rem', color: '#6b7280'}}>
              Paso {currentStep} de {STEPS.length}
            </span>
          </div>
          
          {/* Barra de progreso */}
          <div style={{width: '100%', backgroundColor: '#e5e7eb', borderRadius: '0.5rem', height: '0.5rem', marginBottom: '1rem'}}>
            <div 
              style={{
                width: `${(currentStep / STEPS.length) * 100}%`,
                backgroundColor: 'var(--primary-color)',
                height: '100%',
                borderRadius: '0.5rem',
                transition: 'width 0.3s ease'
              }}
            ></div>
          </div>
          
          {/* Título del paso actual */}
          <h3 style={{fontSize: '1.125rem', fontWeight: '600', color: '#374151'}}>
            {currentStepData?.title}
          </h3>
        </div>

        {/* Formulario */}
        <div style={{backgroundColor: 'white', borderRadius: '0.5rem', boxShadow: '0 10px 15px -3px rgba(0, 0, 0, 0.1)', padding: '2rem'}}>
          <form onSubmit={handleSubmit} style={{display: 'flex', flexDirection: 'column', gap: '2rem'}}>
            {renderCurrentStep()}

            {/* Error de PDF */}
            {pdfError && (
              <div style={{padding: '1rem', backgroundColor: '#fee2e2', border: '1px solid #fecaca', borderRadius: '8px'}}>
                <p style={{color: '#dc2626', fontSize: '0.875rem', margin: 0}}>
                  <strong>Error:</strong> {pdfError}
                </p>
              </div>
            )}

            {/* Navegación */}
            <div style={{display: 'flex', justifyContent: 'space-between', paddingTop: '2rem', borderTop: '1px solid #e5e7eb'}}>
              <div style={{display: 'flex', gap: '1rem'}}>
                {currentStep > 1 && (
                  <Button variant="secondary" type="button" onClick={prevStep}>
                    Anterior
                  </Button>
                )}
                <Button variant="secondary" type="button">
                  Guardar Borrador
                </Button>
              </div>
              
              <Button type="submit" disabled={pdfLoading}>
                {currentStep === STEPS.length 
                  ? (pdfLoading ? 'Generando PDF...' : 'Generar PDF') 
                  : 'Continuar'
                }
              </Button>
            </div>
          </form>
        </div>
      </div>
      
      {/* Modal de confirmación de PDF */}
      <PdfConfirmationModal 
        isOpen={showModal}
        onClose={closeModal}
        onDownload={downloadPDF}
        pdfResult={pdfResult}
      />
    </Layout>
  )
}

export default App