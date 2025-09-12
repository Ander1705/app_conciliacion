package co.edu.universidadmayor.conciliacion.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SolicitudDTO {
    
    // Datos generales
    private String ciudadFecha;
    
    // Convocante
    private String convPrimerNombre;
    private String convSegundoNombre;
    private String convPrimerApellido;
    private String convSegundoApellido;
    private String convTipoDocumento;
    private String convNumeroDocumento;
    private String convFechaExpedicion;
    private LocalDate convFechaNacimiento;
    private Integer convEdad;
    private String convCelular;
    private String convWhatsapp;
    private String convEstadoCivil;
    private String convGenero;
    private String convSexo;
    private String convGrupoEtnico;
    private Boolean convDiscapacidad = false;
    private String convCualDiscapacidad;
    private Integer convEstrato;
    private String convNivelEscolaridad;
    private String convOcupacion;
    private String convPais;
    private String convDepartamento;
    private String convCiudad;
    private String convMunicipio;
    private String convDireccion;
    private String convLocalidad;
    private String convBarrio;
    @Email(message = "El correo del convocante debe ser válido")
    private String convCorreo;
    
    // Convocado
    private String convocadoPrimerNombre;
    private String convocadoSegundoNombre;
    private String convocadoPrimerApellido;
    private String convocadoSegundoApellido;
    private String convocadoTipoDocumento;
    private String convocadoNumeroDocumento;
    private String convocadoFechaExpedicion;
    private LocalDate convocadoFechaNacimiento;
    private Integer convocadoEdad;
    private String convocadoCelular;
    private String convocadoWhatsapp;
    private String convocadoEstadoCivil;
    private String convocadoGenero;
    private String convocadoSexo;
    private String convocadoGrupoEtnico;
    private Boolean convocadoDiscapacidad = false;
    private String convocadoCualDiscapacidad;
    private Integer convocadoEstrato;
    private String convocadoNivelEscolaridad;
    private String convocadoOcupacion;
    private String convocadoPais;
    private String convocadoDepartamento;
    private String convocadoCiudad;
    private String convocadoMunicipio;
    private String convocadoDireccion;
    private String convocadoLocalidad;
    private String convocadoBarrio;
    @Email(message = "El correo del convocado debe ser válido")
    private String convocadoCorreo;
    
    // Persona Jurídica
    private String empresaNombre;
    private String empresaNit;
    private String empresaRepresentante;
    private String empresaCc;
    private String empresaDireccion;
    private String empresaTelefono;
    @Email(message = "El correo de la empresa debe ser válido")
    private String empresaCorreo;
    
    // Apoderado
    private String apoderadoNombres;
    private String apoderadoCc;
    private String apoderadoTp;
    private String apoderadoDireccion;
    private String apoderadoCiudad;
    private String apoderadoTelefono;
    @Email(message = "El correo del apoderado debe ser válido")
    private String apoderadoCorreo;
    
    // Área del conflicto
    private Boolean areaCivil = false;
    private Boolean areaFamilia = false;
    private Boolean areaComercial = false;
    private Boolean areaPenal = false;
    private Boolean areaConvivencia = false;
    
    // Hechos
    @JsonProperty("hechoPrimero")
    private String hechoPrimero;
    
    @JsonProperty("hechoSegundo")
    private String hechoSegundo;
    
    @JsonProperty("hechoTercero")
    private String hechoTercero;
    
    @JsonProperty("hechoCuarto")
    private String hechoCuarto;
    
    @JsonProperty("hechoQuinto")
    private String hechoQuinto;
    
    // Pretensiones
    @JsonProperty("pretensionPrimera")
    private String pretensionPrimera;
    
    @JsonProperty("pretensionSegunda")
    private String pretensionSegunda;
    
    @JsonProperty("pretensionTercera")
    private String pretensionTercera;
    
    // Cuantía
    private BigDecimal cuantiaEstimada;
    private Boolean cuantiaIndeterminada = false;
    private String tiempoConflicto;
    private Boolean actaPrevia;
    
    // Anexos
    private Boolean anexoCopiaServ = false;
    private Boolean anexoCcConvocante = false;
    private Boolean anexoRcivil = false;
    private Boolean anexoContrato = false;
    private Boolean anexoCertReprest = false;
    private Boolean anexoTituloVr = false;
    private Boolean anexoSentencia = false;
    private String anexoOtros;
    
    // Notificaciones
    private String notifSolicitanteNombres;
    private String notifSolicitanteDireccion;
    private String notifSolicitanteCiudad;
    private String notifSolicitanteTelefonos;
    private String notifSolicitanteCelulares;
    @Email(message = "El correo para notificaciones del solicitante debe ser válido")
    private String notifSolicitanteCorreo;
    
    private String notifApoderadoNombres;
    private String notifApoderadoDomicilio;
    private String notifApoderadoCiudad;
    private String notifApoderadoCc;
    private String notifApoderadoTp;
    private String notifApoderadoTelefonos;
    private String notifApoderadoCelulares;
    @Email(message = "El correo para notificaciones del apoderado debe ser válido")
    private String notifApoderadoCorreo;
    
    private String notifSolicitadosNombres;
    private String notifSolicitadosDireccion;
    private String notifSolicitadosCiudad;
    private String notifSolicitadosTelefonos;
    private String notifSolicitadosCelulares;
    @Email(message = "El correo para notificaciones de los solicitados debe ser válido")
    private String notifSolicitadosCorreo;
    
    // Firmas
    private String solicitanteCc;
    private String asesorNombreCelular;

    // Constructors
    public SolicitudDTO() {}

    // Getters and Setters
    public String getCiudadFecha() { return ciudadFecha; }
    public void setCiudadFecha(String ciudadFecha) { this.ciudadFecha = ciudadFecha; }

    public String getConvPrimerNombre() { return convPrimerNombre; }
    public void setConvPrimerNombre(String convPrimerNombre) { this.convPrimerNombre = convPrimerNombre; }

    public String getConvSegundoNombre() { return convSegundoNombre; }
    public void setConvSegundoNombre(String convSegundoNombre) { this.convSegundoNombre = convSegundoNombre; }

    public String getConvPrimerApellido() { return convPrimerApellido; }
    public void setConvPrimerApellido(String convPrimerApellido) { this.convPrimerApellido = convPrimerApellido; }

    public String getConvSegundoApellido() { return convSegundoApellido; }
    public void setConvSegundoApellido(String convSegundoApellido) { this.convSegundoApellido = convSegundoApellido; }

    public String getConvTipoDocumento() { return convTipoDocumento; }
    public void setConvTipoDocumento(String convTipoDocumento) { this.convTipoDocumento = convTipoDocumento; }

    public String getConvNumeroDocumento() { return convNumeroDocumento; }
    public void setConvNumeroDocumento(String convNumeroDocumento) { this.convNumeroDocumento = convNumeroDocumento; }

    public String getConvFechaExpedicion() { return convFechaExpedicion; }
    public void setConvFechaExpedicion(String convFechaExpedicion) { this.convFechaExpedicion = convFechaExpedicion; }

    public LocalDate getConvFechaNacimiento() { return convFechaNacimiento; }
    public void setConvFechaNacimiento(LocalDate convFechaNacimiento) { this.convFechaNacimiento = convFechaNacimiento; }

    public Integer getConvEdad() { return convEdad; }
    public void setConvEdad(Integer convEdad) { this.convEdad = convEdad; }

    public String getConvCelular() { return convCelular; }
    public void setConvCelular(String convCelular) { this.convCelular = convCelular; }

    public String getConvWhatsapp() { return convWhatsapp; }
    public void setConvWhatsapp(String convWhatsapp) { this.convWhatsapp = convWhatsapp; }

    public String getConvEstadoCivil() { return convEstadoCivil; }
    public void setConvEstadoCivil(String convEstadoCivil) { this.convEstadoCivil = convEstadoCivil; }

    public String getConvGenero() { return convGenero; }
    public void setConvGenero(String convGenero) { this.convGenero = convGenero; }

    public String getConvSexo() { return convSexo; }
    public void setConvSexo(String convSexo) { this.convSexo = convSexo; }

    public String getConvGrupoEtnico() { return convGrupoEtnico; }
    public void setConvGrupoEtnico(String convGrupoEtnico) { this.convGrupoEtnico = convGrupoEtnico; }

    public Boolean getConvDiscapacidad() { return convDiscapacidad; }
    public void setConvDiscapacidad(Boolean convDiscapacidad) { this.convDiscapacidad = convDiscapacidad; }

    public String getConvCualDiscapacidad() { return convCualDiscapacidad; }
    public void setConvCualDiscapacidad(String convCualDiscapacidad) { this.convCualDiscapacidad = convCualDiscapacidad; }

    public Integer getConvEstrato() { return convEstrato; }
    public void setConvEstrato(Integer convEstrato) { this.convEstrato = convEstrato; }

    public String getConvNivelEscolaridad() { return convNivelEscolaridad; }
    public void setConvNivelEscolaridad(String convNivelEscolaridad) { this.convNivelEscolaridad = convNivelEscolaridad; }

    public String getConvOcupacion() { return convOcupacion; }
    public void setConvOcupacion(String convOcupacion) { this.convOcupacion = convOcupacion; }

    public String getConvPais() { return convPais; }
    public void setConvPais(String convPais) { this.convPais = convPais; }

    public String getConvDepartamento() { return convDepartamento; }
    public void setConvDepartamento(String convDepartamento) { this.convDepartamento = convDepartamento; }

    public String getConvCiudad() { return convCiudad; }
    public void setConvCiudad(String convCiudad) { this.convCiudad = convCiudad; }

    public String getConvMunicipio() { return convMunicipio; }
    public void setConvMunicipio(String convMunicipio) { this.convMunicipio = convMunicipio; }

    public String getConvDireccion() { return convDireccion; }
    public void setConvDireccion(String convDireccion) { this.convDireccion = convDireccion; }

    public String getConvLocalidad() { return convLocalidad; }
    public void setConvLocalidad(String convLocalidad) { this.convLocalidad = convLocalidad; }

    public String getConvBarrio() { return convBarrio; }
    public void setConvBarrio(String convBarrio) { this.convBarrio = convBarrio; }

    public String getConvCorreo() { return convCorreo; }
    public void setConvCorreo(String convCorreo) { this.convCorreo = convCorreo; }

    // Getters y Setters para convocado (similar pattern)...
    // (Continuando con todos los getters y setters para mantener el código limpio)

    // Getters and setters para el resto de campos - implementar según necesidad
    // Por brevedad, mostraré algunos ejemplos clave:
    
    public String getConvocadoPrimerNombre() { return convocadoPrimerNombre; }
    public void setConvocadoPrimerNombre(String convocadoPrimerNombre) { this.convocadoPrimerNombre = convocadoPrimerNombre; }

    public String getEmpresaNombre() { return empresaNombre; }
    public void setEmpresaNombre(String empresaNombre) { this.empresaNombre = empresaNombre; }

    public Boolean getAreaCivil() { return areaCivil; }
    public void setAreaCivil(Boolean areaCivil) { this.areaCivil = areaCivil; }

    public Boolean getAreaFamilia() { return areaFamilia; }
    public void setAreaFamilia(Boolean areaFamilia) { this.areaFamilia = areaFamilia; }

    public Boolean getAreaComercial() { return areaComercial; }
    public void setAreaComercial(Boolean areaComercial) { this.areaComercial = areaComercial; }

    public Boolean getAreaPenal() { return areaPenal; }
    public void setAreaPenal(Boolean areaPenal) { this.areaPenal = areaPenal; }

    public Boolean getAreaConvivencia() { return areaConvivencia; }
    public void setAreaConvivencia(Boolean areaConvivencia) { this.areaConvivencia = areaConvivencia; }

    // Getters y Setters para TODOS los hechos
    public String getHechoPrimero() { return hechoPrimero; }
    public void setHechoPrimero(String hechoPrimero) { this.hechoPrimero = hechoPrimero; }

    public String getHechoSegundo() { return hechoSegundo; }
    public void setHechoSegundo(String hechoSegundo) { this.hechoSegundo = hechoSegundo; }

    public String getHechoTercero() { return hechoTercero; }
    public void setHechoTercero(String hechoTercero) { this.hechoTercero = hechoTercero; }

    public String getHechoCuarto() { return hechoCuarto; }
    public void setHechoCuarto(String hechoCuarto) { this.hechoCuarto = hechoCuarto; }

    public String getHechoQuinto() { return hechoQuinto; }
    public void setHechoQuinto(String hechoQuinto) { this.hechoQuinto = hechoQuinto; }

    // Getters y Setters para TODAS las pretensiones
    public String getPretensionPrimera() { return pretensionPrimera; }
    public void setPretensionPrimera(String pretensionPrimera) { this.pretensionPrimera = pretensionPrimera; }

    public String getPretensionSegunda() { return pretensionSegunda; }
    public void setPretensionSegunda(String pretensionSegunda) { this.pretensionSegunda = pretensionSegunda; }

    public String getPretensionTercera() { return pretensionTercera; }
    public void setPretensionTercera(String pretensionTercera) { this.pretensionTercera = pretensionTercera; }

    public BigDecimal getCuantiaEstimada() { return cuantiaEstimada; }
    public void setCuantiaEstimada(BigDecimal cuantiaEstimada) { this.cuantiaEstimada = cuantiaEstimada; }

    public String getSolicitanteCc() { return solicitanteCc; }
    public void setSolicitanteCc(String solicitanteCc) { this.solicitanteCc = solicitanteCc; }

    // ====================== TODOS LOS GETTERS Y SETTERS FALTANTES ======================
    
    // Convocado - COMPLETAR TODOS
    public String getConvocadoSegundoNombre() { return convocadoSegundoNombre; }
    public void setConvocadoSegundoNombre(String convocadoSegundoNombre) { this.convocadoSegundoNombre = convocadoSegundoNombre; }
    
    public String getConvocadoPrimerApellido() { return convocadoPrimerApellido; }
    public void setConvocadoPrimerApellido(String convocadoPrimerApellido) { this.convocadoPrimerApellido = convocadoPrimerApellido; }
    
    public String getConvocadoSegundoApellido() { return convocadoSegundoApellido; }
    public void setConvocadoSegundoApellido(String convocadoSegundoApellido) { this.convocadoSegundoApellido = convocadoSegundoApellido; }
    
    public String getConvocadoTipoDocumento() { return convocadoTipoDocumento; }
    public void setConvocadoTipoDocumento(String convocadoTipoDocumento) { this.convocadoTipoDocumento = convocadoTipoDocumento; }
    
    public String getConvocadoNumeroDocumento() { return convocadoNumeroDocumento; }
    public void setConvocadoNumeroDocumento(String convocadoNumeroDocumento) { this.convocadoNumeroDocumento = convocadoNumeroDocumento; }
    
    public String getConvocadoFechaExpedicion() { return convocadoFechaExpedicion; }
    public void setConvocadoFechaExpedicion(String convocadoFechaExpedicion) { this.convocadoFechaExpedicion = convocadoFechaExpedicion; }
    
    public LocalDate getConvocadoFechaNacimiento() { return convocadoFechaNacimiento; }
    public void setConvocadoFechaNacimiento(LocalDate convocadoFechaNacimiento) { this.convocadoFechaNacimiento = convocadoFechaNacimiento; }
    
    public Integer getConvocadoEdad() { return convocadoEdad; }
    public void setConvocadoEdad(Integer convocadoEdad) { this.convocadoEdad = convocadoEdad; }
    
    public String getConvocadoCelular() { return convocadoCelular; }
    public void setConvocadoCelular(String convocadoCelular) { this.convocadoCelular = convocadoCelular; }
    
    public String getConvocadoWhatsapp() { return convocadoWhatsapp; }
    public void setConvocadoWhatsapp(String convocadoWhatsapp) { this.convocadoWhatsapp = convocadoWhatsapp; }
    
    public String getConvocadoEstadoCivil() { return convocadoEstadoCivil; }
    public void setConvocadoEstadoCivil(String convocadoEstadoCivil) { this.convocadoEstadoCivil = convocadoEstadoCivil; }
    
    public String getConvocadoGenero() { return convocadoGenero; }
    public void setConvocadoGenero(String convocadoGenero) { this.convocadoGenero = convocadoGenero; }
    
    public String getConvocadoSexo() { return convocadoSexo; }
    public void setConvocadoSexo(String convocadoSexo) { this.convocadoSexo = convocadoSexo; }
    
    public String getConvocadoGrupoEtnico() { return convocadoGrupoEtnico; }
    public void setConvocadoGrupoEtnico(String convocadoGrupoEtnico) { this.convocadoGrupoEtnico = convocadoGrupoEtnico; }
    
    public Boolean getConvocadoDiscapacidad() { return convocadoDiscapacidad; }
    public void setConvocadoDiscapacidad(Boolean convocadoDiscapacidad) { this.convocadoDiscapacidad = convocadoDiscapacidad; }
    
    public String getConvocadoCualDiscapacidad() { return convocadoCualDiscapacidad; }
    public void setConvocadoCualDiscapacidad(String convocadoCualDiscapacidad) { this.convocadoCualDiscapacidad = convocadoCualDiscapacidad; }
    
    public Integer getConvocadoEstrato() { return convocadoEstrato; }
    public void setConvocadoEstrato(Integer convocadoEstrato) { this.convocadoEstrato = convocadoEstrato; }
    
    public String getConvocadoNivelEscolaridad() { return convocadoNivelEscolaridad; }
    public void setConvocadoNivelEscolaridad(String convocadoNivelEscolaridad) { this.convocadoNivelEscolaridad = convocadoNivelEscolaridad; }
    
    public String getConvocadoOcupacion() { return convocadoOcupacion; }
    public void setConvocadoOcupacion(String convocadoOcupacion) { this.convocadoOcupacion = convocadoOcupacion; }
    
    public String getConvocadoPais() { return convocadoPais; }
    public void setConvocadoPais(String convocadoPais) { this.convocadoPais = convocadoPais; }
    
    public String getConvocadoDepartamento() { return convocadoDepartamento; }
    public void setConvocadoDepartamento(String convocadoDepartamento) { this.convocadoDepartamento = convocadoDepartamento; }
    
    public String getConvocadoCiudad() { return convocadoCiudad; }
    public void setConvocadoCiudad(String convocadoCiudad) { this.convocadoCiudad = convocadoCiudad; }
    
    public String getConvocadoMunicipio() { return convocadoMunicipio; }
    public void setConvocadoMunicipio(String convocadoMunicipio) { this.convocadoMunicipio = convocadoMunicipio; }
    
    public String getConvocadoDireccion() { return convocadoDireccion; }
    public void setConvocadoDireccion(String convocadoDireccion) { this.convocadoDireccion = convocadoDireccion; }
    
    public String getConvocadoLocalidad() { return convocadoLocalidad; }
    public void setConvocadoLocalidad(String convocadoLocalidad) { this.convocadoLocalidad = convocadoLocalidad; }
    
    public String getConvocadoBarrio() { return convocadoBarrio; }
    public void setConvocadoBarrio(String convocadoBarrio) { this.convocadoBarrio = convocadoBarrio; }
    
    public String getConvocadoCorreo() { return convocadoCorreo; }
    public void setConvocadoCorreo(String convocadoCorreo) { this.convocadoCorreo = convocadoCorreo; }
    
    // Empresa - COMPLETAR TODOS
    public String getEmpresaNit() { return empresaNit; }
    public void setEmpresaNit(String empresaNit) { this.empresaNit = empresaNit; }
    
    public String getEmpresaRepresentante() { return empresaRepresentante; }
    public void setEmpresaRepresentante(String empresaRepresentante) { this.empresaRepresentante = empresaRepresentante; }
    
    public String getEmpresaCc() { return empresaCc; }
    public void setEmpresaCc(String empresaCc) { this.empresaCc = empresaCc; }
    
    public String getEmpresaDireccion() { return empresaDireccion; }
    public void setEmpresaDireccion(String empresaDireccion) { this.empresaDireccion = empresaDireccion; }
    
    public String getEmpresaTelefono() { return empresaTelefono; }
    public void setEmpresaTelefono(String empresaTelefono) { this.empresaTelefono = empresaTelefono; }
    
    public String getEmpresaCorreo() { return empresaCorreo; }
    public void setEmpresaCorreo(String empresaCorreo) { this.empresaCorreo = empresaCorreo; }
    
    // Apoderado - COMPLETAR TODOS
    public String getApoderadoNombres() { return apoderadoNombres; }
    public void setApoderadoNombres(String apoderadoNombres) { this.apoderadoNombres = apoderadoNombres; }
    
    public String getApoderadoCc() { return apoderadoCc; }
    public void setApoderadoCc(String apoderadoCc) { this.apoderadoCc = apoderadoCc; }
    
    public String getApoderadoTp() { return apoderadoTp; }
    public void setApoderadoTp(String apoderadoTp) { this.apoderadoTp = apoderadoTp; }
    
    public String getApoderadoDireccion() { return apoderadoDireccion; }
    public void setApoderadoDireccion(String apoderadoDireccion) { this.apoderadoDireccion = apoderadoDireccion; }
    
    public String getApoderadoCiudad() { return apoderadoCiudad; }
    public void setApoderadoCiudad(String apoderadoCiudad) { this.apoderadoCiudad = apoderadoCiudad; }
    
    public String getApoderadoTelefono() { return apoderadoTelefono; }
    public void setApoderadoTelefono(String apoderadoTelefono) { this.apoderadoTelefono = apoderadoTelefono; }
    
    public String getApoderadoCorreo() { return apoderadoCorreo; }
    public void setApoderadoCorreo(String apoderadoCorreo) { this.apoderadoCorreo = apoderadoCorreo; }
    
    // Cuantía y Anexos - COMPLETAR TODOS
    public Boolean getCuantiaIndeterminada() { return cuantiaIndeterminada; }
    public void setCuantiaIndeterminada(Boolean cuantiaIndeterminada) { this.cuantiaIndeterminada = cuantiaIndeterminada; }
    
    public String getTiempoConflicto() { return tiempoConflicto; }
    public void setTiempoConflicto(String tiempoConflicto) { this.tiempoConflicto = tiempoConflicto; }
    
    public Boolean getActaPrevia() { return actaPrevia; }
    public void setActaPrevia(Boolean actaPrevia) { this.actaPrevia = actaPrevia; }
    
    public Boolean getAnexoCopiaServ() { return anexoCopiaServ; }
    public void setAnexoCopiaServ(Boolean anexoCopiaServ) { this.anexoCopiaServ = anexoCopiaServ; }
    
    public Boolean getAnexoCcConvocante() { return anexoCcConvocante; }
    public void setAnexoCcConvocante(Boolean anexoCcConvocante) { this.anexoCcConvocante = anexoCcConvocante; }
    
    public Boolean getAnexoRcivil() { return anexoRcivil; }
    public void setAnexoRcivil(Boolean anexoRcivil) { this.anexoRcivil = anexoRcivil; }
    
    public Boolean getAnexoContrato() { return anexoContrato; }
    public void setAnexoContrato(Boolean anexoContrato) { this.anexoContrato = anexoContrato; }
    
    public Boolean getAnexoCertReprest() { return anexoCertReprest; }
    public void setAnexoCertReprest(Boolean anexoCertReprest) { this.anexoCertReprest = anexoCertReprest; }
    
    public Boolean getAnexoTituloVr() { return anexoTituloVr; }
    public void setAnexoTituloVr(Boolean anexoTituloVr) { this.anexoTituloVr = anexoTituloVr; }
    
    public Boolean getAnexoSentencia() { return anexoSentencia; }
    public void setAnexoSentencia(Boolean anexoSentencia) { this.anexoSentencia = anexoSentencia; }
    
    public String getAnexoOtros() { return anexoOtros; }
    public void setAnexoOtros(String anexoOtros) { this.anexoOtros = anexoOtros; }
    
    // Notificaciones - COMPLETAR TODOS
    public String getNotifSolicitanteNombres() { return notifSolicitanteNombres; }
    public void setNotifSolicitanteNombres(String notifSolicitanteNombres) { this.notifSolicitanteNombres = notifSolicitanteNombres; }
    
    public String getNotifSolicitanteDireccion() { return notifSolicitanteDireccion; }
    public void setNotifSolicitanteDireccion(String notifSolicitanteDireccion) { this.notifSolicitanteDireccion = notifSolicitanteDireccion; }
    
    public String getNotifSolicitanteCiudad() { return notifSolicitanteCiudad; }
    public void setNotifSolicitanteCiudad(String notifSolicitanteCiudad) { this.notifSolicitanteCiudad = notifSolicitanteCiudad; }
    
    public String getNotifSolicitanteTelefonos() { return notifSolicitanteTelefonos; }
    public void setNotifSolicitanteTelefonos(String notifSolicitanteTelefonos) { this.notifSolicitanteTelefonos = notifSolicitanteTelefonos; }
    
    public String getNotifSolicitanteCelulares() { return notifSolicitanteCelulares; }
    public void setNotifSolicitanteCelulares(String notifSolicitanteCelulares) { this.notifSolicitanteCelulares = notifSolicitanteCelulares; }
    
    public String getNotifSolicitanteCorreo() { return notifSolicitanteCorreo; }
    public void setNotifSolicitanteCorreo(String notifSolicitanteCorreo) { this.notifSolicitanteCorreo = notifSolicitanteCorreo; }
    
    public String getNotifApoderadoNombres() { return notifApoderadoNombres; }
    public void setNotifApoderadoNombres(String notifApoderadoNombres) { this.notifApoderadoNombres = notifApoderadoNombres; }
    
    public String getNotifApoderadoDomicilio() { return notifApoderadoDomicilio; }
    public void setNotifApoderadoDomicilio(String notifApoderadoDomicilio) { this.notifApoderadoDomicilio = notifApoderadoDomicilio; }
    
    public String getNotifApoderadoCiudad() { return notifApoderadoCiudad; }
    public void setNotifApoderadoCiudad(String notifApoderadoCiudad) { this.notifApoderadoCiudad = notifApoderadoCiudad; }
    
    public String getNotifApoderadoCc() { return notifApoderadoCc; }
    public void setNotifApoderadoCc(String notifApoderadoCc) { this.notifApoderadoCc = notifApoderadoCc; }
    
    public String getNotifApoderadoTp() { return notifApoderadoTp; }
    public void setNotifApoderadoTp(String notifApoderadoTp) { this.notifApoderadoTp = notifApoderadoTp; }
    
    public String getNotifApoderadoTelefonos() { return notifApoderadoTelefonos; }
    public void setNotifApoderadoTelefonos(String notifApoderadoTelefonos) { this.notifApoderadoTelefonos = notifApoderadoTelefonos; }
    
    public String getNotifApoderadoCelulares() { return notifApoderadoCelulares; }
    public void setNotifApoderadoCelulares(String notifApoderadoCelulares) { this.notifApoderadoCelulares = notifApoderadoCelulares; }
    
    public String getNotifApoderadoCorreo() { return notifApoderadoCorreo; }
    public void setNotifApoderadoCorreo(String notifApoderadoCorreo) { this.notifApoderadoCorreo = notifApoderadoCorreo; }
    
    public String getNotifSolicitadosNombres() { return notifSolicitadosNombres; }
    public void setNotifSolicitadosNombres(String notifSolicitadosNombres) { this.notifSolicitadosNombres = notifSolicitadosNombres; }
    
    public String getNotifSolicitadosDireccion() { return notifSolicitadosDireccion; }
    public void setNotifSolicitadosDireccion(String notifSolicitadosDireccion) { this.notifSolicitadosDireccion = notifSolicitadosDireccion; }
    
    public String getNotifSolicitadosCiudad() { return notifSolicitadosCiudad; }
    public void setNotifSolicitadosCiudad(String notifSolicitadosCiudad) { this.notifSolicitadosCiudad = notifSolicitadosCiudad; }
    
    public String getNotifSolicitadosTelefonos() { return notifSolicitadosTelefonos; }
    public void setNotifSolicitadosTelefonos(String notifSolicitadosTelefonos) { this.notifSolicitadosTelefonos = notifSolicitadosTelefonos; }
    
    public String getNotifSolicitadosCelulares() { return notifSolicitadosCelulares; }
    public void setNotifSolicitadosCelulares(String notifSolicitadosCelulares) { this.notifSolicitadosCelulares = notifSolicitadosCelulares; }
    
    public String getNotifSolicitadosCorreo() { return notifSolicitadosCorreo; }
    public void setNotifSolicitadosCorreo(String notifSolicitadosCorreo) { this.notifSolicitadosCorreo = notifSolicitadosCorreo; }
    
    public String getAsesorNombreCelular() { return asesorNombreCelular; }
    public void setAsesorNombreCelular(String asesorNombreCelular) { this.asesorNombreCelular = asesorNombreCelular; }

    // Método para validar que al menos un área esté seleccionada
    public boolean tieneAreaSeleccionada() {
        return areaCivil || areaFamilia || areaComercial || areaPenal || areaConvivencia;
    }
}