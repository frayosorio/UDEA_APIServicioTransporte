package apiserviciotransporte.apiserviciotransporte.interfaces;

import java.util.Date;
import java.util.List;

import apiserviciotransporte.apiserviciotransporte.entidades.SolicitudAdicionales;
import apiserviciotransporte.apiserviciotransporte.entidades.SolicitudParadas;
import apiserviciotransporte.apiserviciotransporte.entidades.SolicitudServicio;

public interface ISolicitudServicioServicio {

    public List<SolicitudServicio> listar();

    public SolicitudServicio obtener(Long id);

    List<SolicitudServicio> buscarPorFecha(Date fecha);

    List<SolicitudServicio> buscarPorUsuario(String usuario);

    public SolicitudServicio guardar(SolicitudServicio pais);

    public boolean eliminar(Long id);

    public List<SolicitudAdicionales> listarAdicionales(Long id);

    public void agregarAdicional(Long id, SolicitudAdicionales solicitudAdicionales);

    public List<SolicitudParadas> listarParadas(Long id);

    public void agregarParada(Long id, SolicitudParadas solicitudParadas);

}
