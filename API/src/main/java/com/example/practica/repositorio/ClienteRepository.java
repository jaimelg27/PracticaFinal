package com.example.practica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practica.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
