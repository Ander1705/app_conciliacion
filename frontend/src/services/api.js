import axios from 'axios'

const API_BASE_URL = import.meta.env.VITE_API_URL || 'http://localhost:8082/api'

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
})

// Interceptor para manejo de errores
api.interceptors.response.use(
  (response) => response,
  (error) => {
    console.error('API Error:', error.response?.data || error.message)
    return Promise.reject(error)
  }
)

// Servicios de Solicitudes
export const solicitudService = {
  // Crear nueva solicitud
  crear: async (solicitudData) => {
    try {
      const response = await api.post('/solicitudes', solicitudData)
      return response.data
    } catch (error) {
      throw new Error(`Error al crear solicitud: ${error.response?.data?.message || error.message}`)
    }
  },

  // Obtener solicitud por ID
  obtenerPorId: async (id) => {
    try {
      const response = await api.get(`/solicitudes/${id}`)
      return response.data
    } catch (error) {
      throw new Error(`Error al obtener solicitud: ${error.response?.data?.message || error.message}`)
    }
  },

  // Actualizar solicitud
  actualizar: async (id, solicitudData) => {
    try {
      const response = await api.put(`/solicitudes/${id}`, solicitudData)
      return response.data
    } catch (error) {
      throw new Error(`Error al actualizar solicitud: ${error.response?.data?.message || error.message}`)
    }
  },

  // Generar PDF
  generarPDF: async (solicitudData) => {
    try {
      const response = await api.post('/solicitudes/generar-pdf', solicitudData, {
        responseType: 'blob', // Important for PDF download
      })
      
      // Crear objeto Blob del PDF
      const pdfBlob = new Blob([response.data], { type: 'application/pdf' })
      
      // Crear URL para el modal (no descarga automática)
      const pdfUrl = window.URL.createObjectURL(pdfBlob)
      
      // Generar nombre de archivo para descarga posterior
      const fechaHora = new Date().toISOString().slice(0, 19).replace(/:/g, '-')
      const fileName = `Solicitud_Conciliacion_${fechaHora}.pdf`
      
      return { 
        success: true, 
        message: 'PDF generado exitosamente',
        pdfUrl,
        fileName,
        blob: pdfBlob
      }
    } catch (error) {
      throw new Error(`Error al generar PDF: ${error.response?.data?.message || error.message}`)
    }
  }
}

export default api