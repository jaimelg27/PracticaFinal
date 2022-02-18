package com.example.practica.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.modelo.Ventas;
import com.example.practica.repositorio.VentaRepository;

@Service
public class VentaService {
	
	@Autowired
	private VentaRepository ventaRepository;
	
	public List<Ventas> consulta(){
		return ventaRepository.findAll();
	}
	
	
	

}
