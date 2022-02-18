package com.example.practica.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demoWebHibernate.modelo.Departamentos;
import com.example.practica.modelo.*;
import com.example.practica.repositorio.*;
import com.example.practica.servicio.*;

@Controller

public class Controlador {
	
	@Autowired
	private ClienteService clienteserv;
	
	@Autowired
	private ProductoService productoserv;
	
	@Autowired
	private VentaService ventaserv;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
	 	return "Practica 4";
	}
	
	@RequestMapping(value="/cliente", method=RequestMethod.GET)
	public ResponseEntity<List<Clientes>> consultaDep(){
		return new ResponseEntity<List<Clientes>>(clienteserv.consulta(),HttpStatus.OK);		
	}

}
