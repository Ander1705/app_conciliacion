-- La base de datos ya será creada por las variables de entorno
-- CREATE DATABASE conciliacion_db;

-- Crear tabla de solicitudes de conciliación
CREATE TABLE IF NOT EXISTS solicitudes_conciliacion (
    id SERIAL PRIMARY KEY,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    -- Identificación
    ciudad_fecha VARCHAR(255),
    numero_solicitud VARCHAR(50),
    
    -- Convocante
    conv_primer_nombre VARCHAR(100),
    conv_segundo_nombre VARCHAR(100),
    conv_primer_apellido VARCHAR(100),
    conv_segundo_apellido VARCHAR(100),
    conv_tipo_documento VARCHAR(20),
    conv_numero_documento VARCHAR(30),
    conv_fecha_expedicion VARCHAR(100),
    conv_fecha_nacimiento DATE,
    conv_edad INTEGER,
    conv_celular VARCHAR(20),
    conv_whatsapp VARCHAR(20),
    conv_estado_civil VARCHAR(50),
    conv_genero VARCHAR(20),
    conv_sexo VARCHAR(20),
    conv_grupo_etnico VARCHAR(100),
    conv_discapacidad BOOLEAN,
    conv_cual_discapacidad VARCHAR(200),
    conv_estrato INTEGER,
    conv_nivel_escolaridad VARCHAR(100),
    conv_ocupacion VARCHAR(100),
    conv_pais VARCHAR(100),
    conv_departamento VARCHAR(100),
    conv_ciudad VARCHAR(100),
    conv_municipio VARCHAR(100),
    conv_direccion VARCHAR(200),
    conv_localidad VARCHAR(100),
    conv_barrio VARCHAR(100),
    conv_correo VARCHAR(150),
    
    -- Convocado
    convocado_primer_nombre VARCHAR(100),
    convocado_segundo_nombre VARCHAR(100),
    convocado_primer_apellido VARCHAR(100),
    convocado_segundo_apellido VARCHAR(100),
    convocado_tipo_documento VARCHAR(20),
    convocado_numero_documento VARCHAR(30),
    convocado_fecha_expedicion VARCHAR(100),
    convocado_fecha_nacimiento DATE,
    convocado_edad INTEGER,
    convocado_celular VARCHAR(20),
    convocado_whatsapp VARCHAR(20),
    convocado_estado_civil VARCHAR(50),
    convocado_genero VARCHAR(20),
    convocado_sexo VARCHAR(20),
    convocado_grupo_etnico VARCHAR(100),
    convocado_discapacidad BOOLEAN,
    convocado_cual_discapacidad VARCHAR(200),
    convocado_estrato INTEGER,
    convocado_nivel_escolaridad VARCHAR(100),
    convocado_ocupacion VARCHAR(100),
    convocado_pais VARCHAR(100),
    convocado_departamento VARCHAR(100),
    convocado_ciudad VARCHAR(100),
    convocado_municipio VARCHAR(100),
    convocado_direccion VARCHAR(200),
    convocado_localidad VARCHAR(100),
    convocado_barrio VARCHAR(100),
    convocado_correo VARCHAR(150),
    
    -- Persona Jurídica
    empresa_nombre VARCHAR(200),
    empresa_nit VARCHAR(30),
    empresa_representante VARCHAR(200),
    empresa_cc VARCHAR(30),
    empresa_direccion VARCHAR(200),
    empresa_telefono VARCHAR(20),
    empresa_correo VARCHAR(150),
    
    -- Apoderado
    apoderado_nombres VARCHAR(200),
    apoderado_cc VARCHAR(30),
    apoderado_tp VARCHAR(30),
    apoderado_direccion VARCHAR(200),
    apoderado_ciudad VARCHAR(100),
    apoderado_telefono VARCHAR(20),
    apoderado_correo VARCHAR(150),
    
    -- Área del conflicto
    area_civil BOOLEAN DEFAULT FALSE,
    area_familia BOOLEAN DEFAULT FALSE,
    area_comercial BOOLEAN DEFAULT FALSE,
    area_penal BOOLEAN DEFAULT FALSE,
    area_convivencia BOOLEAN DEFAULT FALSE,
    
    -- Hechos
    hecho_primero TEXT,
    hecho_segundo TEXT,
    hecho_tercero TEXT,
    hecho_cuarto TEXT,
    hecho_quinto TEXT,
    
    -- Pretensiones
    pretension_primera TEXT,
    pretension_segunda TEXT,
    pretension_tercera TEXT,
    
    -- Cuantía
    cuantia_estimada DECIMAL(15,2),
    cuantia_indeterminada BOOLEAN DEFAULT FALSE,
    tiempo_conflicto VARCHAR(200),
    acta_previa BOOLEAN,
    
    -- Anexos
    anexo_copia_serv BOOLEAN DEFAULT FALSE,
    anexo_cc_convocante BOOLEAN DEFAULT FALSE,
    anexo_rcivil BOOLEAN DEFAULT FALSE,
    anexo_contrato BOOLEAN DEFAULT FALSE,
    anexo_cert_represt BOOLEAN DEFAULT FALSE,
    anexo_titulo_vr BOOLEAN DEFAULT FALSE,
    anexo_sentencia BOOLEAN DEFAULT FALSE,
    anexo_otros VARCHAR(200),
    
    -- Notificaciones
    notif_solicitante_nombres VARCHAR(200),
    notif_solicitante_direccion VARCHAR(200),
    notif_solicitante_ciudad VARCHAR(100),
    notif_solicitante_telefonos VARCHAR(50),
    notif_solicitante_celulares VARCHAR(50),
    notif_solicitante_correo VARCHAR(150),
    
    notif_apoderado_nombres VARCHAR(200),
    notif_apoderado_domicilio VARCHAR(200),
    notif_apoderado_ciudad VARCHAR(100),
    notif_apoderado_cc VARCHAR(30),
    notif_apoderado_tp VARCHAR(30),
    notif_apoderado_telefonos VARCHAR(50),
    notif_apoderado_celulares VARCHAR(50),
    notif_apoderado_correo VARCHAR(150),
    
    notif_solicitados_nombres VARCHAR(200),
    notif_solicitados_direccion VARCHAR(200),
    notif_solicitados_ciudad VARCHAR(100),
    notif_solicitados_telefonos VARCHAR(50),
    notif_solicitados_celulares VARCHAR(50),
    notif_solicitados_correo VARCHAR(150),
    
    -- Firmas
    solicitante_cc VARCHAR(30),
    asesor_nombre_celular VARCHAR(200),
    
    -- Control
    pdf_generado BOOLEAN DEFAULT FALSE,
    ruta_pdf VARCHAR(500),
    ip_cliente INET
);

