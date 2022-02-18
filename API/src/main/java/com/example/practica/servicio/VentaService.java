package com.example.practica.servicio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.modelo.Productos;
import com.example.practica.modelo.Ventas;
import com.example.practica.repositorio.VentaRepository;

@Service
public class VentaService {
	
	@Autowired
	private VentaRepository ventarepo;
	
	//Añadir venta al repositorio
	public Ventas create(Ventas v) {
		return ventarepo.save(v);
	}
	
	// PENDIENTE Consultar ventas por fechas
	public Optional<Ventas> searchbyDate(Date on, Date off){
		return ventarepo.
	}
	
	// PENDIENTE Consultar ventas por clientes
	public Optional<Ventas> searchbyClientNIF(String NIF){
		
	}
	
	public Optional<Ventas> searchbyID(int id){
		return ventarepo.findById(id);
	}
	
	//Eliminar producto por ID
	public void deletebyId(int id) {
		Ventas v=searchbyID(id).get();
		ventarepo.delete(v);
	}
	

}
