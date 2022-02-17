package com.example.practica.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "productos", catalog = "practica3")
public class Producto {
	private byte id;
	private String descripcion;
	private Integer stock;
	private Float pvp;
	
	public Producto() {
		
	}

	public Producto(byte id, String descripcion, Integer stock, Float pvp) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.stock = stock;
		this.pvp = pvp;
	}

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Float getPvp() {
		return pvp;
	}

	public void setPvp(Float pvp) {
		this.pvp = pvp;
	}
	

}
