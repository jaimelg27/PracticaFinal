package com.example.practica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practica.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
