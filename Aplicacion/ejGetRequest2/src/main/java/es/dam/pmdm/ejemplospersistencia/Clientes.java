package es.dam.pmdm.ejemplospersistencia;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Clientes {
        //@SerializedName hace referencia al nombre del campo del json
        @SerializedName("id")
        private int id;
        @SerializedName("direccion")
        private String direccion;
        @SerializedName("nombre")
        private String nombre;
        @SerializedName("poblacion")
        private String poblacion;
        @SerializedName("telefono")
        private String telefono;
        @SerializedName("nif")
        private String nif;

        public Clientes(int id, String nombre, String direccion, String poblacion, String telefono, String nif) {
            this.id = id;
            this.direccion = direccion;
            this.nif = nif;
            this.nombre = nombre;
            this.poblacion = poblacion;
            this.telefono = telefono;
        }

        public Clientes() { }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getNif() {
            return nif;
        }

        public void setNif(String nif) {
            this.nif = nif;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getPoblacion() {
            return poblacion;
        }

        public void setPoblacion(String poblacion) {
            this.poblacion = poblacion;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        @Override
        public String toString() {
            return "Clientes{" +
                    "id=" + id +
                    ", direccion='" + direccion + '\'' +
                    ", nif='" + nif + '\'' +
                    ", nombre='" + nombre + '\'' +
                    ", poblacion='" + poblacion + '\'' +
                    ", telefono='" + telefono + '\'' +
                    '}';
        }
}