package co.edu.universidadmayor.conciliacion.service;

import co.edu.universidadmayor.conciliacion.model.entity.Solicitud;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.io.image.ImageDataFactory;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfGeneratorService {

    // Colores institucionales
    private static final DeviceRgb COLOR_NEGRO = new DeviceRgb(0, 0, 0);
    private static final DeviceRgb COLOR_AZUL_UCMC = new DeviceRgb(0, 51, 102);

    public byte[] generarPDF(Solicitud solicitud) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        try {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdfDoc = new PdfDocument(writer);
            // **TAMAÑO OFICIO (Legal) OBLIGATORIO según CLAUDE.md**
            Document document = new Document(pdfDoc, PageSize.LEGAL);
            
            // **MÁRGENES AJUSTADOS A CUADRO DE TEXTO**
            document.setMargins(25, 60, 35, 60); // top=30pt, right=65pt(2.3cm), bottom=40pt, left=65pt(2.3cm)
            
            // **FUENTES ARIAL según especificaciones CLAUDE.md**
            PdfFont fontBold = PdfFontFactory.createFont("Helvetica-Bold"); // Arial equivalente en iText
            PdfFont fontRegular = PdfFontFactory.createFont("Helvetica");   // Arial equivalente en iText
            PdfFont fontItalic = PdfFontFactory.createFont("Helvetica-Oblique"); // Arial Italic equivalente
            
                // **PÁGINA 1**
            generarPagina1(document, solicitud, fontBold, fontRegular, fontItalic);
            
            // **NUEVA PÁGINA**
            document.add(new com.itextpdf.layout.element.AreaBreak());
            
            // **PÁGINA 2**
            generarPagina2(document, solicitud, fontBold, fontRegular, fontItalic);
            
            document.close();
            return baos.toByteArray();
            
        } catch (Exception e) {
            throw new Exception("Error generando PDF: " + e.getMessage(), e);
        }
    }

    private void generarPagina1(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular, PdfFont fontItalic) throws IOException {
        // **HEADER CON ESCUDO CENTRADO EXACTO AL ORIGINAL**
        generarHeaderConEscudo(document, fontBold, fontRegular, fontItalic, "1 de 2");
        
        // **ESPACIADO ULTRA-MÍNIMO DESPUÉS DEL HEADER**
        document.add(new Paragraph(" ").setFixedLeading(0.5f).setMarginBottom(0.5f));

        // **DATOS PRINCIPALES - TAMAÑO OPTIMIZADO PARA LLENAR PÁGINA**
        String ciudadFecha = obtenerValor(solicitud.getCiudadFecha());
        String numeroSolicitud = ""; // DEJARLO VACÍO POR SOLICITUD DEL USUARIO
        // **CAMPOS PRINCIPALES CON DATOS REALES - LÍNEAS COMPLETAS JUSTIFICADAS**
        document.add(new Paragraph("Ciudad y Fecha: " + completarCampoCentrado(ciudadFecha, 39) + 
                " Solicitud de Conciliación No. " + completarCampoCentrado(numeroSolicitud, 20))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(2));

        // **TEXTO EXPLICATIVO - EXACTO AL ORIGINAL**
        document.add(new Paragraph("*(Nombres y apellidos completos, número de identificación de cada uno de los solicitantes, apoderados y solicitados. Estos datos")
                .setFont(fontItalic)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));
        document.add(new Paragraph("deben escribirse tal y como aparecen en el documento de identidad)")
                .setFont(fontItalic)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(3));

        // **DATOS DEL CONVOCANTE**
        generarSeccionConvocante(document, solicitud, fontBold, fontRegular);
        
        // **DATOS DEL CONVOCADO** 
        generarSeccionConvocado(document, solicitud, fontBold, fontRegular);
        
        // **PERSONA JURÍDICA**
        generarSeccionPersonaJuridica(document, solicitud, fontBold, fontRegular);
        
        // **APODERADO**
        generarSeccionApoderado(document, solicitud, fontBold, fontRegular);
        
        // **ÁREA DEL CONFLICTO**
        generarSeccionAreaConflicto(document, solicitud, fontBold, fontRegular, fontItalic);
        
        // **HECHOS**
        generarSeccionHechos(document, solicitud, fontBold, fontRegular, fontItalic);
        
        // **FOOTER CON CÓDIGO MPMFO-04**
        generarFooter(document, fontBold, fontRegular, "1 de 2");
    }

    private void generarSeccionConvocante(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular) {
        // **ESPACIADO ULTRA-MÍNIMO - MÁXIMO APROVECHAMIENTO ESPACIO**
        document.add(new Paragraph(" ").setMarginBottom(0.5f)); // MÍNIMO: 1pt
        
        document.add(new Paragraph("DATOS DEL CONVOCANTE: (Información completa y letra legible)")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setFixedLeading(11)
                .setMarginBottom(3));

        // **NOMBRES CON DATOS REALES CENTRADOS**
        document.add(new Paragraph(
                completarCampoCentrado(obtenerValor(solicitud.getConvPrimerNombre()), 24) + " " +
                completarCampoCentrado(obtenerValor(solicitud.getConvSegundoNombre()), 23) + " " +
                completarCampoCentrado(obtenerValor(solicitud.getConvPrimerApellido()), 21) + " " +
                completarCampoCentrado(obtenerValor(solicitud.getConvSegundoApellido()), 28))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(1));
                
        document.add(new Paragraph("Primer Nombre                    Segundo Nombre                 Primer Apellido                 Segundo Apellido")
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
        
        // **DOCUMENTO DE IDENTIDAD CON DATOS REALES**
        String tipoDocumento = obtenerValor(solicitud.getConvTipoDocumento());
        String numeroDocumento = obtenerValor(solicitud.getConvNumeroDocumento());
        document.add(new Paragraph("Documento de identidad: (Debe adjuntarse una copia a esta solicitud): C.C " + 
                ("CC".equals(tipoDocumento) ? " (X) " : "___") + " C.E " + 
                ("CE".equals(tipoDocumento) ? " (X) " : "___") + " Pasaporte " + 
                ("PASAPORTE".equals(tipoDocumento) ? " (X) " : "___") + " No " + 
                completarCampoCentrado(numeroDocumento, 20))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
        
        // **FECHA Y LUGAR DE EXPEDICIÓN CON DATOS REALES**
        String fechaExpedicion = obtenerValor(solicitud.getConvFechaExpedicion());
        String fechaNacimiento = solicitud.getConvFechaNacimiento() != null ? solicitud.getConvFechaNacimiento().toString() : "";
        String edad = solicitud.getConvEdad() != null ? solicitud.getConvEdad().toString() : "";
        document.add(new Paragraph("Fecha y lugar de Expedición: " + completarCampoCentrado(fechaExpedicion, 32) + 
                "Fecha de Nacimiento: " + completarCampoCentrado(fechaNacimiento, 14) + " Edad: " + completarCampoCentrado(edad, 8))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));

        // **CELULAR, WHATSAPP, ESTADO CIVIL CON DATOS REALES**
        document.add(new Paragraph("Celular: " + completarCampoCentrado(obtenerValor(solicitud.getConvCelular()), 28) + 
                " whatsapp: " + completarCampoCentrado(obtenerValor(solicitud.getConvWhatsapp()), 27) + 
                " Estado Civil: " + completarCampoCentrado(obtenerValor(solicitud.getConvEstadoCivil()), 20))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
                
        // **GÉNERO Y SEXO CON DATOS REALES**  
        String genero = obtenerValor(solicitud.getConvGenero());
        String sexo = obtenerValor(solicitud.getConvSexo());
        document.add(new Paragraph("Género: Masculino " + 
                ("MASCULINO".equals(genero.toUpperCase()) ? " (X) " : "___") + " Femenino " + 
                ("FEMENINO".equals(genero.toUpperCase()) ? " (X) " : "___") + " Transgénero " + 
                ("TRANSGENERO".equals(genero.toUpperCase()) ? " (X) " : "___") + " Sexo: Hombre " + 
                ("HOMBRE".equals(sexo.toUpperCase()) ? " (X) " : "___") + " Mujer " + 
                ("MUJER".equals(sexo.toUpperCase()) ? " (X) " : "___") + " Intersexual " + 
                ("INTERSEXUAL".equals(sexo.toUpperCase()) ? " (X) " : "___"))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
                
        // **GRUPO ÉTNICO Y DISCAPACIDAD CON DATOS REALES**
        String grupoEtnico = obtenerValor(solicitud.getConvGrupoEtnico());
        Boolean discapacidad = solicitud.getConvDiscapacidad();
        String cualDiscapacidad = obtenerValor(solicitud.getConvCualDiscapacidad());
        document.add(new Paragraph("¿Grupo étnico? " + completarCampoCentrado(grupoEtnico, 18) + 
                " Discapacidad?: No " + (Boolean.FALSE.equals(discapacidad) ? " (X) " : "___") + 
                " Si " + (Boolean.TRUE.equals(discapacidad) ? " (X) " : "___") + 
                " ¿Cual? " + completarCampoCentrado(cualDiscapacidad, 33))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
                
        // **ESTRATO Y ESCOLARIDAD CON DATOS REALES**
        String estrato = solicitud.getConvEstrato() != null ? solicitud.getConvEstrato().toString() : "";
        document.add(new Paragraph("Estrato: " + completarCampoCentrado(estrato, 8) + 
                " Nivel de escolaridad " + completarCampoCentrado(obtenerValor(solicitud.getConvNivelEscolaridad()), 14) + 
                " Ocupación: " + completarCampoCentrado(obtenerValor(solicitud.getConvOcupacion()), 18) + 
                " País: " + completarCampoCentrado(obtenerValor(solicitud.getConvPais()), 15))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
                
        // **DIRECCIÓN COMPLETA CON DATOS REALES**
        document.add(new Paragraph("Departamento: " + completarCampoCentrado(obtenerValor(solicitud.getConvDepartamento()), 32) + 
                " Ciudad: " + completarCampoCentrado(obtenerValor(solicitud.getConvCiudad()), 20) + 
                " Municipio: " + completarCampoCentrado(obtenerValor(solicitud.getConvMunicipio()), 24))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
                
        document.add(new Paragraph("Dirección: " + completarCampoCentrado(obtenerValor(solicitud.getConvDireccion()), 64) + 
                " Localidad: " + completarCampoCentrado(obtenerValor(solicitud.getConvLocalidad()), 22))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
                
        document.add(new Paragraph("Barrio: " + completarCampoCentrado(obtenerValor(solicitud.getConvBarrio()), 26) + 
                " Correo electrónico " + completarCampoCentrado(obtenerValor(solicitud.getConvCorreo()), 54))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(3));
    }

    private void generarSeccionConvocado(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular) {
        document.add(new Paragraph(" ").setMarginBottom(0.5f));
        
        document.add(new Paragraph("DATOS DEL CONVOCADO: (Información completa y letra legible)")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setFixedLeading(11)
                .setMarginBottom(3));

        // **NOMBRES CON DATOS REALES DEL CONVOCADO**
        document.add(new Paragraph(
                completarCampoCentrado(obtenerValor(solicitud.getConvocadoPrimerNombre()), 24) + " " +
                completarCampoCentrado(obtenerValor(solicitud.getConvocadoSegundoNombre()), 23) + " " +
                completarCampoCentrado(obtenerValor(solicitud.getConvocadoPrimerApellido()), 21) + " " +
                completarCampoCentrado(obtenerValor(solicitud.getConvocadoSegundoApellido()), 28))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(1));
                
        document.add(new Paragraph("Primer Nombre                    Segundo Nombre                 Primer Apellido                 Segundo Apellido")
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
        
        // **DOCUMENTO DE IDENTIDAD CON DATOS REALES DEL CONVOCADO**
        String tipoDocumentoConv = obtenerValor(solicitud.getConvocadoTipoDocumento());
        String numeroDocumentoConv = obtenerValor(solicitud.getConvocadoNumeroDocumento());
        
        // Si no hay tipo de documento especificado, usar C.C. por defecto
        if (tipoDocumentoConv.isEmpty()) {
            tipoDocumentoConv = "CC";
        }
        
        document.add(new Paragraph("Documento de identidad: (Debe adjuntarse una copia a esta solicitud): C.C " + 
                ("CC".equals(tipoDocumentoConv) ? " (X) " : "___") + " C.E " + 
                ("CE".equals(tipoDocumentoConv) ? " (X) " : "___") + " Pasaporte " + 
                ("PASAPORTE".equals(tipoDocumentoConv) ? " (X) " : "___") + " No " + 
                completarCampoCentrado(numeroDocumentoConv, 20))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));

        // **FECHA Y LUGAR DE EXPEDICIÓN CON DATOS REALES DEL CONVOCADO**
        String fechaExpedicionConv = obtenerValor(solicitud.getConvocadoFechaExpedicion());
        String fechaNacimientoConv = solicitud.getConvocadoFechaNacimiento() != null ? solicitud.getConvocadoFechaNacimiento().toString() : "";
        String edadConv = solicitud.getConvocadoEdad() != null ? solicitud.getConvocadoEdad().toString() : "";
        document.add(new Paragraph("Fecha y lugar de Expedición: " + completarCampoCentrado(fechaExpedicionConv, 32) + 
                "Fecha de Nacimiento: " + completarCampoCentrado(fechaNacimientoConv, 14) + " Edad: " + completarCampoCentrado(edadConv, 8))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));

        // **CELULAR, WHATSAPP, ESTADO CIVIL CON DATOS REALES DEL CONVOCADO**
        document.add(new Paragraph("Celular: " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoCelular()), 28) + 
                " whatsapp: " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoWhatsapp()), 27) + 
                " Estado Civil: " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoEstadoCivil()), 20))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));

        // **GÉNERO Y SEXO CON DATOS REALES DEL CONVOCADO**
        String generoConv = obtenerValor(solicitud.getConvocadoGenero());
        String sexoConv = obtenerValor(solicitud.getConvocadoSexo());
        document.add(new Paragraph("Género: Masculino " + 
                ("MASCULINO".equals(generoConv.toUpperCase()) ? " (X) " : "___") + " Femenino " + 
                ("FEMENINO".equals(generoConv.toUpperCase()) ? " (X) " : "___") + " Transgénero " + 
                ("TRANSGENERO".equals(generoConv.toUpperCase()) ? " (X) " : "___") + " Sexo: Hombre " + 
                ("HOMBRE".equals(sexoConv.toUpperCase()) ? " (X) " : "___") + " Mujer " + 
                ("MUJER".equals(sexoConv.toUpperCase()) ? " (X) " : "___") + " Intersexual " + 
                ("INTERSEXUAL".equals(sexoConv.toUpperCase()) ? " (X) " : "___"))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));

        // **GRUPO ÉTNICO Y DISCAPACIDAD CON DATOS REALES DEL CONVOCADO**
        String grupoEtnicoConv = obtenerValor(solicitud.getConvocadoGrupoEtnico());
        Boolean discapacidadConv = solicitud.getConvocadoDiscapacidad();
        String cualDiscapacidadConv = obtenerValor(solicitud.getConvocadoCualDiscapacidad());
        document.add(new Paragraph("¿Grupo étnico? " + completarCampoCentrado(grupoEtnicoConv, 18) + 
                " Discapacidad?: No " + (Boolean.FALSE.equals(discapacidadConv) ? " (X) " : "___") + 
                " Si " + (Boolean.TRUE.equals(discapacidadConv) ? " (X) " : "___") + 
                " ¿Cual? " + completarCampoCentrado(cualDiscapacidadConv, 33))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
                
        // **ESTRATO Y ESCOLARIDAD CON DATOS REALES DEL CONVOCADO**
        String estratoConv = solicitud.getConvocadoEstrato() != null ? solicitud.getConvocadoEstrato().toString() : "";
        document.add(new Paragraph("Estrato: " + completarCampoCentrado(estratoConv, 8) + 
                " Nivel de escolaridad " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoNivelEscolaridad()), 14) + 
                " Ocupación: " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoOcupacion()), 18) + 
                " País: " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoPais()), 15))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
                
        // **DIRECCIÓN COMPLETA CON DATOS REALES DEL CONVOCADO**
        document.add(new Paragraph("Departamento: " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoDepartamento()), 32) + 
                " Ciudad: " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoCiudad()), 20) + 
                " Municipio: " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoMunicipio()), 24))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
                
        document.add(new Paragraph("Dirección: " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoDireccion()), 64) + 
                " Localidad: " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoLocalidad()), 22))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(2));
                
        document.add(new Paragraph("Barrio: " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoBarrio()), 26) + 
                " Correo electrónico " + completarCampoCentrado(obtenerValor(solicitud.getConvocadoCorreo()), 54))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(3));
    }

    private void generarSeccionPersonaJuridica(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular) {
        document.add(new Paragraph(" ").setMarginBottom(3));
        
        document.add(new Paragraph("DATOS DEL CONVOCADO: (PERSONA JURÍDICA)")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setFixedLeading(11)
                .setMarginBottom(1));

        // **EMPRESA CON DATOS REALES**
        document.add(new Paragraph("Nombre de la empresa " + completarCampo(obtenerValor(solicitud.getEmpresaNombre()), 56) + 
                " Nit " + completarCampo(obtenerValor(solicitud.getEmpresaNit()), 21))
                .setFont(fontRegular).setFontSize(7.8f).setFixedLeading(9.5f).setMarginBottom(2));
                
        document.add(new Paragraph("Representante legal " + completarCampo(obtenerValor(solicitud.getEmpresaRepresentante()), 49) + 
                " Teléfono " + completarCampo(obtenerValor(solicitud.getEmpresaTelefono()), 25))
                .setFont(fontRegular).setFontSize(7.8f).setFixedLeading(9.5f).setMarginBottom(2));
                
        document.add(new Paragraph("Dirección: " + completarCampo(obtenerValor(solicitud.getEmpresaDireccion()), 84))
                .setFont(fontRegular).setFontSize(7.8f).setFixedLeading(9.5f).setMarginBottom(2));
                
        document.add(new Paragraph("Correo electrónico " + completarCampo(obtenerValor(solicitud.getEmpresaCorreo()), 67))
                .setFont(fontRegular).setFontSize(7.8f).setFixedLeading(9.5f).setMarginBottom(3));

    }

    private void generarSeccionApoderado(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular) {
        document.add(new Paragraph(" ").setFixedLeading(0.5f).setMarginBottom(0.5f)); // ESPACIADO MÍNIMO
        
        document.add(new Paragraph("SI SE ACTÚA POR APODERADO.")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Nombres y Apellidos: " + completarCampo(obtenerValor(solicitud.getApoderadoNombres()), 60))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));

        document.add(new Paragraph("C.C. " + completarCampo(obtenerValor(solicitud.getApoderadoCc()), 15) +
                " T.P. " + completarCampo(obtenerValor(solicitud.getApoderadoTp()), 12) +
                " Dirección: " + completarCampo(obtenerValor(solicitud.getApoderadoDireccion()), 35))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));

        document.add(new Paragraph("Ciudad: " + completarCampo(obtenerValor(solicitud.getApoderadoCiudad()), 15) +
                " Teléfono " + completarCampo(obtenerValor(solicitud.getApoderadoTelefono()), 15) +
                " Correo electrónico " + completarCampo(obtenerValor(solicitud.getApoderadoCorreo()), 25))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));
    }

    private void generarSeccionAreaConflicto(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular, PdfFont fontItalic) {
        document.add(new Paragraph(" ").setFixedLeading(0.5f).setMarginBottom(0.5f)); // ESPACIADO MÍNIMO
        
        document.add(new Paragraph("Adelanto esta petición, con el fin de llegar a un acuerdo prejudicial, o en su defecto agotar la etapa conciliatoria obligatoria,")
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(1));
        document.add(new Paragraph("conforme lo ordena el Artículo 67 y siguientes de la Ley 2220 de 2022, sobre el siguiente asunto del área de")
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(1));

        document.add(new Paragraph("CIVIL " + (Boolean.TRUE.equals(solicitud.getAreaCivil()) ? " (X) " : "___") +
                " FAMILIA " + (Boolean.TRUE.equals(solicitud.getAreaFamilia()) ? " (X) " : "___") +
                " COMERCIAL " + (Boolean.TRUE.equals(solicitud.getAreaComercial()) ? " (X) " : "___") +
                " PENAL " + (Boolean.TRUE.equals(solicitud.getAreaPenal()) ? " (X) " : "___") +
                " CONVIVENCIA " + (Boolean.TRUE.equals(solicitud.getAreaConvivencia()) ? " (X) " : "___"))
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(1));
    }

    private void generarSeccionHechos(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular, PdfFont fontItalic) {
        document.add(new Paragraph(" ").setFixedLeading(0.5f).setMarginBottom(0.5f)); // ESPACIADO MÍNIMO
        
        document.add(new Paragraph("HECHOS:")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));
        
        document.add(new Paragraph("(En caso de involucrar niños, niñas y adolescentes se debe adjuntar registro civil de nacimiento legible)")
                .setFont(fontItalic)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));
        
        document.add(new Paragraph("*(Los hechos son la narración de la historia del conflicto, qué lo generó, que ha producido, desde cuándo)")
                .setFont(fontItalic)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        // **HECHOS ORGANIZADOS Y LEGIBLES**
        generarHechoFormateado(document, "PRIMERO", solicitud.getHechoPrimero(), fontBold, fontRegular);
        generarHechoFormateado(document, "SEGUNDO", solicitud.getHechoSegundo(), fontBold, fontRegular);
        generarHechoFormateado(document, "TERCERO", solicitud.getHechoTercero(), fontBold, fontRegular);
        generarHechoFormateado(document, "CUARTO", solicitud.getHechoCuarto(), fontBold, fontRegular);
        generarHechoFormateado(document, "QUINTO", solicitud.getHechoQuinto(), fontBold, fontRegular);
    }

    private void generarPagina2(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular, PdfFont fontItalic) throws IOException {
        // **HEADER PÁGINA 2 CON ESCUDO (igual que página 1)**
        generarHeaderConEscudo(document, fontBold, fontRegular, fontItalic, "2 de 2");
        
        // **ESPACIADO ULTRA-MÍNIMO DESPUÉS DEL HEADER**
        document.add(new Paragraph(" ").setFixedLeading(0.5f).setMarginBottom(0.5f));

        // **PRETENSIONES**
        generarSeccionPretensiones(document, solicitud, fontBold, fontRegular, fontItalic);
        
        // **CUANTÍA**
        generarSeccionCuantia(document, solicitud, fontBold, fontRegular, fontItalic);
        
        // **ANEXOS**
        generarSeccionAnexos(document, solicitud, fontBold, fontRegular);
        
        // **MANIFESTACIÓN JURAMENTADA**
        generarSeccionManifestacion(document, fontBold, fontRegular);
        
        // **NOTIFICACIONES**
        generarSeccionNotificaciones(document, solicitud, fontBold, fontRegular);
        
        // **FIRMAS**
        generarSeccionFirmas(document, solicitud, fontBold, fontRegular, fontItalic);
        
        // **FOOTER CON CÓDIGO MPMFO-04**
        generarFooter(document, fontBold, fontRegular, "2 de 2");
    }

    private void generarSeccionPretensiones(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular, PdfFont fontItalic) {
        document.add(new Paragraph("PRETENSIONES:")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setMarginBottom(2));
        
        document.add(new Paragraph("*Las peticiones son la narración de todo aquello que se quiere lograr por medio de la audiencia")
                .setFont(fontItalic)
                .setFontSize(8.3f)
                .setMarginBottom(8));

        // **PRETENSIONES ORGANIZADAS Y LEGIBLES**
        generarPretensionFormateada(document, "PRIMERA", solicitud.getPretensionPrimera(), fontBold, fontRegular);
        generarPretensionFormateada(document, "SEGUNDA", solicitud.getPretensionSegunda(), fontBold, fontRegular);

        generarPretensionFormateada(document, "TERCERA", solicitud.getPretensionTercera(), fontBold, fontRegular);
    }

    private void generarSeccionCuantia(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular, PdfFont fontItalic) {
        document.add(new Paragraph(" ").setFixedLeading(0.5f).setMarginBottom(0.5f)); // ESPACIADO MÍNIMO
        
        document.add(new Paragraph("ESTIMACIÓN RAZONADA DE LA CUANTÍA")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setFixedLeading(7)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(1));
        
        document.add(new Paragraph("*(La cuantía es el monto de dinero total que quiere percibirse llegándose a un acuerdo expresada en pesos)")
                .setFont(fontItalic)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        String cuantia = solicitud.getCuantiaEstimada() != null ? solicitud.getCuantiaEstimada().toString() : "";
        document.add(new Paragraph("CUANTÍA Estimada: $ " + completarCampo(cuantia, 25) +
                "                Indeterminada / sin cuantía: ( " + (Boolean.TRUE.equals(solicitud.getCuantiaIndeterminada()) ? " X " : " ") + " )")
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(11)
                .setMarginBottom(1));

        document.add(new Paragraph("¿Cuánto tiempo hace que inició el conflicto? (Precise en días, meses o años): " + completarCampo(obtenerValor(solicitud.getTiempoConflicto()), 35))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(11)
                .setMarginBottom(1));

        document.add(new Paragraph("Existencia de Acta de Conciliación o acuerdo previo: SI " + (Boolean.TRUE.equals(solicitud.getActaPrevia()) ? " (X) " : "___") +
                " NO " + (Boolean.FALSE.equals(solicitud.getActaPrevia()) ? " (X) " : "___") + " En caso afirmativo anexarla a este escrito")
                .setFont(fontRegular)
                .setFontSize(7.8f)
                .setFixedLeading(8.8f)
                .setMarginBottom(1));
    }

    private void generarSeccionAnexos(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular) {
        document.add(new Paragraph(" ").setFixedLeading(0.5f).setMarginBottom(0.5f)); // ESPACIADO MÍNIMO
        
        document.add(new Paragraph("ANEXOS:")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Copia Serv. /Pco " + (Boolean.TRUE.equals(solicitud.getAnexoCopiaServ()) ? " (X) " : "___") +
                " C.C. Convocante " + (Boolean.TRUE.equals(solicitud.getAnexoCcConvocante()) ? " (X) " : "___") +
                " R/Civil " + (Boolean.TRUE.equals(solicitud.getAnexoRcivil()) ? " (X) " : "___") +
                " Contrato " + (Boolean.TRUE.equals(solicitud.getAnexoContrato()) ? " (X) " : "___") +
                " Cert/Represt. " + (Boolean.TRUE.equals(solicitud.getAnexoCertReprest()) ? " (X) " : "___"))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));

        document.add(new Paragraph("Título. /Vr " + (Boolean.TRUE.equals(solicitud.getAnexoTituloVr()) ? " (X) " : "___") +
                " Sentencia " + (Boolean.TRUE.equals(solicitud.getAnexoSentencia()) ? " (X) " : "___") +
                " Otros: " + completarCampo(obtenerValor(solicitud.getAnexoOtros()), 50))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));
    }

    private void generarSeccionManifestacion(Document document, PdfFont fontBold, PdfFont fontRegular) {
        document.add(new Paragraph(" ").setFixedLeading(0.5f).setMarginBottom(0.5f)); // ESPACIADO MÍNIMO
        
        document.add(new Paragraph("MANIFESTACIÓN JURAMENTADA")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setFixedLeading(7)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(1));

        document.add(new Paragraph("Manifiesto bajo gravedad de juramento que no cursa solicitud de conciliación frente a conciliador diferente, que no existe acta de")
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));
        document.add(new Paragraph("conciliación judicial o extrajudicial en derecho, que no concurre pleito pendiente frente a otra autoridad y que no existe sentencia")
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));
        document.add(new Paragraph("judicial respecto de los mismos hechos, partes y circunstancias.")
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));
    }

    private void generarSeccionNotificaciones(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular) {
        document.add(new Paragraph(" ").setFixedLeading(0.5f).setMarginBottom(0.5f)); // ESPACIADO MÍNIMO
        
        document.add(new Paragraph("NOTIFICACIONES")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setFixedLeading(7)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(1));

        // SOLICITANTE(S) - ULTRA COMPACTO
        document.add(new Paragraph("SOLICITANTE(S)")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));

        document.add(new Paragraph("Nombres completos: " + completarCampo(obtenerValor(solicitud.getNotifSolicitanteNombres()), 80))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Dirección: " + completarCampo(obtenerValor(solicitud.getNotifSolicitanteDireccion()), 85))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Ciudad: " + completarCampo(obtenerValor(solicitud.getNotifSolicitanteCiudad()), 40))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Teléfonos: " + completarCampo(obtenerValor(solicitud.getNotifSolicitanteTelefonos()), 70))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Celulares: " + completarCampo(obtenerValor(solicitud.getNotifSolicitanteCelulares()), 70))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Correo Electrónico: " + completarCampo(obtenerValor(solicitud.getNotifSolicitanteCorreo()), 65))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        // APODERADO SOLICITANTE(S) - ULTRA COMPACTO
        document.add(new Paragraph("APODERADO SOLICITANTE(S)")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));

        document.add(new Paragraph("Nombres completos: " + completarCampo(obtenerValor(solicitud.getNotifApoderadoNombres()), 80))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Domicilio profesional: " + completarCampo(obtenerValor(solicitud.getNotifApoderadoDomicilio()), 65) +
                " Ciudad: " + completarCampo(obtenerValor(solicitud.getNotifApoderadoCiudad()), 15))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Documentos de identidad: (Debe adjuntarse una copia a esta solicitud): C.C" + completarCampo(obtenerValor(solicitud.getNotifApoderadoCc()), 15) +
                "T. P: " + completarCampo(obtenerValor(solicitud.getNotifApoderadoTp()), 20))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Teléfonos: " + completarCampo(obtenerValor(solicitud.getNotifApoderadoTelefonos()), 70))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Celulares: " + completarCampo(obtenerValor(solicitud.getNotifApoderadoCelulares()), 70))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Correo Electrónico: " + completarCampo(obtenerValor(solicitud.getNotifApoderadoCorreo()), 65))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        // SOLICITADOS - ULTRA COMPACTO
        document.add(new Paragraph("SOLICITADOS")
                .setFont(fontBold)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));

        document.add(new Paragraph("Nombres completos: " + completarCampo(obtenerValor(solicitud.getNotifSolicitadosNombres()), 80))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Dirección: " + completarCampo(obtenerValor(solicitud.getNotifSolicitadosDireccion()), 85))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Ciudad: " + completarCampo(obtenerValor(solicitud.getNotifSolicitadosCiudad()), 40))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Teléfonos: " + completarCampo(obtenerValor(solicitud.getNotifSolicitadosTelefonos()), 70))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Celulares: " + completarCampo(obtenerValor(solicitud.getNotifSolicitadosCelulares()), 70))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Correo Electrónico: " + completarCampo(obtenerValor(solicitud.getNotifSolicitadosCorreo()), 65))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));
    }

    private void generarSeccionFirmas(Document document, Solicitud solicitud, PdfFont fontBold, PdfFont fontRegular, PdfFont fontItalic) {
        document.add(new Paragraph(" ").setFixedLeading(0.5f).setMarginBottom(0.5f)); // ESPACIADO MÍNIMO
        
        document.add(new Paragraph("Declaro bajo juramento que se entiende prestado con la firma de la presente solicitud que: los hechos en que sustento mi")
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));
        document.add(new Paragraph("petición, los documentos que aporto son ciertos y veraces, la dirección que específico del solicitado es la única que conozco y")
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));
        document.add(new Paragraph("que mis actuaciones están enmarcadas dentro del principio de la buena fe.")
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));

        document.add(new Paragraph("Autorización Del Tratamiento De Sus Datos Personales: Autorizo la recolección, consulta, almacenamiento, uso, traslado o")
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));
        document.add(new Paragraph("eliminación de sus datos personales, con el fin de adelantar las gestiones, actuaciones e intervenciones conforme la política de")
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));
        document.add(new Paragraph("tratamiento de datos.")
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));

        // **FIRMAS - ULTRA COMPACTO**
        document.add(new Paragraph("________________________________________                __________________________________")
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));

        document.add(new Paragraph("Solicitante (firma)                                         Asesor (Nombre y celular)")
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));

        document.add(new Paragraph("C.C. No. " + completarCampo(obtenerValor(solicitud.getSolicitanteCc()), 20))
                .setFont(fontRegular)
                .setFontSize(8.3f)
                .setFixedLeading(9.3f)
                .setMarginBottom(1));

        document.add(new Paragraph("*(Firma quien encabezó esta solicitud, si es abogado o representante debe adjuntar poder original")
                .setFont(fontItalic)
                .setFontSize(8.3f)
                .setFixedLeading(9)
                .setMarginBottom(1));
        document.add(new Paragraph("debidamente otorgado)")
                .setFont(fontItalic)
                .setFontSize(8.3f)
                .setFixedLeading(5));
    }

    private String obtenerValor(String valor) {
        return valor != null && !valor.trim().isEmpty() ? valor.trim() : "";
    }

    private void generarHechoFormateado(Document document, String numero, String contenido, PdfFont fontBold, PdfFont fontRegular) {
        String textoHecho = obtenerValor(contenido);
        
        // SIEMPRE mostrar el campo, con contenido o con líneas vacías según CLAUDE.md
        if (!textoHecho.isEmpty()) {
            // Limitar texto a máximo 100 caracteres
            if (textoHecho.length() > 100) {
                textoHecho = textoHecho.substring(0, 100) + "...";
            }
            
            // Mostrar solo el texto SIN líneas cuando hay contenido
            document.add(new Paragraph(numero + ": " + textoHecho)
                    .setFont(fontRegular)
                    .setFontSize(7.5f)
                    .setFixedLeading(8.0f)
                    .setMarginBottom(1.5f)
                    .setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT));
        } else {
            // Si no hay contenido, mostrar UNA SOLA línea que desaparezca cuando se llene
            document.add(new Paragraph(numero + ": " + "_".repeat(75))
                    .setFont(fontRegular)
                    .setFontSize(7.5f)
                    .setFixedLeading(8.0f)
                    .setMarginBottom(1.5f));
        }
    }

    private void generarPretensionFormateada(Document document, String numero, String contenido, PdfFont fontBold, PdfFont fontRegular) {
        String textoPretension = obtenerValor(contenido);
        
        // SIEMPRE mostrar el campo, con contenido o con líneas vacías según CLAUDE.md
        if (!textoPretension.isEmpty()) {
            // Limitar texto a máximo 100 caracteres para pretensiones
            if (textoPretension.length() > 100) {
                textoPretension = textoPretension.substring(0, 100) + "...";
            }
            
            // Mostrar solo el texto SIN líneas cuando hay contenido
            document.add(new Paragraph(numero + ": " + textoPretension)
                    .setFont(fontRegular)
                    .setFontSize(7.5f)
                    .setFixedLeading(8.0f)
                    .setMarginBottom(1.5f)
                    .setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT));
        } else {
            // Si no hay contenido, mostrar UNA SOLA línea que desaparezca cuando se llene
            document.add(new Paragraph(numero + ": " + "_".repeat(75))
                    .setFont(fontRegular)
                    .setFontSize(7.5f)
                    .setFixedLeading(8.0f)
                    .setMarginBottom(1.5f));
        }
    }

    private String completarCampo(String valor, int longitudMaxima) {
        if (valor == null || valor.trim().isEmpty()) {
            return "_".repeat(longitudMaxima);
        }
        String valorTrim = valor.trim();
        if (valorTrim.length() >= longitudMaxima) {
            return valorTrim.substring(0, longitudMaxima);
        }
        return valorTrim + "_".repeat(longitudMaxima - valorTrim.length());
    }

    private String completarCampoCentrado(String valor, int longitudMaxima) {
        if (valor == null || valor.trim().isEmpty()) {
            return "_".repeat(longitudMaxima);
        }
        String valorTrim = valor.trim();
        if (valorTrim.length() >= longitudMaxima) {
            return valorTrim.substring(0, longitudMaxima);
        }
        
        // Calcular espacios para centrar
        int espaciosTotal = longitudMaxima - valorTrim.length();
        int espaciosIzquierda = espaciosTotal / 2;
        int espaciosDerecha = espaciosTotal - espaciosIzquierda;
        
        return "_".repeat(espaciosIzquierda) + valorTrim + "_".repeat(espaciosDerecha);
    }
    
    /**
     * Genera el header exacto al PDF original con escudo centrado
     */
    private void generarHeaderConEscudo(Document document, PdfFont fontBold, PdfFont fontRegular, PdfFont fontItalic, String numeroPagina) throws IOException {
        // **TABLA PARA LAYOUT EXACTO**
        Table headerTable = new Table(UnitValue.createPercentArray(new float[]{15, 70, 15}));
        headerTable.setWidth(UnitValue.createPercentValue(100));
        
        // **COLUMNA IZQUIERDA: "Servicio Gratuito" COMPACTO**
        Cell leftCell = new Cell();
        leftCell.add(new Paragraph("Servicio Gratuito")
                .setFont(fontBold)
                .setFontSize(8.3f) // Maximizado: 10pt
                .setFixedLeading(9.3f)
                .setMarginBottom(2)
                .setTextAlignment(TextAlignment.LEFT));
        leftCell.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        headerTable.addCell(leftCell);
        
        // **COLUMNA CENTRAL: ESCUDO + TEXTO INSTITUCIONAL**
        Cell centerCell = new Cell();
        centerCell.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        
        try {
            // **ESCUDO ALARGADO Y LUEGO REDUCIDO PARA NO VERSE APLASTADO**
            ClassPathResource escudoResource = new ClassPathResource("static/escudo.png");
            Image escudo = new Image(ImageDataFactory.create(escudoResource.getInputStream().readAllBytes()));
            // Primero alargarlo para corregir proporción, luego reducir tamaño
            escudo.setWidth(30);  // Reducido de 45 a 35
            escudo.setHeight(35); // Altura mayor para alargar (40 vs 35 width)
            escudo.setHorizontalAlignment(com.itextpdf.layout.properties.HorizontalAlignment.CENTER);
            centerCell.add(escudo);
        } catch (Exception e) {
            // Si no se puede cargar el escudo, continuar sin él
            System.err.println("No se pudo cargar el escudo: " + e.getMessage());
        }
        
        // **TEXTO INSTITUCIONAL - ULTRA COMPACTO**
        centerCell.add(new Paragraph("UNIVERSIDAD COLEGIO MAYOR DE CUNDINAMARCA")
                .setFont(fontBold)
                .setFontSize(8.3f) // Reducido para compactar: 10pt
                .setFixedLeading(9.3f)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(1));
                
        centerCell.add(new Paragraph("CENTRO DE CONCILIACIÓN")
                .setFont(fontBold)
                .setFontSize(8.3f) // Reducido para compactar: 9pt
                .setFixedLeading(9)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(1));
                
        centerCell.add(new Paragraph("(Aprobado Resolución No. 2099 de diciembre 12 de 2003 Ministerio del Interior y de Justicia – Código 05 110012180)")
                .setFont(fontItalic)
                .setFontSize(8.3f) // Maximizado: 8pt
                .setFixedLeading(8)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(1));
                
        centerCell.add(new Paragraph("Diagonal 34 No. 5-71 Teléfono 2457169 Bogotá, D.C. – conciliacion@universidadmayor.edu.co")
                .setFont(fontRegular)
                .setFontSize(8.3f) // Maximizado: 8pt
                .setFixedLeading(8)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(4));
        headerTable.addCell(centerCell);
        
        // **COLUMNA DERECHA: VACÍA (MPMFO-04 SE MOVERÁ AL FOOTER)**
        Cell rightCell = new Cell();
        rightCell.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        headerTable.addCell(rightCell);
        
        document.add(headerTable);
        
        // **TÍTULO PRINCIPAL - MAXIMIZADO PARA LLENAR COMPLETAMENTE**
        document.add(new Paragraph("SOLICITUD DE CONCILIACION")
                .setFont(fontBold)
                .setFontSize(8.3f) // Reducido para compactar: 11pt
                .setFixedLeading(9)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(2));
                
    }
    
    /**
     * Genera footer con código MPMFO-04 en tres líneas en esquina inferior derecha
     */
    private void generarFooter(Document document, PdfFont fontBold, PdfFont fontRegular, String numeroPagina) {
        // **LAYOUT HORIZONTAL: FRASE IZQUIERDA - LOGOS EXTREMA DERECHA - CÓDIGO DERECHA**
        Table footerTable = new Table(UnitValue.createPercentArray(new float[]{45, 35, 20}));
        footerTable.setWidth(UnitValue.createPercentValue(100));
        footerTable.setMarginTop(0); // Sin margen para evitar tercera página
        
        // **FRASE VIGILADO - 45% IZQUIERDA EXACTA COMO LA IMAGEN**
        Cell fraseCell = new Cell();
        fraseCell.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        fraseCell.setVerticalAlignment(com.itextpdf.layout.properties.VerticalAlignment.BOTTOM);
        fraseCell.setPadding(0);
        fraseCell.setMargin(0);
        
        // **DISEÑO EXACTO REPLICANDO izquierda.png**
        
        // Crear tabla para posicionamiento exacto
        Table vigiladoEstructura = new Table(UnitValue.createPercentArray(new float[]{100}));
        vigiladoEstructura.setWidth(UnitValue.createPercentValue(100));
        
        // Línea superior ARRIBA de "VIGILADO" - con separación
        Cell lineaSuperior = new Cell();
        lineaSuperior.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        lineaSuperior.setPadding(0);
        lineaSuperior.add(new Paragraph("________")
                .setFont(fontBold)
                .setFontSize(12f)
                .setFixedLeading(8f)
                .setTextAlignment(TextAlignment.LEFT)
                .setMarginBottom(2f));
        vigiladoEstructura.addCell(lineaSuperior);
        
        // VIGILADO y Ministerio en UNA SOLA LÍNEA - con separación arriba y menos abajo
        Cell textoCompleto = new Cell();
        textoCompleto.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        textoCompleto.setPadding(0);
        textoCompleto.add(new Paragraph("VIGILADO Ministerio de Justicia y del Derecho")
                .setFont(fontBold)
                .setFontSize(8f)
                .setFixedLeading(10f)
                .setTextAlignment(TextAlignment.LEFT)
                .setMarginBottom(0.5f));
        vigiladoEstructura.addCell(textoCompleto);
        
        // Línea inferior usando tabla interna para posicionamiento bajo "VIGILADO"
        Cell lineaInferior = new Cell();
        lineaInferior.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        lineaInferior.setPadding(0);
        
        // Tabla interna con dos columnas: espacio para "VIGILADO" y espacio restante
        Table posicionLinea = new Table(UnitValue.createPercentArray(new float[]{25, 75}));
        posicionLinea.setWidth(UnitValue.createPercentValue(100));
        
        // Primera columna: línea debajo de "VIGILADO"
        Cell lineaCell = new Cell();
        lineaCell.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        lineaCell.setPadding(0);
        lineaCell.add(new Paragraph("________")
                .setFont(fontBold)
                .setFontSize(12f)
                .setFixedLeading(8f)
                .setTextAlignment(TextAlignment.LEFT)
                .setMarginBottom(0));
        posicionLinea.addCell(lineaCell);
        
        // Segunda columna: espacio vacío
        Cell espacioVacio = new Cell();
        espacioVacio.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        espacioVacio.setPadding(0);
        espacioVacio.add(new Paragraph(""));
        posicionLinea.addCell(espacioVacio);
        
        lineaInferior.add(posicionLinea);
        vigiladoEstructura.addCell(lineaInferior);
        
        fraseCell.add(vigiladoEstructura);
        
        footerTable.addCell(fraseCell);
        
        // **LOGOS MÁXIMOS - OCUPANDO 35% EXTREMA DERECHA**
        Cell logosCell = new Cell();
        logosCell.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        logosCell.setPadding(0);
        logosCell.setMargin(0);
        
        // Crear tabla para unir los dos logos - TOTALMENTE A LA DERECHA
        Table logosTable = new Table(UnitValue.createPercentArray(new float[]{50, 50}));
        logosTable.setWidth(UnitValue.createPercentValue(100)); // Usar todo el espacio para máximo desplazamiento
        logosTable.setHorizontalAlignment(com.itextpdf.layout.properties.HorizontalAlignment.RIGHT);
        
        // **LOGO 1 - MÁXIMO TAMAÑO POSIBLE**
        Cell logo1Cell = new Cell();
        logo1Cell.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        logo1Cell.setPadding(0);
        logo1Cell.setMargin(0);
        try {
            ClassPathResource logo1Resource = new ClassPathResource("static/logo1.png");
            Image logo1 = new Image(ImageDataFactory.create(logo1Resource.getInputStream().readAllBytes()));
            logo1.setWidth(100); // Más reducido para evitar tercera página
            logo1.setHeight(65); // Más reducido proporcionalmente
            logo1.setHorizontalAlignment(com.itextpdf.layout.properties.HorizontalAlignment.RIGHT);
            logo1Cell.add(logo1);
        } catch (Exception e) {
            System.err.println("No se pudo cargar logo1.png: " + e.getMessage());
        }
        logosTable.addCell(logo1Cell);
        
        // **LOGO 2 - MÁXIMO TAMAÑO CON PROPORCIÓN CORREGIDA**
        Cell logo2Cell = new Cell();
        logo2Cell.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        logo2Cell.setPadding(0);
        logo2Cell.setMargin(0);
        try {
            ClassPathResource logo2Resource = new ClassPathResource("static/logo2.png");
            Image logo2 = new Image(ImageDataFactory.create(logo2Resource.getInputStream().readAllBytes()));
            // Proporción ajustada para evitar tercera página
            logo2.setWidth(85); // Más reducido para evitar tercera página
            logo2.setHeight(65); // Más reducido para uniformidad con logo1
            logo2.setHorizontalAlignment(com.itextpdf.layout.properties.HorizontalAlignment.LEFT);
            logo2Cell.add(logo2);
        } catch (Exception e) {
            System.err.println("No se pudo cargar logo2.png: " + e.getMessage());
        }
        logosTable.addCell(logo2Cell);
        
        logosCell.add(logosTable);
        footerTable.addCell(logosCell);
        
        // **CÓDIGO MPMFO-04 COMPACTO - 20% DERECHO**
        Cell codigoCell = new Cell();
        codigoCell.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
        codigoCell.setVerticalAlignment(com.itextpdf.layout.properties.VerticalAlignment.BOTTOM);
        codigoCell.add(new Paragraph("MPMFO-04")
                .setFont(fontBold)
                .setFontSize(7f) // Ultra-compacto para maximizar logos
                .setFixedLeading(6.5f)
                .setTextAlignment(TextAlignment.RIGHT)
                .setMarginBottom(0));
        codigoCell.add(new Paragraph("Versión 2")
                .setFont(fontBold)
                .setFontSize(7f)
                .setFixedLeading(6.5f)
                .setTextAlignment(TextAlignment.RIGHT)
                .setMarginBottom(0));
        codigoCell.add(new Paragraph("Página " + numeroPagina)
                .setFont(fontBold)
                .setFontSize(7f)
                .setFixedLeading(6.5f)
                .setTextAlignment(TextAlignment.RIGHT)
                .setMarginBottom(0));
        footerTable.addCell(codigoCell);
        
        document.add(footerTable);
    }
}