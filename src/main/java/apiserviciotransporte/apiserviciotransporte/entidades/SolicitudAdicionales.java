package apiserviciotransporte.apiserviciotransporte.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "solicitudadicionales")
public class SolicitudAdicionales {

    @Id
    @ManyToOne
    @JoinColumn(name = "idsolicitud", referencedColumnName = "id")
    private SolicitudServicio solicitud;

    @Id
    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    private TipoAdicional tipo;

    @Column(name = "cantidad")
    private int cantidad;

    public SolicitudAdicionales() {
    }

    public SolicitudAdicionales(SolicitudServicio solicitud, TipoAdicional tipo, int cantidad) {
        this.solicitud = solicitud;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public TipoAdicional getTipo() {
        return tipo;
    }

    public void setTipo(TipoAdicional tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
