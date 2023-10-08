package apiserviciotransporte.apiserviciotransporte.entidades;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "solicitudservicio")
public class SolicitudServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_tiposervicio")
    @GenericGenerator(name = "secuencia_tiposervicio", strategy = "increment")
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "cantidadpasajeros")
    private int cantidadPasajeros;

    @Column(name = "inmediato")
    private boolean inmediato;

    @Column(name = "horaprogramada")
    private LocalTime horaProgramada;

    @OneToMany(mappedBy = "solicitudservicio")
    private List<SolicitudAdicionales> adicionales = new ArrayList<>();

    @OneToMany(mappedBy = "solicitudservicio")
    private List<SolicitudParadas> paradas = new ArrayList<>();

    public SolicitudServicio() {
    }

    public SolicitudServicio(long id, Usuario usuario, Date fecha, int cantidadPasajeros, boolean inmediato,
            LocalTime horaProgramada, List<SolicitudAdicionales> adicionales, List<SolicitudParadas> paradas) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.cantidadPasajeros = cantidadPasajeros;
        this.inmediato = inmediato;
        this.horaProgramada = horaProgramada;
        this.adicionales = adicionales;
        this.paradas = paradas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public boolean isInmediato() {
        return inmediato;
    }

    public void setInmediato(boolean inmediato) {
        this.inmediato = inmediato;
    }

    public LocalTime getHoraProgramada() {
        return horaProgramada;
    }

    public void setHoraProgramada(LocalTime horaProgramada) {
        this.horaProgramada = horaProgramada;
    }

    public List<SolicitudAdicionales> getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(List<SolicitudAdicionales> adicionales) {
        this.adicionales = adicionales;
    }

    public List<SolicitudParadas> getParadas() {
        return paradas;
    }

    public void setParadas(List<SolicitudParadas> paradas) {
        this.paradas = paradas;
    }

}
