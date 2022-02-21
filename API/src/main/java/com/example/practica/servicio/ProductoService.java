package com.example.practica.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.practica.modelo.*;
import com.example.practica.repositorio.*;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productorepo;
	
	//Añadir producto al repositorio
	public Productos create(Productos p) {
		return productorepo.save(p);
	}
	
	//Consultar todos los productos de la BD
	public List<Productos> getall(){
		return productorepo.findAll();
	}
	
	//Consultar producto por ID
	public Optional<Productos> searchbyID(int id){
		return productorepo.findById(id);
	}
	
	//Actualizar campo por ID
	public Productos update(Productos p) {
		return productorepo.save(p);
	}
	
	//Eliminar producto por ID
	public void delete(Productos p) {
		productorepo.delete(p);
	}

}
