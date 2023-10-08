package apiserviciotransporte.apiserviciotransporte.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "solicitudadicionales")
public class SolicitudParadas {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idsolicitud", referencedColumnName = "id")
    private SolicitudServicio solicitud;

    @Id
    @Column(name = "direccion", length = 100)
    private String direccion;

}
