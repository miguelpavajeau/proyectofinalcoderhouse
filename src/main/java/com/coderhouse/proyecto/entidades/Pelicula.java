package com.coderhouse.proyecto.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
@Table(name = "pelicula")
@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String genero;
    @Column(name = "año_lanzamiento")
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

    //Constructor con todos los atributos menos el id
    public Pelicula(String titulo, String genero, int añoLanzamiento, boolean disponible, List<Cliente> clientesQueAlquilaron) {
        this.titulo = titulo;
        this.genero = genero;
        this.añoLanzamiento = añoLanzamiento;
        this.disponible = disponible;
        this.clientesQueAlquilaron = clientesQueAlquilaron;
    }

    //Constructor con todos los atributos
    public Pelicula(Integer id, String titulo, String genero, int añoLanzamiento, boolean disponible, List<Cliente> clientesQueAlquilaron) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.añoLanzamiento = añoLanzamiento;
        this.disponible = disponible;
        this.clientesQueAlquilaron = clientesQueAlquilaron;
    }
}