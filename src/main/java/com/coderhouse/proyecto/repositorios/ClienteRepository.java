package com.coderhouse.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.coderhouse.proyecto.entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}