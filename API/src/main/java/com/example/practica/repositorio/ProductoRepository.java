package com.example.practica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practica.modelo.Productos;

public interface ProductoRepository extends JpaRepository<Productos, Integer>{

}
