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

public class InsertarVentas extends AppCompatActivity implements View.OnClickListener{
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private Button volver, insertar;
    private TextView txtProducto, txtCliente, txtCantidad, txtErrores;
    private Clientes c;
    private Productos p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertarventas);

        volver = (Button) findViewById(R.id.btnAtrás);
        insertar = (Button) findViewById(R.id.btnAñadir);
        txtCantidad = (TextView) findViewById(R.id.plainTextCantidad);
        txtProducto = (TextView) findViewById(R.id.plainTextCliente);
        txtCliente = (TextView) findViewById(R.id.plainTextProducto);
        txtErrores = (TextView) findViewById(R.id.viewInsertarVentas);

        volver.setOnClickListener(this);
        insertar.setOnClickListener(this::onClick1);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.209.0.19:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
    }
    public void onClick(View v) {
        Intent volver = new Intent(this, MenuVentas.class);
        startActivity(volver);
    }
    public void onClick1(View view){
        int client = Integer.parseInt(txtCliente.getText().toString());
        int prod = Integer.parseInt(txtProducto.getText().toString());
        if (Integer.parseInt(txtCantidad.getText().toString()) > 0){
            int cant = Integer.parseInt(txtCantidad.getText().toString());
            miraIdProd(prod, client, cant);
        }else{
            txtErrores.setText("La cantidad tiene que ser mayor a cero\n");
        }
    }
    public void miraIdProd(int prod, int client, int cant){
        Call<List<Productos>> call = jsonPlaceHolderApi.getProductos();
        call.enqueue(new Callback<List<Productos>>() {
            //Respuesta del servidor
            @Override
            public void onResponse(Call<List<Productos>> call, Response<List<Productos>> response) {
                //Si responde con un error, paramos el flujo y mostramos el codigo de error.
                if (!response.isSuccessful()) {
                    txtErrores.setText("Code: " + response.code() + "\n");
                    return;
                }
                //Almacenamos datos en una lista
                List<Productos> listaProductos = response.body();
                for ( int i = 0; i < listaProductos.size(); i++){
                    if (listaProductos.get(i).getId() == prod){
                        p = listaProductos.get(i);
                    } else {
                        txtErrores.setText("No existe la id de producto\n");
                    }
                }
                if ( p != null){
                    miraIdClient(p, client, cant);
                }
            }
            //En caso de que no responda el servidor
            @Override
            public void onFailure(Call<List<Productos>> call, Throwable t) {
                txtErrores.setText(t.getMessage()+ "\n");
            }
        });
    }
    public void miraIdClient(Productos p, int client, int cant){
        Call<List<Clientes>> call = jsonPlaceHolderApi.getClientes();
        call.enqueue(new Callback<List<Clientes>>() {
            //Respuesta del servidor
            @Override
            public void onResponse(Call<List<Clientes>> call, Response<List<Clientes>> response) {
                //Si responde con un error, paramos el flujo y mostramos el codigo de error.
                if (!response.isSuccessful()) {
                    txtErrores.setText("Code: " + response.code() + "\n");
                    return;
                }
                //Almacenamos datos en una lista
                List<Clientes> listaClientes = response.body();
                for ( int i = 0; i < listaClientes.size(); i++){
                    if (listaClientes.get(i).getId() == client){
                        c = listaClientes.get(i);
                    } else {
                        txtErrores.setText("No existe la id de cliente\n");
                    }
                }
                if ( c != null){
                    insertaVenta(cant, c, p);
                }
            }
            //En caso de que no responda el servidor
            @Override
            public void onFailure(Call<List<Clientes>> call, Throwable t) {
                txtErrores.setText(t.getMessage()+ "\n");
            }
        });
    }
    public void insertaVenta(int cant, Clientes c, Productos p){
        Ventas v = new Ventas(cant, c, p);
        Call<Ventas> call = jsonPlaceHolderApi.createVenta(v);
        txtErrores.setText("Venta insertada correctamente\n");
        call.enqueue(new Callback<Ventas>() {
            //Respuesta del servidor
            @Override
            public void onResponse(Call<Ventas> call, Response<Ventas> response) {
                //Si responde con un error, paramos el flujo y mostramos el codigo de error.
                if (!response.isSuccessful()) {
                    txtErrores.setText("Code: " + response.code() + "\n");
                    return;
                }
            }
            //En caso de que no responda el servidor
            @Override
            public void onFailure(Call<Ventas> call, Throwable t) {
                txtErrores.setText(t.getMessage()+ "\n");
            }
        });
    }
}
