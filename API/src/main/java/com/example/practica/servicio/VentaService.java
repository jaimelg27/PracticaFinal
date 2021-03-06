package com.example.practica.servicio;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.modelo.Clientes;
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
	public List<Ventas> searchbyDate(LocalDate a, LocalDate b){
		return ventarepo.findByfechaventaBetween(a, b);
	}
	
	//Consultar ventas por clientes
	public Optional<Ventas> searchbyNIF(Clientes c){
		return ventarepo.findByC(c);
	}

	//Consultar producto por ID
	public Optional<Ventas> searchbyID(int id){
		return ventarepo.findById(id);
	}
	
	//Eliminar producto por ID
	public void deletebyId(Ventas v) {
		ventarepo.delete(v);
	}
	

}
