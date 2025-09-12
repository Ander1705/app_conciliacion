import { useState } from 'react'
import { solicitudService } from '../services/api'

export const usePdfGeneration = () => {
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState(null)
  const [showModal, setShowModal] = useState(false)
  const [pdfResult, setPdfResult] = useState(null)

  const transformFormDataToAPI = (formData) => {
    // Transformar los datos del formulario al formato esperado por la API
    return {
      // Datos generales
      ciudadFecha: formData.general?.ciudadFecha || '',
      
      // Convocante
      convPrimerNombre: formData.convocante?.primerNombre || '',
      convSegundoNombre: formData.convocante?.segundoNombre || '',
      convPrimerApellido: formData.convocante?.primerApellido || '',
      convSegundoApellido: formData.convocante?.segundoApellido || '',
      convTipoDocumento: formData.convocante?.tipoDocumento || '',
      convNumeroDocumento: formData.convocante?.numeroDocumento || '',
      convFechaExpedicion: formData.convocante?.fechaExpedicion || '',
      convFechaNacimiento: formData.convocante?.fechaNacimiento || null,
      convEdad: formData.convocante?.edad ? parseInt(formData.convocante.edad) : null,
      convCelular: formData.convocante?.celular || '',
      convWhatsapp: formData.convocante?.whatsapp || '',
      convEstadoCivil: formData.convocante?.estadoCivil || '',
      convGenero: formData.convocante?.genero || '',
      convSexo: formData.convocante?.sexo || '',
      convGrupoEtnico: formData.convocante?.grupoEtnico || '',
      convDiscapacidad: formData.convocante?.discapacidad || false,
      convCualDiscapacidad: formData.convocante?.cualDiscapacidad || '',
      convEstrato: formData.convocante?.estrato ? parseInt(formData.convocante.estrato) : null,
      convNivelEscolaridad: formData.convocante?.nivelEscolaridad || '',
      convOcupacion: formData.convocante?.ocupacion || '',
      convPais: formData.convocante?.pais || '',
      convDepartamento: formData.convocante?.departamento || '',
      convCiudad: formData.convocante?.ciudad || '',
      convMunicipio: formData.convocante?.municipio || '',
      convDireccion: formData.convocante?.direccion || '',
      convLocalidad: formData.convocante?.localidad || '',
      convBarrio: formData.convocante?.barrio || '',
      convCorreo: formData.convocante?.correo || '',

      // Convocado
      convocadoPrimerNombre: formData.convocado?.primerNombre || '',
      convocadoSegundoNombre: formData.convocado?.segundoNombre || '',
      convocadoPrimerApellido: formData.convocado?.primerApellido || '',
      convocadoSegundoApellido: formData.convocado?.segundoApellido || '',
      convocadoTipoDocumento: formData.convocado?.tipoDocumento || '',
      convocadoNumeroDocumento: formData.convocado?.numeroDocumento || '',
      convocadoFechaExpedicion: formData.convocado?.fechaExpedicion || '',
      convocadoFechaNacimiento: formData.convocado?.fechaNacimiento || null,
      convocadoEdad: formData.convocado?.edad ? parseInt(formData.convocado.edad) : null,
      convocadoCelular: formData.convocado?.celular || '',
      convocadoWhatsapp: formData.convocado?.whatsapp || '',
      convocadoEstadoCivil: formData.convocado?.estadoCivil || '',
      convocadoGenero: formData.convocado?.genero || '',
      convocadoSexo: formData.convocado?.sexo || '',
      convocadoGrupoEtnico: formData.convocado?.grupoEtnico || '',
      convocadoDiscapacidad: formData.convocado?.discapacidad || false,
      convocadoCualDiscapacidad: formData.convocado?.cualDiscapacidad || '',
      convocadoEstrato: formData.convocado?.estrato ? parseInt(formData.convocado.estrato) : null,
      convocadoNivelEscolaridad: formData.convocado?.nivelEscolaridad || '',
      convocadoOcupacion: formData.convocado?.ocupacion || '',
      convocadoPais: formData.convocado?.pais || '',
      convocadoDepartamento: formData.convocado?.departamento || '',
      convocadoCiudad: formData.convocado?.ciudad || '',
      convocadoMunicipio: formData.convocado?.municipio || '',
      convocadoDireccion: formData.convocado?.direccion || '',
      convocadoLocalidad: formData.convocado?.localidad || '',
      convocadoBarrio: formData.convocado?.barrio || '',
      convocadoCorreo: formData.convocado?.correo || '',

      // Empresa
      empresaNombre: formData.empresa?.nombre || '',
      empresaNit: formData.empresa?.nit || '',
      empresaRepresentante: formData.empresa?.representante || '',
      empresaCc: formData.empresa?.ccRepresentante || '',
      empresaDireccion: formData.empresa?.direccion || '',
      empresaTelefono: formData.empresa?.telefono || '',
      empresaCorreo: formData.empresa?.correo || '',

      // Apoderado
      apoderadoNombres: formData.apoderado?.nombres || '',
      apoderadoCc: formData.apoderado?.cc || '',
      apoderadoTp: formData.apoderado?.tp || '',
      apoderadoDireccion: formData.apoderado?.direccion || '',
      apoderadoCiudad: formData.apoderado?.ciudad || '',
      apoderadoTelefono: formData.apoderado?.telefono || '',
      apoderadoCorreo: formData.apoderado?.correo || '',

      // Área del conflicto
      areaCivil: formData.area?.civil || false,
      areaFamilia: formData.area?.familia || false,
      areaComercial: formData.area?.comercial || false,
      areaPenal: formData.area?.penal || false,
      areaConvivencia: formData.area?.convivencia || false,

      // Hechos
      hechoPrimero: formData.hechos?.primero || '',
      hechoSegundo: formData.hechos?.segundo || '',
      hechoTercero: formData.hechos?.tercero || '',
      hechoCuarto: formData.hechos?.cuarto || '',
      hechoQuinto: formData.hechos?.quinto || '',

      // Pretensiones
      pretensionPrimera: formData.pretensiones?.primera || '',
      pretensionSegunda: formData.pretensiones?.segunda || '',
      pretensionTercera: formData.pretensiones?.tercera || '',

      // Cuantía
      cuantiaEstimada: formData.cuantia?.estimada ? parseFloat(formData.cuantia.estimada) : null,
      cuantiaIndeterminada: formData.cuantia?.indeterminada || false,
      tiempoConflicto: formData.cuantia?.tiempoConflicto || '',
      actaPrevia: formData.cuantia?.actaPrevia || false,

      // Anexos
      anexoCopiaServ: formData.anexos?.copiaServ || false,
      anexoCcConvocante: formData.anexos?.ccConvocante || false,
      anexoRcivil: formData.anexos?.rcivil || false,
      anexoContrato: formData.anexos?.contrato || false,
      anexoCertReprest: formData.anexos?.certReprest || false,
      anexoTituloVr: formData.anexos?.tituloVr || false,
      anexoSentencia: formData.anexos?.sentencia || false,
      anexoOtros: formData.anexos?.otros || '',

      // Notificaciones
      notifSolicitanteNombres: formData.notificaciones?.solicitante?.nombres || '',
      notifSolicitanteDireccion: formData.notificaciones?.solicitante?.direccion || '',
      notifSolicitanteCiudad: formData.notificaciones?.solicitante?.ciudad || '',
      notifSolicitanteTelefonos: formData.notificaciones?.solicitante?.telefonos || '',
      notifSolicitanteCelulares: formData.notificaciones?.solicitante?.celulares || '',
      notifSolicitanteCorreo: formData.notificaciones?.solicitante?.correo || '',

      notifApoderadoNombres: formData.notificaciones?.apoderado?.nombres || '',
      notifApoderadoDomicilio: formData.notificaciones?.apoderado?.domicilio || '',
      notifApoderadoCiudad: formData.notificaciones?.apoderado?.ciudad || '',
      notifApoderadoCc: formData.notificaciones?.apoderado?.cc || '',
      notifApoderadoTp: formData.notificaciones?.apoderado?.tp || '',
      notifApoderadoTelefonos: formData.notificaciones?.apoderado?.telefonos || '',
      notifApoderadoCelulares: formData.notificaciones?.apoderado?.celulares || '',
      notifApoderadoCorreo: formData.notificaciones?.apoderado?.correo || '',

      notifSolicitadosNombres: formData.notificaciones?.solicitados?.nombres || '',
      notifSolicitadosDireccion: formData.notificaciones?.solicitados?.direccion || '',
      notifSolicitadosCiudad: formData.notificaciones?.solicitados?.ciudad || '',
      notifSolicitadosTelefonos: formData.notificaciones?.solicitados?.telefonos || '',
      notifSolicitadosCelulares: formData.notificaciones?.solicitados?.celulares || '',
      notifSolicitadosCorreo: formData.notificaciones?.solicitados?.correo || '',

      // Firmas
      solicitanteCc: formData.firmas?.solicitanteCc || '',
      asesorNombreCelular: formData.firmas?.asesorNombreCelular || '',

      // Datos adicionales
      ipCliente: null // Se asigna en el backend
    }
  }

  const generatePDF = async (formData) => {
    setLoading(true)
    setError(null)

    try {
      const apiData = transformFormDataToAPI(formData)
      const result = await solicitudService.generarPDF(apiData)
      
      // Guardar resultado y mostrar modal de confirmación
      setPdfResult(result)
      setShowModal(true)
      setLoading(false)
      
      return result
    } catch (err) {
      setError(err.message)
      setLoading(false)
      throw err
    }
  }

  const closeModal = () => {
    setShowModal(false)
    setPdfResult(null)
  }

  const downloadPDF = () => {
    if (pdfResult?.pdfUrl && pdfResult?.fileName) {
      const link = document.createElement('a')
      link.href = pdfResult.pdfUrl
      link.download = pdfResult.fileName
      document.body.appendChild(link)
      link.click()
      document.body.removeChild(link)
    }
  }

  return {
    generatePDF,
    loading,
    error,
    showModal,
    pdfResult,
    closeModal,
    downloadPDF,
    clearError: () => setError(null)
  }
}