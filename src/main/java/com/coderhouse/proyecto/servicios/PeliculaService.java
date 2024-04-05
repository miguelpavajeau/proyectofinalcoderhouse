package com.coderhouse.proyecto.servicios;


import com.coderhouse.proyecto.entidades.Pelicula;
import com.coderhouse.proyecto.repositorios.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    public Pelicula mostrarPeliculaPorId(Integer id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    public Pelicula agregarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public Pelicula editarPeliculaPorId(Integer id, Pelicula pelicula) {
        try {
            if (peliculaRepository.existsById(id)) {
                pelicula.setId(id);
                return peliculaRepository.save(pelicula);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public boolean eliminarPeliculaPorId(Integer id) {
        try {
            peliculaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}