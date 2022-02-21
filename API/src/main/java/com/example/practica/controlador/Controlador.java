package com.example.practica.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	//PRODUCTOS
	
	//Insertar producto
	@RequestMapping(value = "/productos", method = RequestMethod.POST)
    public ResponseEntity<Productos> createProd(@RequestBody Productos p){
    	return new ResponseEntity<Productos>(productoserv.create(p),HttpStatus.OK);
    }
	
	//Devolver todos los productos
	@RequestMapping(value="/productos", method=RequestMethod.GET)
	public ResponseEntity<List<Productos>> consultaProd(){
		return new ResponseEntity<List<Productos>>(productoserv.getall(),HttpStatus.OK);		
	}
	
	//Devolver productos por id
	@RequestMapping(value = "/productos/{id}", method = RequestMethod.GET)
	public ResponseEntity<Productos> searchbyID(@PathVariable("id") byte id) {
    	Optional<Productos> prodOpt=productoserv.searchbyID(id);
    	if (prodOpt.isPresent()) {
    		Productos p= prodOpt.get();
    		return new ResponseEntity<Productos>(p,HttpStatus.OK);
    	}
    	else
    		return null;
	}
	
	//Actualizar productos por id
	@RequestMapping(value = "/productos", method = RequestMethod.PUT)
    public ResponseEntity<Productos> updatebyID(@RequestBody Productos p){
        return new ResponseEntity<Productos>(productoserv.update(p),HttpStatus.OK);
    }
	
	//Eliminar producto por id
	@RequestMapping(value = "/productos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletebyID(@PathVariable("id") byte id){
    	Optional<Productos> prodOpt=productoserv.searchbyID(id);
    	if (prodOpt.isPresent()) {
    		Productos p=prodOpt.get();
    		productoserv.delete(p);
    		return new ResponseEntity<String>("Producto eliminado",HttpStatus.OK);
    	} else {
    		return new ResponseEntity<String>("Producto no existe",HttpStatus.OK);
    	}
        
    }
	
	//CLIENTES
	
	//Insertar cliente
	@RequestMapping(value = "/clientes", method = RequestMethod.POST)
    public ResponseEntity<Clientes> createCli(@RequestBody Clientes c){
    	return new ResponseEntity<Clientes>(clienteserv.create(c),HttpStatus.OK);
    }
	
	//Devolver todos los clientes
	@RequestMapping(value="/clientes", method=RequestMethod.GET)
	public ResponseEntity<List<Clientes>> consultaCli(){
		return new ResponseEntity<List<Clientes>>(clienteserv.getall(),HttpStatus.OK);		
	}
	
	//Consultar cliente por NIF
	@RequestMapping(value = "/clientes/{nif}", method = RequestMethod.GET)
	public ResponseEntity<Clientes> searchbyNIF(@PathVariable("nif") String nif) {
    	Optional<Clientes> clientOpt=clienteserv.searchbyNIF(nif);
    	if (clientOpt.isPresent()) {
    		Clientes c= clientOpt.get();
    		return new ResponseEntity<Clientes>(c,HttpStatus.OK);
    	} else
    		return null;
	}
	
	//Actualizar cliente por NIF
	@RequestMapping(value = "/clientes/{nif}", method = RequestMethod.PUT)
    public ResponseEntity<Clientes> updatebyNIF(@PathVariable("nif") String nif, @RequestBody Clientes c){
        Optional<Clientes> clientOpt=clienteserv.searchbyNIF(nif);
        if(clientOpt.isPresent()) {
        	return new ResponseEntity<Clientes>(clienteserv.update(c),HttpStatus.OK);
        } else {
        	return null;
        }
    }
	
	//Eliminar cliente por NIF
	@RequestMapping(value = "/clientes/{nif}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletebyNIF(@PathVariable("nif") String nif){
    	Optional<Clientes> clientOpt=clienteserv.searchbyNIF(nif);
    	if (clientOpt.isPresent()) {
    		Clientes c=clientOpt.get();
    		clienteserv.delete(c);
    		return new ResponseEntity<String>("Cliente eliminado",HttpStatus.OK);
    	} else {
    		return new ResponseEntity<String>("Cliente no existe",HttpStatus.OK);
    	}
        
    }
	
	//VENTAS
	
	//Insertar venta
	@RequestMapping(value = "/ventas", method = RequestMethod.POST)
    public ResponseEntity<Ventas> createVent(@RequestBody Ventas v){
    	return new ResponseEntity<Ventas>(ventaserv.create(v),HttpStatus.OK);
    }
	
	//Consultar ventas en intervalo de fechas
	
	//Consultar ventas por NIF cliente
	
	
	//Consultar venta por campo clave
	@RequestMapping(value = "/ventas/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ventas> searchventbyID(@PathVariable("id") byte id) {
    	Optional<Ventas> ventOpt=ventaserv.searchbyID(id);
    	if (ventOpt.isPresent()) {
    		Ventas v= ventOpt.get();
    		return new ResponseEntity<Ventas>(v,HttpStatus.OK);
    	}
    	else
    		return null;
	}
	
	//Eliminar venta por campo clave
	@RequestMapping(value = "/ventas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteventbyID(@PathVariable("id") byte id){
    	Optional<Ventas> ventOpt=ventaserv.searchbyID(id);
    	if (ventOpt.isPresent()) {
    		Ventas v=ventOpt.get();
    		ventaserv.deletebyId(v);
    		return new ResponseEntity<String>("Venta eliminada",HttpStatus.OK);
    	} else {
    		return new ResponseEntity<String>("Venta no existe",HttpStatus.OK);
    	}
        
    }
}
