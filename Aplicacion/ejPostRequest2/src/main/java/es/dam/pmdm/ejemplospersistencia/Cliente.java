package es.dam.pmdm.ejemplospersistencia;

import com.google.gson.annotations.SerializedName;

public class Cliente {
    //es el nombre del campo
    @SerializedName("empNo")
    private int id;

    //es el nombre del campo
    @SerializedName("apellido")
    private String text;

    public Cliente(int k,String nom){
        id=k;
        text=nom;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}