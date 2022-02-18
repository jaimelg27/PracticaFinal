package com.example.practica.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demoWebHibernate.modelo.Departamentos;
import com.example.demoWebHibernate.modelo.Empleados;
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
	
	//Devolver todos los productos
	@RequestMapping(value="/productos", method=RequestMethod.GET)
	public ResponseEntity<List<Productos>> consultaProd(){
		return new ResponseEntity<List<Productos>>(productoserv.getall(),HttpStatus.OK);		
	}
	
	//Devolver todos los clientes
	@RequestMapping(value="/clientes", method=RequestMethod.GET)
	public ResponseEntity<List<Clientes>> consultaCli(){
		return new ResponseEntity<List<Clientes>>(clienteserv.getall(),HttpStatus.OK);		
	}
	
	//Insertar cliente
	@RequestMapping(value = "/clientes", method = RequestMethod.POST)
    public ResponseEntity<Clientes> createCli(@RequestBody Clientes c){
    	return new ResponseEntity<Clientes>(clienteserv.create(c),HttpStatus.OK);
    }
	
	//Insertar producto
	@RequestMapping(value = "/producto", method = RequestMethod.POST)
    public ResponseEntity<Productos> createProd(@RequestBody Productos p){
    	return new ResponseEntity<Productos>(productoserv.create(p),HttpStatus.OK);
    }
	
	//Insertar venta
	@RequestMapping(value = "/venta", method = RequestMethod.POST)
    public ResponseEntity<Ventas> createVent(@RequestBody Ventas v){
    	return new ResponseEntity<Ventas>(ventaserv.create(v),HttpStatus.OK);
    }
	
	//Actualizar productos
	@RequestMapping(value = "/productos", method = RequestMethod.PUT)
    public ResponseEntity<Productos> actualizar(@RequestBody Productos p){
        return new ResponseEntity<Productos>(productoserv.updatebyID(p),HttpStatus.OK);
    }
}
