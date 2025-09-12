package co.edu.universidadmayor.conciliacion.repository;

import co.edu.universidadmayor.conciliacion.model.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    
    // Buscar por número de solicitud
    Optional<Solicitud> findByNumeroSolicitud(String numeroSolicitud);
    
    // Buscar por documento del convocante
    List<Solicitud> findByConvNumeroDocumento(String numeroDocumento);
    
    // Buscar por fecha de creación
    List<Solicitud> findByFechaCreacionBetween(LocalDateTime inicio, LocalDateTime fin);
    
    // Buscar solicitudes con PDF generado
    List<Solicitud> findByPdfGeneradoTrue();
    
    // Contar solicitudes por fecha
    @Query("SELECT COUNT(s) FROM Solicitud s WHERE FUNCTION('DATE', s.fechaCreacion) = CURRENT_DATE")
    Long contarSolicitudesHoy();
    
    // Obtener últimas solicitudes
    List<Solicitud> findTop10ByOrderByFechaCreacionDesc();
}