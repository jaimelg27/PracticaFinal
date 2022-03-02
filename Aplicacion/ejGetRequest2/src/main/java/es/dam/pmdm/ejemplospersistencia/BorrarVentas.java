package es.dam.pmdm.ejemplospersistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BorrarVentas extends AppCompatActivity implements View.OnClickListener{
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private Button volver, borrar;
    private TextView mostrar;
    private EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.borrarventas);

        volver = (Button)findViewById(R.id.btnAtrás);
        mostrar = (TextView)findViewById(R.id.viewBorrarVentas);
        borrar = (Button)findViewById(R.id.btnBorrar);
        id = (EditText)findViewById(R.id.plainTextID);

        volver.setOnClickListener(this);
        borrar.setOnClickListener(this::deleteVentas);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.209.0.19:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
    }
    public void onClick(View v){
        Intent volver=new Intent(this, MenuVentas.class);
        startActivity(volver);
    }
    public void deleteVentas(View view) {
        int idBorrar = Integer.parseInt(id.getText().toString());
        Call<List<Ventas>> call = jsonPlaceHolderApi.deleteVentas(idBorrar);
        //Petición en un hilo en segundo plano, retrofit lo hace y recibimos la respuesta
        call.enqueue(new Callback<List<Ventas>>() {
            //Respuesta del servidor
            @Override
            public void onResponse(Call<List<Ventas>> call, Response<List<Ventas>> response) {
                //Si responde con un error, paramos el flujo y mostramos el codigo de error.
                if (!response.isSuccessful()) {
                    mostrar.setText("Code: " + response.code());
                    return;
                }
            }
            //En caso de que no responda el servidor
            @Override
            public void onFailure(Call<List<Ventas>> call, Throwable t) {
                mostrar.setText(t.getMessage());
            }
        });
    }
}