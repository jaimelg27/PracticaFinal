package es.dam.pmdm.ejemplospersistencia;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Productos {
    //@SerializedName hace referencia al nombre del campo del json

    @SerializedName("id")
    private int id;

    @SerializedName("descripcion")
    private String descripcion;

    @SerializedName("pvp")
    private Double pvp;

    @SerializedName("stockmanual")
    private int stockanual;

    public Productos(int id, String descripcion, Double pvp, int stockanual) {
        this.id = id;
        this.descripcion = descripcion;
        this.pvp = pvp;
        this.stockanual = stockanual;
    }

    public Productos() { }

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

    public Double getPvp() {
        return pvp;
    }

    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    public int getStockanual() {
        return stockanual;
    }

    public void setStockanual(int stockanual) {
        this.stockanual = stockanual;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", pvp=" + pvp +
                ", stockanual=" + stockanual +
                '}';
    }
}
