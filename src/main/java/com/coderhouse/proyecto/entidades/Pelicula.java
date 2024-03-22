package com.coderhouse.proyecto.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "pelicula")
@Entity
class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;
    private int añoLanzamiento;
    private boolean disponible;

    @ManyToMany(mappedBy = "peliculasAlquiladas")
    private List<Cliente> clientesQueAlquilaron = new ArrayList<>();

    public Pelicula() {}

    public Pelicula(String titulo, String genero, int añoLanzamiento) {
        this.titulo = titulo;
        this.genero = genero;
        this.añoLanzamiento = añoLanzamiento;
        this.disponible = true;
    }

    // Getters y setters
    // Métodos getter y setter para id omitidos para simplificar

    public <E> List<E> getClientesQueAlquilaron() {
        return (List<E>) clientesQueAlquilaron;
    }
}