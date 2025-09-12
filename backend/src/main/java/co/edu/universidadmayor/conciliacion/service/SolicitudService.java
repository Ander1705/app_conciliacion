package co.edu.universidadmayor.conciliacion.service;

import co.edu.universidadmayor.conciliacion.model.dto.SolicitudDTO;
import co.edu.universidadmayor.conciliacion.model.entity.Solicitud;
import co.edu.universidadmayor.conciliacion.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    public Solicitud crearSolicitud(SolicitudDTO solicitudDTO, String clientIp) {
        Solicitud solicitud = new Solicitud();
        
        // Mapear datos del DTO a la entidad
        mapearDTOAEntidad(solicitudDTO, solicitud);
        
        // Establecer datos adicionales
        solicitud.setFechaCreacion(LocalDateTime.now());
        solicitud.setIpCliente(clientIp);
        solicitud.setPdfGenerado(false);
        
        return solicitudRepository.save(solicitud);
    }

    public Solicitud obtenerPorId(Long id) {
        Optional<Solicitud> solicitud = solicitudRepository.findById(id);
        if (solicitud.isEmpty()) {
            throw new RuntimeException("Solicitud no encontrada con ID: " + id);
        }
        return solicitud.get();
    }

    public Solicitud actualizarSolicitud(Long id, SolicitudDTO solicitudDTO) {
        Solicitud solicitudExistente = obtenerPorId(id);
        mapearDTOAEntidad(solicitudDTO, solicitudExistente);
        return solicitudRepository.save(solicitudExistente);
    }

    public void marcarPdfGenerado(Long id) {
        Solicitud solicitud = obtenerPorId(id);
        solicitud.setPdfGenerado(true);
        solicitudRepository.save(solicitud);
    }

    private void mapearDTOAEntidad(SolicitudDTO dto, Solicitud entidad) {
        // Datos generales
        entidad.setCiudadFecha(dto.getCiudadFecha());
        
        // Convocante
        entidad.setConvPrimerNombre(dto.getConvPrimerNombre());
        entidad.setConvSegundoNombre(dto.getConvSegundoNombre());
        entidad.setConvPrimerApellido(dto.getConvPrimerApellido());
        entidad.setConvSegundoApellido(dto.getConvSegundoApellido());
        entidad.setConvTipoDocumento(dto.getConvTipoDocumento());
        entidad.setConvNumeroDocumento(dto.getConvNumeroDocumento());
        entidad.setConvFechaExpedicion(dto.getConvFechaExpedicion());
        entidad.setConvFechaNacimiento(dto.getConvFechaNacimiento());
        entidad.setConvEdad(dto.getConvEdad());
        entidad.setConvCelular(dto.getConvCelular());
        entidad.setConvWhatsapp(dto.getConvWhatsapp());
        entidad.setConvEstadoCivil(dto.getConvEstadoCivil());
        entidad.setConvGenero(dto.getConvGenero());
        entidad.setConvSexo(dto.getConvSexo());
        entidad.setConvGrupoEtnico(dto.getConvGrupoEtnico());
        entidad.setConvDiscapacidad(dto.getConvDiscapacidad());
        entidad.setConvCualDiscapacidad(dto.getConvCualDiscapacidad());
        entidad.setConvEstrato(dto.getConvEstrato());
        entidad.setConvNivelEscolaridad(dto.getConvNivelEscolaridad());
        entidad.setConvOcupacion(dto.getConvOcupacion());
        entidad.setConvPais(dto.getConvPais());
        entidad.setConvDepartamento(dto.getConvDepartamento());
        entidad.setConvCiudad(dto.getConvCiudad());
        entidad.setConvMunicipio(dto.getConvMunicipio());
        entidad.setConvDireccion(dto.getConvDireccion());
        entidad.setConvLocalidad(dto.getConvLocalidad());
        entidad.setConvBarrio(dto.getConvBarrio());
        entidad.setConvCorreo(dto.getConvCorreo());

        // Convocado - MAPEAR TODOS LOS CAMPOS
        entidad.setConvocadoPrimerNombre(dto.getConvocadoPrimerNombre());
        entidad.setConvocadoSegundoNombre(dto.getConvocadoSegundoNombre());
        entidad.setConvocadoPrimerApellido(dto.getConvocadoPrimerApellido());
        entidad.setConvocadoSegundoApellido(dto.getConvocadoSegundoApellido());
        entidad.setConvocadoTipoDocumento(dto.getConvocadoTipoDocumento());
        entidad.setConvocadoNumeroDocumento(dto.getConvocadoNumeroDocumento());
        entidad.setConvocadoFechaExpedicion(dto.getConvocadoFechaExpedicion());
        entidad.setConvocadoFechaNacimiento(dto.getConvocadoFechaNacimiento());
        entidad.setConvocadoEdad(dto.getConvocadoEdad());
        entidad.setConvocadoCelular(dto.getConvocadoCelular());
        entidad.setConvocadoWhatsapp(dto.getConvocadoWhatsapp());
        entidad.setConvocadoEstadoCivil(dto.getConvocadoEstadoCivil());
        entidad.setConvocadoGenero(dto.getConvocadoGenero());
        entidad.setConvocadoSexo(dto.getConvocadoSexo());
        entidad.setConvocadoGrupoEtnico(dto.getConvocadoGrupoEtnico());
        entidad.setConvocadoDiscapacidad(dto.getConvocadoDiscapacidad());
        entidad.setConvocadoCualDiscapacidad(dto.getConvocadoCualDiscapacidad());
        entidad.setConvocadoEstrato(dto.getConvocadoEstrato());
        entidad.setConvocadoNivelEscolaridad(dto.getConvocadoNivelEscolaridad());
        entidad.setConvocadoOcupacion(dto.getConvocadoOcupacion());
        entidad.setConvocadoPais(dto.getConvocadoPais());
        entidad.setConvocadoDepartamento(dto.getConvocadoDepartamento());
        entidad.setConvocadoCiudad(dto.getConvocadoCiudad());
        entidad.setConvocadoMunicipio(dto.getConvocadoMunicipio());
        entidad.setConvocadoDireccion(dto.getConvocadoDireccion());
        entidad.setConvocadoLocalidad(dto.getConvocadoLocalidad());
        entidad.setConvocadoBarrio(dto.getConvocadoBarrio());
        entidad.setConvocadoCorreo(dto.getConvocadoCorreo());

        // Empresa - MAPEAR TODOS LOS CAMPOS
        entidad.setEmpresaNombre(dto.getEmpresaNombre());
        entidad.setEmpresaNit(dto.getEmpresaNit());
        entidad.setEmpresaRepresentante(dto.getEmpresaRepresentante());
        entidad.setEmpresaCc(dto.getEmpresaCc());
        entidad.setEmpresaDireccion(dto.getEmpresaDireccion());
        entidad.setEmpresaTelefono(dto.getEmpresaTelefono());
        entidad.setEmpresaCorreo(dto.getEmpresaCorreo());

        // Apoderado - MAPEAR TODOS LOS CAMPOS
        entidad.setApoderadoNombres(dto.getApoderadoNombres());
        entidad.setApoderadoCc(dto.getApoderadoCc());
        entidad.setApoderadoTp(dto.getApoderadoTp());
        entidad.setApoderadoDireccion(dto.getApoderadoDireccion());
        entidad.setApoderadoCiudad(dto.getApoderadoCiudad());
        entidad.setApoderadoTelefono(dto.getApoderadoTelefono());
        entidad.setApoderadoCorreo(dto.getApoderadoCorreo());

        // Área del conflicto
        entidad.setAreaCivil(dto.getAreaCivil());
        entidad.setAreaFamilia(dto.getAreaFamilia());
        entidad.setAreaComercial(dto.getAreaComercial());
        entidad.setAreaPenal(dto.getAreaPenal());
        entidad.setAreaConvivencia(dto.getAreaConvivencia());

        // Hechos
        entidad.setHechoPrimero(dto.getHechoPrimero());
        entidad.setHechoSegundo(dto.getHechoSegundo());
        entidad.setHechoTercero(dto.getHechoTercero());
        entidad.setHechoCuarto(dto.getHechoCuarto());
        entidad.setHechoQuinto(dto.getHechoQuinto());

        // Pretensiones
        entidad.setPretensionPrimera(dto.getPretensionPrimera());
        entidad.setPretensionSegunda(dto.getPretensionSegunda());
        entidad.setPretensionTercera(dto.getPretensionTercera());

        // Cuantía - MAPEAR TODOS LOS CAMPOS
        entidad.setCuantiaEstimada(dto.getCuantiaEstimada());
        entidad.setCuantiaIndeterminada(dto.getCuantiaIndeterminada());
        entidad.setTiempoConflicto(dto.getTiempoConflicto());
        entidad.setActaPrevia(dto.getActaPrevia());

        // Anexos - MAPEAR TODOS LOS CAMPOS
        entidad.setAnexoCopiaServ(dto.getAnexoCopiaServ());
        entidad.setAnexoCcConvocante(dto.getAnexoCcConvocante());
        entidad.setAnexoRcivil(dto.getAnexoRcivil());
        entidad.setAnexoContrato(dto.getAnexoContrato());
        entidad.setAnexoCertReprest(dto.getAnexoCertReprest());
        entidad.setAnexoTituloVr(dto.getAnexoTituloVr());
        entidad.setAnexoSentencia(dto.getAnexoSentencia());
        entidad.setAnexoOtros(dto.getAnexoOtros());

        // Notificaciones - MAPEAR TODOS LOS CAMPOS
        entidad.setNotifSolicitanteNombres(dto.getNotifSolicitanteNombres());
        entidad.setNotifSolicitanteDireccion(dto.getNotifSolicitanteDireccion());
        entidad.setNotifSolicitanteCiudad(dto.getNotifSolicitanteCiudad());
        entidad.setNotifSolicitanteTelefonos(dto.getNotifSolicitanteTelefonos());
        entidad.setNotifSolicitanteCelulares(dto.getNotifSolicitanteCelulares());
        entidad.setNotifSolicitanteCorreo(dto.getNotifSolicitanteCorreo());
        
        entidad.setNotifApoderadoNombres(dto.getNotifApoderadoNombres());
        entidad.setNotifApoderadoDomicilio(dto.getNotifApoderadoDomicilio());
        entidad.setNotifApoderadoCiudad(dto.getNotifApoderadoCiudad());
        entidad.setNotifApoderadoCc(dto.getNotifApoderadoCc());
        entidad.setNotifApoderadoTp(dto.getNotifApoderadoTp());
        entidad.setNotifApoderadoTelefonos(dto.getNotifApoderadoTelefonos());
        entidad.setNotifApoderadoCelulares(dto.getNotifApoderadoCelulares());
        entidad.setNotifApoderadoCorreo(dto.getNotifApoderadoCorreo());
        
        entidad.setNotifSolicitadosNombres(dto.getNotifSolicitadosNombres());
        entidad.setNotifSolicitadosDireccion(dto.getNotifSolicitadosDireccion());
        entidad.setNotifSolicitadosCiudad(dto.getNotifSolicitadosCiudad());
        entidad.setNotifSolicitadosTelefonos(dto.getNotifSolicitadosTelefonos());
        entidad.setNotifSolicitadosCelulares(dto.getNotifSolicitadosCelulares());
        entidad.setNotifSolicitadosCorreo(dto.getNotifSolicitadosCorreo());

        // Firmas - MAPEAR TODOS LOS CAMPOS
        entidad.setSolicitanteCc(dto.getSolicitanteCc());
        entidad.setAsesorNombreCelular(dto.getAsesorNombreCelular());
    }
}