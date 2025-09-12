package co.edu.universidadmayor.conciliacion.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes_conciliacion")
public class Solicitud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    
    @Column(name = "ciudad_fecha")
    private String ciudadFecha;
    
    @Column(name = "numero_solicitud")
    private String numeroSolicitud;
    
    @Column(name = "conv_primer_nombre", length = 100)
    private String convPrimerNombre;
    
    @Column(name = "conv_segundo_nombre", length = 100)
    private String convSegundoNombre;
    
    @Column(name = "conv_primer_apellido", length = 100)
    private String convPrimerApellido;
    
    @Column(name = "conv_segundo_apellido", length = 100)
    private String convSegundoApellido;
    
    @Column(name = "conv_tipo_documento", length = 20)
    private String convTipoDocumento;
    
    @Column(name = "conv_numero_documento", length = 30)
    private String convNumeroDocumento;
    
    @Column(name = "conv_fecha_expedicion", length = 100)
    private String convFechaExpedicion;
    
    @Column(name = "conv_fecha_nacimiento")
    private LocalDate convFechaNacimiento;
    
    @Column(name = "conv_edad")
    private Integer convEdad;
    
    @Column(name = "conv_celular", length = 20)
    private String convCelular;
    
    @Column(name = "conv_whatsapp", length = 20)
    private String convWhatsapp;
    
    @Column(name = "conv_estado_civil", length = 50)
    private String convEstadoCivil;
    
    @Column(name = "conv_genero", length = 20)
    private String convGenero;
    
    @Column(name = "conv_sexo", length = 20)
    private String convSexo;
    
    @Column(name = "conv_grupo_etnico", length = 100)
    private String convGrupoEtnico;
    
    @Column(name = "conv_discapacidad")
    private Boolean convDiscapacidad = false;
    
    @Column(name = "conv_cual_discapacidad", length = 200)
    private String convCualDiscapacidad;
    
    @Column(name = "conv_estrato")
    private Integer convEstrato;
    
    @Column(name = "conv_nivel_escolaridad", length = 100)
    private String convNivelEscolaridad;
    
    @Column(name = "conv_ocupacion", length = 100)
    private String convOcupacion;
    
    @Column(name = "conv_pais", length = 100)
    private String convPais;
    
    @Column(name = "conv_departamento", length = 100)
    private String convDepartamento;
    
    @Column(name = "conv_ciudad", length = 100)
    private String convCiudad;
    
    @Column(name = "conv_municipio", length = 100)
    private String convMunicipio;
    
    @Column(name = "conv_direccion", length = 200)
    private String convDireccion;
    
    @Column(name = "conv_localidad", length = 100)
    private String convLocalidad;
    
    @Column(name = "conv_barrio", length = 100)
    private String convBarrio;
    
    @Email
    @Column(name = "conv_correo", length = 150)
    private String convCorreo;
    
    @Column(name = "convocado_primer_nombre", length = 100)
    private String convocadoPrimerNombre;
    
    @Column(name = "convocado_segundo_nombre", length = 100)
    private String convocadoSegundoNombre;
    
    @Column(name = "convocado_primer_apellido", length = 100)
    private String convocadoPrimerApellido;
    
    @Column(name = "convocado_segundo_apellido", length = 100)
    private String convocadoSegundoApellido;
    
    @Column(name = "convocado_tipo_documento", length = 20)
    private String convocadoTipoDocumento;
    
    @Column(name = "convocado_numero_documento", length = 30)
    private String convocadoNumeroDocumento;
    
    @Column(name = "convocado_fecha_expedicion", length = 100)
    private String convocadoFechaExpedicion;
    
    @Column(name = "convocado_fecha_nacimiento")
    private LocalDate convocadoFechaNacimiento;
    
    @Column(name = "convocado_edad")
    private Integer convocadoEdad;
    
    @Column(name = "convocado_celular", length = 20)
    private String convocadoCelular;
    
    @Column(name = "convocado_whatsapp", length = 20)
    private String convocadoWhatsapp;
    
    @Column(name = "convocado_estado_civil", length = 50)
    private String convocadoEstadoCivil;
    
    @Column(name = "convocado_genero", length = 20)
    private String convocadoGenero;
    
    @Column(name = "convocado_sexo", length = 20)
    private String convocadoSexo;
    
    @Column(name = "convocado_grupo_etnico", length = 100)
    private String convocadoGrupoEtnico;
    
    @Column(name = "convocado_discapacidad")
    private Boolean convocadoDiscapacidad = false;
    
    @Column(name = "convocado_cual_discapacidad", length = 200)
    private String convocadoCualDiscapacidad;
    
    @Column(name = "convocado_estrato")
    private Integer convocadoEstrato;
    
    @Column(name = "convocado_nivel_escolaridad", length = 100)
    private String convocadoNivelEscolaridad;
    
    @Column(name = "convocado_ocupacion", length = 100)
    private String convocadoOcupacion;
    
    @Column(name = "convocado_pais", length = 100)
    private String convocadoPais;
    
    @Column(name = "convocado_departamento", length = 100)
    private String convocadoDepartamento;
    
    @Column(name = "convocado_ciudad", length = 100)
    private String convocadoCiudad;
    
    @Column(name = "convocado_municipio", length = 100)
    private String convocadoMunicipio;
    
    @Column(name = "convocado_direccion", length = 200)
    private String convocadoDireccion;
    
    @Column(name = "convocado_localidad", length = 100)
    private String convocadoLocalidad;
    
    @Column(name = "convocado_barrio", length = 100)
    private String convocadoBarrio;
    
    @Email
    @Column(name = "convocado_correo", length = 150)
    private String convocadoCorreo;
    
    @Column(name = "empresa_nombre", length = 200)
    private String empresaNombre;
    
    @Column(name = "empresa_nit", length = 30)
    private String empresaNit;
    
    @Column(name = "empresa_representante", length = 200)
    private String empresaRepresentante;
    
    @Column(name = "empresa_cc", length = 30)
    private String empresaCc;
    
    @Column(name = "empresa_direccion", length = 200)
    private String empresaDireccion;
    
    @Column(name = "empresa_telefono", length = 20)
    private String empresaTelefono;
    
    @Email
    @Column(name = "empresa_correo", length = 150)
    private String empresaCorreo;
    
    @Column(name = "apoderado_nombres", length = 200)
    private String apoderadoNombres;
    
    @Column(name = "apoderado_cc", length = 30)
    private String apoderadoCc;
    
    @Column(name = "apoderado_tp", length = 30)
    private String apoderadoTp;
    
    @Column(name = "apoderado_direccion", length = 200)
    private String apoderadoDireccion;
    
    @Column(name = "apoderado_ciudad", length = 100)
    private String apoderadoCiudad;
    
    @Column(name = "apoderado_telefono", length = 20)
    private String apoderadoTelefono;
    
    @Email
    @Column(name = "apoderado_correo", length = 150)
    private String apoderadoCorreo;
    
    @Column(name = "area_civil")
    private Boolean areaCivil = false;
    
    @Column(name = "area_familia")
    private Boolean areaFamilia = false;
    
    @Column(name = "area_comercial")
    private Boolean areaComercial = false;
    
    @Column(name = "area_penal")
    private Boolean areaPenal = false;
    
    @Column(name = "area_convivencia")
    private Boolean areaConvivencia = false;
    
    @Column(name = "hecho_primero", columnDefinition = "TEXT")
    private String hechoPrimero;
    
    @Column(name = "hecho_segundo", columnDefinition = "TEXT")
    private String hechoSegundo;
    
    @Column(name = "hecho_tercero", columnDefinition = "TEXT")
    private String hechoTercero;
    
    @Column(name = "hecho_cuarto", columnDefinition = "TEXT")
    private String hechoCuarto;
    
    @Column(name = "hecho_quinto", columnDefinition = "TEXT")
    private String hechoQuinto;
    
    @Column(name = "pretension_primera", columnDefinition = "TEXT")
    private String pretensionPrimera;
    
    @Column(name = "pretension_segunda", columnDefinition = "TEXT")
    private String pretensionSegunda;
    
    @Column(name = "pretension_tercera", columnDefinition = "TEXT")
    private String pretensionTercera;
    
    @Column(name = "cuantia_estimada", precision = 15, scale = 2)
    private BigDecimal cuantiaEstimada;
    
    @Column(name = "cuantia_indeterminada")
    private Boolean cuantiaIndeterminada = false;
    
    @Column(name = "tiempo_conflicto", length = 200)
    private String tiempoConflicto;
    
    @Column(name = "acta_previa")
    private Boolean actaPrevia;
    
    @Column(name = "anexo_copia_serv")
    private Boolean anexoCopiaServ = false;
    
    @Column(name = "anexo_cc_convocante")
    private Boolean anexoCcConvocante = false;
    
    @Column(name = "anexo_rcivil")
    private Boolean anexoRcivil = false;
    
    @Column(name = "anexo_contrato")
    private Boolean anexoContrato = false;
    
    @Column(name = "anexo_cert_represt")
    private Boolean anexoCertReprest = false;
    
    @Column(name = "anexo_titulo_vr")
    private Boolean anexoTituloVr = false;
    
    @Column(name = "anexo_sentencia")
    private Boolean anexoSentencia = false;
    
    @Column(name = "anexo_otros", length = 200)
    private String anexoOtros;
    
    @Column(name = "notif_solicitante_nombres", length = 200)
    private String notifSolicitanteNombres;
    
    @Column(name = "notif_solicitante_direccion", length = 200)
    private String notifSolicitanteDireccion;
    
    @Column(name = "notif_solicitante_ciudad", length = 100)
    private String notifSolicitanteCiudad;
    
    @Column(name = "notif_solicitante_telefonos", length = 50)
    private String notifSolicitanteTelefonos;
    
    @Column(name = "notif_solicitante_celulares", length = 50)
    private String notifSolicitanteCelulares;
    
    @Email
    @Column(name = "notif_solicitante_correo", length = 150)
    private String notifSolicitanteCorreo;
    
    @Column(name = "notif_apoderado_nombres", length = 200)
    private String notifApoderadoNombres;
    
    @Column(name = "notif_apoderado_domicilio", length = 200)
    private String notifApoderadoDomicilio;
    
    @Column(name = "notif_apoderado_ciudad", length = 100)
    private String notifApoderadoCiudad;
    
    @Column(name = "notif_apoderado_cc", length = 30)
    private String notifApoderadoCc;
    
    @Column(name = "notif_apoderado_tp", length = 30)
    private String notifApoderadoTp;
    
    @Column(name = "notif_apoderado_telefonos", length = 50)
    private String notifApoderadoTelefonos;
    
    @Column(name = "notif_apoderado_celulares", length = 50)
    private String notifApoderadoCelulares;
    
    @Email
    @Column(name = "notif_apoderado_correo", length = 150)
    private String notifApoderadoCorreo;
    
    @Column(name = "notif_solicitados_nombres", length = 200)
    private String notifSolicitadosNombres;
    
    @Column(name = "notif_solicitados_direccion", length = 200)
    private String notifSolicitadosDireccion;
    
    @Column(name = "notif_solicitados_ciudad", length = 100)
    private String notifSolicitadosCiudad;
    
    @Column(name = "notif_solicitados_telefonos", length = 50)
    private String notifSolicitadosTelefonos;
    
    @Column(name = "notif_solicitados_celulares", length = 50)
    private String notifSolicitadosCelulares;
    
    @Email
    @Column(name = "notif_solicitados_correo", length = 150)
    private String notifSolicitadosCorreo;
    
    @Column(name = "solicitante_cc", length = 30)
    private String solicitanteCc;
    
    @Column(name = "asesor_nombre_celular", length = 200)
    private String asesorNombreCelular;
    
    @Column(name = "pdf_generado")
    private Boolean pdfGenerado = false;
    
    @Column(name = "ruta_pdf", length = 500)
    private String rutaPdf;
    
    @Column(name = "ip_cliente", length = 45)
    private String ipCliente;

    public Solicitud() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getCiudadFecha() { return ciudadFecha; }
    public void setCiudadFecha(String ciudadFecha) { this.ciudadFecha = ciudadFecha; }

    public String getNumeroSolicitud() { return numeroSolicitud; }
    public void setNumeroSolicitud(String numeroSolicitud) { this.numeroSolicitud = numeroSolicitud; }

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

    public String getConvocadoPrimerNombre() { return convocadoPrimerNombre; }
    public void setConvocadoPrimerNombre(String convocadoPrimerNombre) { this.convocadoPrimerNombre = convocadoPrimerNombre; }

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

    public String getEmpresaNombre() { return empresaNombre; }
    public void setEmpresaNombre(String empresaNombre) { this.empresaNombre = empresaNombre; }

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

    public String getPretensionPrimera() { return pretensionPrimera; }
    public void setPretensionPrimera(String pretensionPrimera) { this.pretensionPrimera = pretensionPrimera; }

    public String getPretensionSegunda() { return pretensionSegunda; }
    public void setPretensionSegunda(String pretensionSegunda) { this.pretensionSegunda = pretensionSegunda; }

    public String getPretensionTercera() { return pretensionTercera; }
    public void setPretensionTercera(String pretensionTercera) { this.pretensionTercera = pretensionTercera; }

    public BigDecimal getCuantiaEstimada() { return cuantiaEstimada; }
    public void setCuantiaEstimada(BigDecimal cuantiaEstimada) { this.cuantiaEstimada = cuantiaEstimada; }

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

    public String getSolicitanteCc() { return solicitanteCc; }
    public void setSolicitanteCc(String solicitanteCc) { this.solicitanteCc = solicitanteCc; }

    public String getAsesorNombreCelular() { return asesorNombreCelular; }
    public void setAsesorNombreCelular(String asesorNombreCelular) { this.asesorNombreCelular = asesorNombreCelular; }

    public Boolean getPdfGenerado() { return pdfGenerado; }
    public void setPdfGenerado(Boolean pdfGenerado) { this.pdfGenerado = pdfGenerado; }

    public String getRutaPdf() { return rutaPdf; }
    public void setRutaPdf(String rutaPdf) { this.rutaPdf = rutaPdf; }

    public String getIpCliente() { return ipCliente; }
    public void setIpCliente(String ipCliente) { this.ipCliente = ipCliente; }
}