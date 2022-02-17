package com.example.practica.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos", catalog = "practica3")
public class Producto {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="stockanual")
	private int stockanual;
	@Column(name="pvp")
	private int pvp;
	
	public Producto() {
		
	}

	public Producto(int id, String descripcion, int stockanual, int pvp) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.stockanual = stockanual;
		this.pvp = pvp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStockanual() {
		return stockanual;
	}

	public void setStockanual(int stockanual) {
		this.stockanual = stockanual;
	}

	public int getPvp() {
		return pvp;
	}

	public void setPvp(int pvp) {
		this.pvp = pvp;
	};
}
