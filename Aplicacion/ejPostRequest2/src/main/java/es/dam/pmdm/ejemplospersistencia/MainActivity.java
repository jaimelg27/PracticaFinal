package es.dam.pmdm.ejemplospersistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        /*No funciona con la IP 127.0.0.1, ya que el emulador de android también se reconoce como
            localhost. De modo que los pasos a seguir para darle IP válida son:
                - ipconfig para sacar la ip.
                - En el fichero application.properties del proyecto Spring boot
                    server.address=192.168.1.94
                - Establecemos la misma IP base en el proyecto android de Retrofit (ver abajo)
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.118:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        createCliente();

    }

    private void getClientes() {
        Call<List<Cliente>> call = jsonPlaceHolderApi.getClientes();

        //Ejecutamos la petición en un hilo en segundo plano, retrofit lo hace por nosotros
        // y esperamos a la respuesta
        call.enqueue(new Callback<List<Cliente>>() {

            //Gestionamos la respuesta del servidor
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                //Respuesta del servidor con un error y paramos el flujo del programa
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                //El servidor responde con datos que almacenamos en una lista
                List<Cliente> clientes = response.body();
                //Los mostramos en un textView, recorriendo la lista
                for (Cliente cliente : clientes) {
                    String content = "";
                    content += "ID: " + cliente.getId() + "\n";
                    content += "Text: " + cliente.getText() + "\n\n";

                    textViewResult.append(content);
                }
            }

            //En caso de que no responda el servidor
            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
        private void createCliente(){
            Cliente cliente = new Cliente(91,"New Title");


            //Call<Cliente> call = jsonPlaceHolderApi.createCliente(cliente.getId(),cliente.getText());

            Call<Cliente> call = jsonPlaceHolderApi.createCliente(cliente);

            call.enqueue(new Callback<Cliente>() {
                @Override
                public void onResponse(Call<Cliente> call, Response<Cliente> response) {

                    if (!response.isSuccessful()) {
                        textViewResult.setText("Code: " + response.code());
                        return;
                    }

                    Cliente postResponse = response.body();

                    String content = "";
                    content += "Code: " + response.code() + "\n";
                    content += "ID: " + postResponse.getId() + "\n";
                    content += "Text: " + postResponse.getText() + "\n\n";

                    textViewResult.setText(content);
                }

                @Override
                public void onFailure(Call<Cliente> call, Throwable t) {
                    textViewResult.setText(t.getMessage());
                }
            });
        }
}

