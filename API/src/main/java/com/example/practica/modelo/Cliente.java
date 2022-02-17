package com.example.practica.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes", catalog = "practica3")
public class Cliente {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="direccion")
	private String direccion;
	@Column(name="poblacion")
	private String poblacion;
	@Column(name="telef")
	private String telef;
	@Column(name="nif")
	private String nif;
	
	public Cliente() {
		
	}

	public Cliente(int id, String nombre, String direccion, String poblacion, String telef, String nif) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.telef = telef;
		this.nif = nif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getTelef() {
		return telef;
	}

	public void setTelef(String telef) {
		this.telef = telef;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

}
