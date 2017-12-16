package com.example.moraga.ev4vmoragaptenorio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.moraga.ev4vmoragaptenorio.ModulosBdd.Ciudades;
import com.example.moraga.ev4vmoragaptenorio.ModulosBdd.DatabaseHelper;

import java.util.List;

public class MenuPrinicipalActivity extends AppCompatActivity {
    private DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_prinicipal);
        ListView lista=(ListView)findViewById(R.id.ciudad);
        List<Ciudades> ciudades=helper.listaciudades();
        ArrayAdapter<Ciudades> adapter=new ArrayAdapter<Ciudades>(this, android.R.layout.simple_list_item_1,ciudades);
        lista.setAdapter(adapter);
        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MenuPrinicipalActivity.this,LocalesActivity.class);
                startActivity(intent);
            }
        };
        lista.setOnItemClickListener(itemClickListener);
    }
    public void btnvolver(View view){
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
