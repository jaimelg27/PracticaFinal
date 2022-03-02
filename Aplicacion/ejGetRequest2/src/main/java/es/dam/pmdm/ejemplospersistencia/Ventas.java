package es.dam.pmdm.ejemplospersistencia;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Ventas {
    //@SerializedName hace referencia al nombre del campo del json

    @SerializedName("idventa")
    private int id_venta;

    @SerializedName("cantidad")
    private int cantidad;

    @SerializedName("date")
    private Date fechaventa;

    @SerializedName("cliente")
    private Clientes c;

    @SerializedName("producto")
    private Productos p;

    public Ventas(int id_venta, int cantidad, Date fechaventa, Clientes c, Productos p) {
        this.id_venta = id_venta;
        this.cantidad = cantidad;
        this.fechaventa = fechaventa;
        this.c = c;
        this.p = p;
    }

    public Ventas(int cantidad, Clientes c, Productos p) {
        this.cantidad = cantidad;
        this.c = c;
        this.p = p;
    }

    public Ventas() { }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public Clientes getC() { return c; }

    public void setC(Clientes c) { this.c = c; }

    public Productos getP() { return p; }

    public void setP(Productos p) { this.p = p; }

    @Override
    public String toString() {
        return "Ventas{" +
                "id_venta=" + getId_venta() +
                ", cantidad=" + getCantidad() +
                ", fechaventa=" + getFechaventa() +
                ", id_cliente=" + getC().getId() +
                ", id_producto=" + getP().getId() +
                '}';
    }
}