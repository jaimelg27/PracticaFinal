package com.example.practica.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.practica.repositorio.ClienteRepository;
import com.example.practica.repositorio.ProductoRepository;
import com.example.practica.repositorio.VentaRepository;

@Controller

public class Controlador {
	
	@Autowired
	private ClienteRepository clienterepo;
	
	@Autowired
	private ProductoRepository productorepo;
	
	@Autowired
	private VentaRepository ventarepo;

}
