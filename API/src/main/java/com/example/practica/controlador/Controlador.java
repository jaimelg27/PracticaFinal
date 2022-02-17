package com.example.practica.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.practica.modelo.*;
import com.example.practica.repositorio.*;
import com.example.practica.servicio.*;

@Controller

public class Controlador {
	
	@Autowired
	private ClienteRepository clienterepo;
	
	@Autowired
	private ProductoRepository productorepo;
	
	@Autowired
	private VentaRepository ventarepo;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
	 	return "Practica 4";
	}

}
