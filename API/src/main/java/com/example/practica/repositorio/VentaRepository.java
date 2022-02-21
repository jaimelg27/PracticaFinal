package com.example.practica.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practica.modelo.Clientes;
import com.example.practica.modelo.Ventas;

public interface VentaRepository extends JpaRepository<Ventas, Integer>{
	
	Optional<Ventas> findByCliente(Clientes c);

}

