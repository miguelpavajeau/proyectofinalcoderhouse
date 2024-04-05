package com.coderhouse.proyecto.servicios;

import com.coderhouse.proyecto.entidades.Cliente;
import com.coderhouse.proyecto.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente mostrarClientePorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente editarClientePorId(Integer id, Cliente cliente) {
        try {
            if (clienteRepository.existsById(id)) {
                cliente.setId(id);
                return clienteRepository.save(cliente);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public boolean eliminarClientePorId(Integer id) {
        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}