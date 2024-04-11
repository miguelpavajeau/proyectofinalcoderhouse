package com.coderhouse.proyecto.controladores;

import com.coderhouse.proyecto.entidades.Cliente;
import com.coderhouse.proyecto.servicios.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Listar clientes
    @GetMapping(value = "/")
    public ResponseEntity<List<Cliente>> listarClientes() {
        try {
            List<Cliente> clientes = clienteService.listarClientes();
            return new ResponseEntity<>(clientes, HttpStatus.OK); // Codigo 200
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
        }
    }

    //Mostrar cliente por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> mostrarClientePorId(Integer id) {
        try {
            Cliente cliente = clienteService.mostrarClientePorId(id);
            if (cliente != null) {
                return new ResponseEntity<>(cliente, HttpStatus.OK); // Codigo 200
            } else {
                return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND); // Codigo 404
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
        }
    }

    //Agregar cliente
    @PostMapping(value = "/agregar", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
        clienteService.agregarCliente(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED); // Codigo 201
    }

    //Editar cliente por id
    @PostMapping(value = "/editar/{id}")
    public ResponseEntity<Cliente> editarClientePorId(Integer id, Cliente cliente) {
        Cliente clienteEditado = clienteService.editarClientePorId(id, cliente);
        if (clienteEditado != null) {
            return new ResponseEntity<>(clienteEditado, HttpStatus.OK); // Codigo 200
        } else {
            return new ResponseEntity<>(clienteEditado, HttpStatus.NOT_FOUND); // Codigo 404
        }
    }

    //Eliminar cliente por id
    @PostMapping(value = "/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarClientePorId(Integer id) {
        boolean eliminado = clienteService.eliminarClientePorId(id);
        if (eliminado) {
            return new ResponseEntity<>(eliminado, HttpStatus.OK); // Codigo 200
        } else {
            return new ResponseEntity<>(eliminado, HttpStatus.NOT_FOUND); // Codigo 404
        }
    }
}