package es.dam.pmdm.ejemplospersistencia;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Field;

public interface JsonPlaceHolderApi {

    //127.0.0.1:8080/cliente
    @GET("cliente")
    Call<List<Cliente>> getClientes();



    @FormUrlEncoded
    @POST("empleados")
    Call<Cliente> createCliente(
            @Field("empNo") int id,
            @Field("apellido") String text
    );

    //@FormUrlEncoded
    //@Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("empleados")
    Call<Cliente> createCliente(@Body Cliente c);


}