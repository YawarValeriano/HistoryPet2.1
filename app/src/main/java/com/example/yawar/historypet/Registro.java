package com.example.yawar.historypet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private EditText nom,ap,corr,con1,con2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Registro");
        nom=(EditText)findViewById(R.id.nombre);
        ap=(EditText)findViewById(R.id.apellido);
        corr=(EditText)findViewById(R.id.correo);
        con1=(EditText)findViewById(R.id.contraseña1);
        con2=(EditText)findViewById(R.id.contraseña2);
    }
    public void registrar(View view){
        String c1=con1.getText().toString(),c2=con2.getText().toString();
        if(c1.compareTo(c2)!=0){
            Toast a= Toast.makeText(this,"Contraseñas no coinciden",Toast.LENGTH_SHORT);
            a.show();
            con1.setText("");
            con2.setText("");

        }else{
            String nombre=nom.getText().toString(),apellido=ap.getText().toString(),correo=corr.getText().toString(),contraseña=con1.getText().toString();
            try {
                BDDHelper a=new BDDHelper(this);
                a.abrir();
                Usuario us=new Usuario(nombre,apellido,correo,contraseña);
                long res=a.registrar(us);
                a.cerrar();
                if(res>0){
                    Toast x=Toast.makeText(this,"Bienvenid@ "+nombre,Toast.LENGTH_LONG);
                    x.show();
                }
            } catch (Exception e) {
                Toast x=Toast.makeText(this,e.toString(),Toast.LENGTH_LONG);
                x.show();
            }
            Intent i=new Intent(this,Registro2.class);
            startActivity(i);
        }

    }
}
