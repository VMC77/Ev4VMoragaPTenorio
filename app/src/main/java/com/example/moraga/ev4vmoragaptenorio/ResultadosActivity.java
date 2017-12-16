package com.example.moraga.ev4vmoragaptenorio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.moraga.ev4vmoragaptenorio.ModulosBdd.DatabaseHelper;
import com.example.moraga.ev4vmoragaptenorio.ModulosBdd.Locales;

import java.util.ArrayList;
import java.util.List;

public class ResultadosActivity extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);
    public static final String IDLOCAL="ID";
    Locales locales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        int ID= (int) getIntent().getExtras().get(IDLOCAL);
        String[] Datos=helper.LocalDatos(ID);
        String nomLocal=Datos[0].toString();
        String telLocal=Datos[1].toString();
        String emLocal=Datos[2].toString();
        String dirLocal=Datos[3].toString();
        TextView nombreLocal=(TextView)findViewById(R.id.nombreLocal);
        nombreLocal.setText(nomLocal);
        TextView telefonoLocal=(TextView)findViewById(R.id.telefonoLocal);
        telefonoLocal.setText(telLocal);
        TextView emailLocal=(TextView)findViewById(R.id.emailLocal);
        emailLocal.setText(emLocal);
        TextView direccionLocal=(TextView)findViewById(R.id.direccionLocal);
        direccionLocal.setText(dirLocal);
        int FI= Integer.parseInt(Datos[4]);
        ImageView foto=(ImageView)findViewById(R.id.foto);
        foto.setImageResource(FI);
    }
    public void irAlMapa(View view){
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
    public void btnvolver(View view){
        Intent intent=new Intent(this, LocalesActivity.class);
        startActivity(intent);
    }
}
