package com.coderhouse.proyecto.controladores;

import com.coderhouse.proyecto.entidades.Pelicula;
import com.coderhouse.proyecto.servicios.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private PeliculaService peliculaService;

    //Listar peliculas
    @GetMapping(value = "/")
    public ResponseEntity<List<Pelicula>> listarPeliculas() {
        try {
            List<Pelicula> peliculas = peliculaService.listarPeliculas();
            return new ResponseEntity<>(peliculas, HttpStatus.OK); // Codigo 200
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
        }
    }

    //Mostrar pelicula por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pelicula> mostrarPeliculaPorId(Integer id) {
        try {
            Pelicula pelicula = peliculaService.mostrarPeliculaPorId(id);
            if (pelicula != null) {
                return new ResponseEntity<>(pelicula, HttpStatus.OK); // Codigo 200
            } else {
                return new ResponseEntity<>(pelicula, HttpStatus.NOT_FOUND); // Codigo 404
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
        }
    }

    //Agregar pelicula
    @PostMapping(value = "/agregar")
    public ResponseEntity<Pelicula> agregarPelicula(Pelicula pelicula) {
        Pelicula peliculaGuardada = peliculaService.agregarPelicula(pelicula);
        return new ResponseEntity<>(peliculaGuardada, HttpStatus.CREATED); // Codigo 201
    }

    //Editar pelicula por id
    @PostMapping(value = "/editar/{id}")
    public ResponseEntity<Pelicula> editarPeliculaPorId(Integer id, Pelicula pelicula) {
        Pelicula peliculaEditada = peliculaService.editarPeliculaPorId(id, pelicula);
        if (peliculaEditada != null) {
            return new ResponseEntity<>(peliculaEditada, HttpStatus.OK); // Codigo 200
        } else {
            return new ResponseEntity<>(peliculaEditada, HttpStatus.NOT_FOUND); // Codigo 404
        }
    }

    //Eliminar pelicula por id
    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarPeliculaPorId(Integer id) {
        boolean peliculaEliminada = peliculaService.eliminarPeliculaPorId(id);
        if (peliculaEliminada) {
            return new ResponseEntity<>(peliculaEliminada, HttpStatus.OK); // Codigo 200
        } else {
            return new ResponseEntity<>(peliculaEliminada, HttpStatus.NOT_FOUND); // Codigo 404
        }
    }
}