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

public class MostrarProductos extends AppCompatActivity implements View.OnClickListener {
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private Button volver;
    private Button filtrar;
    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrarproductos);

        volver = (Button) findViewById(R.id.btnAtras);
        view = (TextView) findViewById(R.id.viewBorrarVentas);
        filtrar = (Button) findViewById(R.id.btnFiltrar);

        volver.setOnClickListener(this);
        filtrar.setOnClickListener(this::getProductos);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.209.0.19:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
    }
    public void onClick(View v) {
        Intent volver = new Intent(this, Menu.class);
        startActivity(volver);
    }
    public void getProductos(View view) {
        Call<List<Productos>> call = jsonPlaceHolderApi.getProductos();
        //Petición en un hilo en segundo plano, retrofit lo hace y recibimos la respuesta
        call.enqueue(new Callback<List<Productos>>() {
            //Si recibimos la respuesta, la gestiona
            @Override
            public void onResponse(Call<List<Productos>> call, Response<List<Productos>> response) {
                //Si responde con un error, paramos el flujo y mostramos el codigo de error.
                if (!response.isSuccessful()) {
                    MostrarProductos.this.view.setText("Code: " + response.code());
                    return;
                }
                //Almacenamos datos en una lista
                List<Productos> listaProductos = response.body();
                //Mostramos los datos, recorriendo la lista.
                for(Productos producto : listaProductos){
                    String content="";
                    content +="ID: " + producto.getId() + "\n";
                    content +="Descripción: " + producto.getDescripcion() + "\n";
                    content +="Stock: " + producto.getStockanual() + "\n";
                    content +="Precio: " + producto.getPvp() + "\n\n";
                    MostrarProductos.this.view.append(content);
                }
            }
            //En caso de que no responda el servidor
            @Override
            public void onFailure(Call<List<Productos>> call, Throwable t) {
                MostrarProductos.this.view.setText(t.getMessage());
            }
        });
    }
}