package com.example.practica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practica.modelo.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Integer>{

}
