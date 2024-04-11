package com.coderhouse.proyecto.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "cliente")
@Entity
@Data
@Getter
@Setter
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

    //Crear constructor con todos los atributos menos el id
    public Cliente(String nombre, String direccion, List<Pelicula> peliculasAlquiladas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.peliculasAlquiladas = peliculasAlquiladas;
    }

    //Crear constructor con todos los atributos
    public Cliente(Integer id, String nombre, String direccion, List<Pelicula> peliculasAlquiladas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.peliculasAlquiladas = peliculasAlquiladas;
    }

    //this.cliente
    public Cliente(Integer id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }
}