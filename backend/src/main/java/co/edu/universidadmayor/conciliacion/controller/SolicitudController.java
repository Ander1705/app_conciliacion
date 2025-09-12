package co.edu.universidadmayor.conciliacion.controller;

import co.edu.universidadmayor.conciliacion.model.dto.SolicitudDTO;
import co.edu.universidadmayor.conciliacion.model.entity.Solicitud;
import co.edu.universidadmayor.conciliacion.service.SolicitudService;
import co.edu.universidadmayor.conciliacion.service.PdfGeneratorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping("/solicitudes")
@CrossOrigin(origins = "*")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private PdfGeneratorService pdfGeneratorService;

    @PostMapping
    public ResponseEntity<?> crearSolicitud(@Valid @RequestBody SolicitudDTO solicitudDTO, HttpServletRequest request) {
        try {
            // Obtener IP del cliente
            String clientIp = obtenerIpCliente(request);
            
            Solicitud solicitud = solicitudService.crearSolicitud(solicitudDTO, clientIp);
            return ResponseEntity.ok().body(Map.of(
                "success", true,
                "message", "Solicitud creada exitosamente",
                "data", solicitud
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                "success", false,
                "message", "Error al crear solicitud: " + e.getMessage()
            ));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerSolicitud(@PathVariable Long id) {
        try {
            Solicitud solicitud = solicitudService.obtenerPorId(id);
            return ResponseEntity.ok().body(Map.of(
                "success", true,
                "data", solicitud
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                "success", false,
                "message", "Error al obtener solicitud: " + e.getMessage()
            ));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarSolicitud(@PathVariable Long id, @Valid @RequestBody SolicitudDTO solicitudDTO) {
        try {
            Solicitud solicitud = solicitudService.actualizarSolicitud(id, solicitudDTO);
            return ResponseEntity.ok().body(Map.of(
                "success", true,
                "message", "Solicitud actualizada exitosamente",
                "data", solicitud
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                "success", false,
                "message", "Error al actualizar solicitud: " + e.getMessage()
            ));
        }
    }

    @PostMapping("/generar-pdf")
    public ResponseEntity<?> generarPDF(@Valid @RequestBody SolicitudDTO solicitudDTO, HttpServletRequest request) {
        try {
            // Obtener IP del cliente
            String clientIp = obtenerIpCliente(request);
            
            // Crear y guardar la solicitud
            Solicitud solicitud = solicitudService.crearSolicitud(solicitudDTO, clientIp);
            
            // Generar el PDF
            byte[] pdfBytes = pdfGeneratorService.generarPDF(solicitud);
            
            // Actualizar la solicitud con la información del PDF
            solicitudService.marcarPdfGenerado(solicitud.getId());
            
            // Crear nombre del archivo
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String filename = String.format("Solicitud_Conciliacion_%s_%s.pdf", 
                                            solicitud.getNumeroSolicitud(), 
                                            timestamp);
            
            // Preparar respuesta
            ByteArrayResource resource = new ByteArrayResource(pdfBytes);
            
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .contentType(MediaType.APPLICATION_PDF)
                    .contentLength(pdfBytes.length)
                    .body(resource);
                    
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                "success", false,
                "message", "Error al generar PDF: " + e.getMessage()
            ));
        }
    }

    @PostMapping("/{id}/pdf")
    public ResponseEntity<?> generarPDFExistente(@PathVariable Long id) {
        try {
            Solicitud solicitud = solicitudService.obtenerPorId(id);
            byte[] pdfBytes = pdfGeneratorService.generarPDF(solicitud);
            
            // Actualizar la solicitud
            solicitudService.marcarPdfGenerado(id);
            
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String filename = String.format("Solicitud_Conciliacion_%s_%s.pdf", 
                                            solicitud.getNumeroSolicitud(), 
                                            timestamp);
            
            ByteArrayResource resource = new ByteArrayResource(pdfBytes);
            
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .contentType(MediaType.APPLICATION_PDF)
                    .contentLength(pdfBytes.length)
                    .body(resource);
                    
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                "success", false,
                "message", "Error al generar PDF: " + e.getMessage()
            ));
        }
    }

    private String obtenerIpCliente(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}