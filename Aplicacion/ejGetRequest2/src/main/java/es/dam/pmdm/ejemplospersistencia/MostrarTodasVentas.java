package es.dam.pmdm.ejemplospersistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MostrarTodasVentas extends AppCompatActivity implements View.OnClickListener{
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private Button back, filtrar;
    private TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostartodasventas);

        back = (Button) findViewById(R.id.btnAtrás);
        view = (TextView) findViewById(R.id.viewTodasVentas);
        filtrar = (Button) findViewById(R.id.btnFiltrar);

        back.setOnClickListener(this);
        filtrar.setOnClickListener(this::getVentas);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.209.0.19:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
    }
    public void onClick(View v){
        Intent volver=new Intent(this, MenuVentas.class);
        startActivity(volver);
    }
    public void getVentas(View view) {
        Call<List<Ventas>> call = jsonPlaceHolderApi.getVentas();
        //Petición en un hilo en segundo plano, retrofit lo hace y recibimos la respuesta
        call.enqueue(new Callback<List<Ventas>>() {
            //Si recibimos la respuesta, la gestiona
            @Override
            public void onResponse(Call<List<Ventas>> call, Response<List<Ventas>> response) {
                //Si responde con un error, paramos el flujo y mostramos el codigo de error.
                if (!response.isSuccessful()) {
                    MostrarTodasVentas.this.view.setText("Code: " + response.code());
                    return;
                }
                //Almacenamos datos en una lista
                List<Ventas> listaVentas = response.body();
                //Mostramos los datos, recorriendo la lista.
                for(Ventas venta : listaVentas){
                    String content="";
                    content +="ID: " + venta.getId_venta() + "\n";
                    content +="Fecha Venta: " + venta.getFecha_venta() + "\n";
                    content +="ID Cliente: " + venta.getC().getId() + "\n";
                    content +="ID Producto: " + venta.getP().getId() + "\n";
                    content +="Cantidad: " + venta.getCantidad() + "\n\n";
                    MostrarTodasVentas.this.view.append(content);
                }
            }
            //En caso de que no responda el servidor
            @Override
            public void onFailure(Call<List<Ventas>> call, Throwable t) {
                MostrarTodasVentas.this.view.setText(t.getMessage());
            }
        });
    }
}