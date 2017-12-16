package com.example.moraga.ev4vmoragaptenorio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.moraga.ev4vmoragaptenorio.ModulosBdd.DatabaseHelper;
import com.example.moraga.ev4vmoragaptenorio.ModulosBdd.Direcciones;
import com.example.moraga.ev4vmoragaptenorio.ModulosBdd.Locales;

import java.util.List;

public class LocalesActivity extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locales);

        ListView lista=(ListView)findViewById(R.id.locales);
        ArrayAdapter<Locales> adapter=new ArrayAdapter<Locales>(this, android.R.layout.simple_list_item_1,helper.localesList());
        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int idLocal=position+1;
                Intent intent=new Intent(LocalesActivity.this, ResultadosActivity.class);
                intent.putExtra(ResultadosActivity.IDLOCAL,idLocal);
                startActivity(intent);
            }
        };
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(itemClickListener);
    }
    public void btnvolver(View view){
        Intent intent=new Intent(this, MenuPrinicipalActivity.class);
        startActivity(intent);
    }
}
