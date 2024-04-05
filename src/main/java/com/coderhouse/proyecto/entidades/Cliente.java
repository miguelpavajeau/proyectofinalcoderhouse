package com.coderhouse.proyecto.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Table(name = "cliente")
@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String direccion;

    @ManyToMany
    private List<Pelicula> peliculasAlquiladas = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void alquilarPelicula(Pelicula pelicula) {
        peliculasAlquiladas.add(pelicula);
        pelicula.getClientesQueAlquilaron().add(this);
        pelicula.setDisponible(false);
    }

    public void devolverPelicula(Pelicula pelicula) {
        peliculasAlquiladas.remove(pelicula);
        pelicula.getClientesQueAlquilaron().remove(this);
        pelicula.setDisponible(true);
    }
}

