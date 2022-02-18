package com.example.practica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practica.modelo.Ventas;

public interface VentaRepository extends JpaRepository<Ventas, Integer>{

}
