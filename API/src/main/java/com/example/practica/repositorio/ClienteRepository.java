package com.example.practica.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.practica.modelo.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Integer>{
	
	@Query(value="SELECT * FROM CLIENTES WHERE NIF=?1", nativeQuery=true)
    Optional<Clientes> findByNIF(String NIF);

}
