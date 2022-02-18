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
	public void updatebyID(int id, String descripcion, int stock, int pvp) {
		Productos p=searchbyID(id).get();
		p.setDescripcion(descripcion);
		p.setStockanual(stock);
		p.setPvp(pvp);
		productorepo.save(p);
	}
	
	//Eliminar producto por ID
	public void deletebyId(int id) {
		Productos p=searchbyID(id).get();
		productorepo.delete(p);
	}

}
