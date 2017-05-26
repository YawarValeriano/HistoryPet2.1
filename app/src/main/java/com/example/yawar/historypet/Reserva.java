package com.example.yawar.historypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Reserva extends AppCompatActivity {
    protected TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Reserva");
        String t=getIntent().getExtras().getString("mascota");
        tv=(TextView)findViewById(R.id.mas);
        tv.setText(t);
    }
    protected void aceptar(View view){
        Toast t = Toast.makeText(this,"Se envió la reserva", Toast.LENGTH_LONG);
        t.show();
        finish();
    }
}
