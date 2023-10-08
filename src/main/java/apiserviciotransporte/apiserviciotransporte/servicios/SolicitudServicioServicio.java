package apiserviciotransporte.apiserviciotransporte.servicios;

import java.util.Date;
import java.util.List;

import apiserviciotransporte.apiserviciotransporte.entidades.SolicitudAdicionales;
import apiserviciotransporte.apiserviciotransporte.entidades.SolicitudParadas;
import apiserviciotransporte.apiserviciotransporte.entidades.SolicitudServicio;
import apiserviciotransporte.apiserviciotransporte.interfaces.ISolicitudServicioServicio;
import apiserviciotransporte.apiserviciotransporte.repositorios.SolicitudServicioRepositorio;
import jakarta.persistence.EntityNotFoundException;

public class SolicitudServicioServicio implements ISolicitudServicioServicio {

    private SolicitudServicioRepositorio repositorio;

    public SolicitudServicioServicio(SolicitudServicioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<SolicitudServicio> listar() {
        return repositorio.findAll();
    }

    @Override
    public SolicitudServicio obtener(Long id) {
        var solicitudServicio = repositorio.findById(id);
        return solicitudServicio.isEmpty() ? null : solicitudServicio.get();
    }

    @Override
    public List<SolicitudServicio> buscarPorFecha(Date fecha) {
        return repositorio.buscarPorFecha(fecha);
    }

    @Override
    public List<SolicitudServicio> buscarPorUsuario(String usuario) {
        return repositorio.buscarPorUsuario(usuario);
    }

    @Override
    public SolicitudServicio guardar(SolicitudServicio solicitudServicio) {
        return repositorio.save(solicitudServicio);
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /***** Adicionales *****/

    @Override
    public List<SolicitudAdicionales> listarAdicionales(Long id) {
        // Buscar la solicitud por su ID
        var solicitudServicioBuscada = repositorio.findById(id);

        if (solicitudServicioBuscada.isPresent()) {
            var solicitudServicio = solicitudServicioBuscada.get();

            return solicitudServicio.getAdicionales();
        }
        return null;
    }

    public void agregarAdicional(Long id, SolicitudAdicionales solicitudAdicionales) {
        // Buscar la solicitud por su ID
        var solicitudServicioBuscada = repositorio.findById(id);

        if (solicitudServicioBuscada.isPresent()) {
            var solicitudServicio = solicitudServicioBuscada.get();

            // Agregar el adicional a la lista de adicionales de la solicitud
            solicitudServicio.getAdicionales().add(solicitudAdicionales);

            // Actualizar el autor en la base de datos
            repositorio.save(solicitudServicio);
        } else {
            // Manejar el caso en que no se encuentra la solicitud
            throw new EntityNotFoundException("No se encontró la Solicitud de Servicio con ID: " + id);
        }
    }

    /***** Paradas *****/

    @Override
    public List<SolicitudParadas> listarParadas(Long id) {
        // Buscar la solicitud por su ID
        var solicitudServicioBuscada = repositorio.findById(id);

        if (solicitudServicioBuscada.isPresent()) {
            var solicitudServicio = solicitudServicioBuscada.get();

            return solicitudServicio.getParadas();
        }
        return null;
    }

    public void agregarParada(Long id, SolicitudParadas solicitudParadas) {
        // Buscar la solicitud por su ID
        var solicitudServicioBuscada = repositorio.findById(id);

        if (solicitudServicioBuscada.isPresent()) {
            var solicitudServicio = solicitudServicioBuscada.get();

            // Agregar el adicional a la lista de adicionales de la solicitud
            solicitudServicio.getParadas().add(solicitudParadas);

            // Actualizar el autor en la base de datos
            repositorio.save(solicitudServicio);
        } else {
            // Manejar el caso en que no se encuentra la solicitud
            throw new EntityNotFoundException("No se encontró la Solicitud de Servicio con ID: " + id);
        }
    }

}
