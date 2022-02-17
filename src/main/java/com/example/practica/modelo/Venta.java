package com.example.practica.modelo;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ventas", catalog = "practica3")
public class Venta {
	@Id
	@Column(name="idventa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idventa;
	@Column(name="fechaventa")
	private LocalDate fechaventa;
	@Column(name="cantidad")
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name = "idcliente")
	private Cliente c;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idproducto")
	private Producto p;
	
	public Venta() {
		
	}
	
	public Venta(int idventa, LocalDate fechaventa, int cantidad, Cliente c, Producto p) {
		super();
		this.idventa = idventa;
		this.fechaventa = fechaventa;
		this.cantidad = cantidad;
		this.c = c;
		this.p = p;
	}
	
	public Venta(LocalDate fechaventa, int cantidad, Cliente c, Producto p) {
		super();
		this.fechaventa = fechaventa;
		this.cantidad = cantidad;
		this.c = c;
		this.p = p;
	}
	
	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public LocalDate getFechaventa() {
		return fechaventa;
	}

	public void setFechaventa(LocalDate fechaventa) {
		this.fechaventa = fechaventa;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Cliente getC() {
		return c;
	}

	public void setC(Cliente c) {
		this.c = c;
	}

	public Producto getP() {
		return p;
	}

	public void setP(Producto p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Venta [Id:" + idventa + ", Fecha:" + fechaventa + ", Cantidad:" + cantidad + ", Cliente:" + c.getNif()
				+ ", Producto:" + p.getId() + "]";
	}

}
