package com.example.moraga.ev4vmoragaptenorio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegistrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
    }

    public void btnvolver(View view){
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