-- Función para generar número de solicitud automático
CREATE OR REPLACE FUNCTION generate_solicitud_number()
RETURNS TRIGGER AS $$
DECLARE
    current_year INTEGER;
    next_number INTEGER;
    new_number VARCHAR(50);
BEGIN
    current_year := EXTRACT(YEAR FROM CURRENT_DATE);
    
    SELECT COALESCE(MAX(CAST(SUBSTRING(numero_solicitud FROM '[0-9]+') AS INTEGER)), 0) + 1
    INTO next_number
    FROM solicitudes_conciliacion
    WHERE numero_solicitud LIKE current_year || '-%';
    
    new_number := current_year || '-' || LPAD(next_number::TEXT, 4, '0');
    NEW.numero_solicitud := new_number;
    
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear trigger para generar número automáticamente
CREATE TRIGGER trigger_generate_solicitud_number
    BEFORE INSERT ON solicitudes_conciliacion
    FOR EACH ROW
    WHEN (NEW.numero_solicitud IS NULL)
    EXECUTE FUNCTION generate_solicitud_number();

-- Índices para optimizar consultas
CREATE INDEX IF NOT EXISTS idx_solicitudes_numero ON solicitudes_conciliacion(numero_solicitud);
CREATE INDEX IF NOT EXISTS idx_solicitudes_fecha ON solicitudes_conciliacion(fecha_creacion);
CREATE INDEX IF NOT EXISTS idx_solicitudes_convocante_doc ON solicitudes_conciliacion(conv_numero_documento);
CREATE INDEX IF NOT EXISTS idx_solicitudes_convocado_doc ON solicitudes_conciliacion(convocado_numero_documento);