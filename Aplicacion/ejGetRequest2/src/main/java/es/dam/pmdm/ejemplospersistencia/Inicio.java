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

public class Inicio extends AppCompatActivity {
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private EditText nif;
    private Button login;
    private TextView mensaje;
    public int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        nif= (EditText)findViewById(R.id.plainTextNIF);
        login=(Button)findViewById(R.id.buttonLogin);
        mensaje=(TextView)findViewById(R.id.textViewError);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.209.0.19:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        login.setOnClickListener(this::getClientes);
    }
    private void cambiopestaña(){
        Intent siguiente=new Intent(this, Menu.class);
        startActivity(siguiente);
    }
    public void getClientes(View view) {
        Call<List<Clientes>> call = jsonPlaceHolderApi.getClientes();
        String NIF=nif.getText().toString();
        //Petición en un hilo en segundo plano, retrofit lo hace y recibimos la respuesta
        call.enqueue(new Callback<List<Clientes>>() {
            //Respuesta del servidor
            @Override
            public void onResponse(Call<List<Clientes>> call, Response<List<Clientes>> response) {
                //Si responde con un error, paramos el flujo y mostramos el codigo de error.
                if (!response.isSuccessful()) {
                    mensaje.setText("Code: " + response.code());
                    return;
                }
                //Almacenamos datos en una lista
                List<Clientes> clientes = response.body();
                //Recorremos la lista, comparando los NIF
                for (int i=0;i<clientes.size();i++) {
                    if(NIF.equals(clientes.get(i).getNif())){
                        cambiopestaña();
                        mensaje.setText("Bienvenido");
                        cont++;
                    }
                }
                if ( cont == 0){
                    mensaje.setText("El NIF no existe");
                }
            }
            //En caso de que no responda el servidor
            @Override
            public void onFailure(Call<List<Clientes>> call, Throwable t) {
                mensaje.setText(t.getMessage());
            }
        });
    }
}