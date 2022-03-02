package es.dam.pmdm.ejemplospersistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuVentas extends AppCompatActivity implements View.OnClickListener {
    private Button atras;
    private Button allventas;
    private Button ventasid;
    private Button ventasnif;
    private Button delete;
    private Button date;
    private Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuventas);

        atras =(Button)findViewById(R.id.btnAtrás);
        allventas =(Button)findViewById(R.id.btnTodasVentas);
        ventasid =(Button)findViewById(R.id.btnVentasId);
        ventasnif =(Button)findViewById(R.id.btnVentasNif);
        delete =(Button)findViewById(R.id.btnBorrarId);
        date =(Button)findViewById(R.id.btnVentasFechas);
        insert =(Button)findViewById(R.id.btnInsertarVenta);

        atras.setOnClickListener(this);
        allventas.setOnClickListener(this::onClick2);
        ventasid.setOnClickListener(this::onClick3);
        ventasnif.setOnClickListener(this::onClick4);
        delete.setOnClickListener(this::onClick5);
        date.setOnClickListener(this::onClick6);
        insert.setOnClickListener(this::onClick7);

    }
    public void onClick(View v){
        Intent atras=new Intent(this, Menu.class);
        startActivity(atras);
    }
    public void onClick2(View v2){
        Intent allventas=new Intent(this, MostrarTodasVentas.class);
        startActivity(allventas);
    }
    public void onClick3(View v3){
        Intent ventasid=new Intent(this, MostrarVentasId.class);
        startActivity(ventasid);
    }
    public void onClick4(View v4){
        Intent ventasnif=new Intent(this, MostrarVentasNif.class);
        startActivity(ventasnif);
    }
    public void onClick5(View v5){
        Intent deleteventas=new Intent(this, BorrarVentas.class);
        startActivity(deleteventas);
    }
    public void onClick6(View v6){
        Intent ventasdate=new Intent(this, MostrarVentasFechas.class);
        startActivity(ventasdate);
    }
    public void onClick7(View v7){
        Intent insertventas=new Intent(this, InsertarVentas.class);
        startActivity(insertventas);
    }
}