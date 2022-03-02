package es.dam.pmdm.ejemplospersistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener  {
    private Button exit;
    private Button productos;
    private Button ventas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        exit =(Button) findViewById(R.id.btnSalir);
        productos=(Button) findViewById(R.id.btnTodasVentas);
        ventas=(Button)findViewById(R.id.btnVentasId);

        exit.setOnClickListener(this);
        productos.setOnClickListener(this::onClick2);
        ventas.setOnClickListener(this::onClick3);
    }
    public void onClick(View v){
        Intent exit=new Intent(this, Inicio.class);
        startActivity(exit);
    }
    public void onClick2(View v2){
        Intent productos=new Intent(this, MostrarProductos.class);
        startActivity(productos);
    }
    public void onClick3(View v3){
        Intent ventas=new Intent(this, MenuVentas.class);
        startActivity(ventas);
    }
}