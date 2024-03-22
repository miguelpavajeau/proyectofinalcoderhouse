package com.coderhouse.proyecto.entidades;

import java.util.ArrayList;
import java.util.List;


public class TiendaAlquilerPeliculas {
    private String nombre;
    private String direccion;
    private List<Pelicula> peliculas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public TiendaAlquilerPeliculas() {}

    public TiendaAlquilerPeliculas(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
}
