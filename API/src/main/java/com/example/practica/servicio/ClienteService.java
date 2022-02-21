package com.example.practica.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.modelo.*;
import com.example.practica.repositorio.*;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienterepo;

	// Añadir cliente al repositorio
	public Clientes create(Clientes c) {
		return clienterepo.save(c);
	}

	// Consultar todos los productos de la BD
	public List<Clientes> getall() {
		return clienterepo.findAll();
	}

	//Consultar producto por NIF
	public Optional<Clientes> searchbyNIF(String NIF) {
		return clienterepo.findByNIF(NIF);
		
	}

	// PENDIENTE Actualizar cliente por NIF
	public void updatebyNIF(String NIF, String name, String direccion, String poblacion, String telefono) {
		Clientes c = searchbyNIF(NIF).get();
		c.setNombre(name);
		c.setDireccion(direccion);
		c.setPoblacion(poblacion);
		c.setTelef(telefono);
		clienterepo.save(c);
	}

	//Eliminar cliente por NIF
	public void delete(Clientes c) {
		clienterepo.delete(c);
	}

}
