package com.example.yawar.historypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    protected TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Resultado");
        String t=getIntent().getExtras().getString("mascota");
        tv=(TextView)findViewById(R.id.mas);
        tv.setText(t);
    }
    protected void cura(View view){
        finish();

    }
    protected void ampliar(View view){
        finish();

    }
    protected void modificar(View view){
        finish();

    }
}
