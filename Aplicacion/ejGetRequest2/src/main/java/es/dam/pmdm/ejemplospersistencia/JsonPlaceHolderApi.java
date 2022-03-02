package es.dam.pmdm.ejemplospersistencia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    //Obtener todos los clientes con metodo GET
    @GET("/clientes")
    Call<List<Clientes>> getClientes();
    //Obtener todos los productos con metodo GET
    @GET("/productos")
    Call<List<Productos>> getProductos();
    //Crear venta con metodo POST
    @POST("/ventas")
    Call<Ventas> createVenta(@Body Ventas c);
    //Obtener todas las ventas con metodo GET
    @GET("/ventas")
    Call<List<Ventas>> getVentas();
    //Obtener las ventas por NIF
    @GET("/ventas/nif/{nif}")
    Call<List<Ventas>> getVentasNif(@Path("NIF") String nif);
    //Eliminar venta por ID
    @DELETE("/ventas/id/{id}")
    Call<List<Ventas>> deleteVentas(@Path("id") int id);
    //Obtener las ventas por rango de fechas
    @GET("/ventas/fecha/inicio={fecha1}&fin={fecha2}")
    Call<List<Ventas>> getVentasFecha(@Path("Fecha1") String fecha1, @Path("Fecha2") String fecha2);
}