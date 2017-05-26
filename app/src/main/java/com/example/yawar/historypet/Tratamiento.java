package com.example.yawar.historypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Tratamiento extends AppCompatActivity {
    protected TextView tv;
    protected Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamiento);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Tratamiento");
        sp=(Spinner)findViewById(R.id.spi);
        String[] datos = new String[] {"Gotas", "Jarabe", "Pastillas", "Inyeccion", "Pomada"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
        sp.setAdapter(adapter);
        String t=getIntent().getExtras().getString("mascota");
        tv=(TextView)findViewById(R.id.mas);
        tv.setText(t);
    }
    protected void done(View view){
        Toast t = Toast.makeText(this,"Hecho", Toast.LENGTH_LONG);
        t.show();
        finish();
    }
}
