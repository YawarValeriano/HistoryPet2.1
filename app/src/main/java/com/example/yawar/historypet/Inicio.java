package com.example.yawar.historypet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Inicio extends AppCompatActivity {
    protected EditText email, pass;
    protected TextView txtSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        getSupportActionBar().hide();
        email=(EditText)findViewById(R.id.correo);
        pass=(EditText)findViewById(R.id.contraseña);
        txtSub = (TextView)findViewById(R.id.crearUser);

    }
    public void inicio(View view){
        String corr=email.getText().toString();
        String pasw=pass.getText().toString();
        String emsi="",consi="",usuario="";
        BDDHelper a=new BDDHelper(this);
        a.abrir();
        String si="";
        if(corr.length()==0||pasw.length()==0){
            Toast x=Toast.makeText(this,"Campos vacios!",Toast.LENGTH_LONG);
            x.show();
        }else{
            try {
                si=a.consulta(corr);
                if(si.compareTo("x")!=0){
                    String []aux=si.split(";");
                    usuario=aux[0];
                    emsi=aux[1];
                    consi=aux[2];
                }
            } catch (IOException e) {
                Toast x=Toast.makeText(this,e.toString(),Toast.LENGTH_LONG);
                x.show();
            }
            a.cerrar();
            if(corr.compareTo(emsi)==0){
                if(pasw.compareTo(consi)==0){
                    Intent i=new Intent(this,Entrar.class);
                    startActivity(i);

                    Toast t = Toast.makeText(this,"Bienvenido "+usuario, Toast.LENGTH_SHORT);
                    t.show();
                }else{
                    pass.setText("");
                    Toast t = Toast.makeText(this,"Contraseña incorrecta", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
            else{
                Toast t = Toast.makeText(this,"Usuario no existe!", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }
    public void crear(View view){
        Toast t = Toast.makeText(this,"Creando usuario...", Toast.LENGTH_SHORT);
        t.show();
        Intent i=new Intent(this,Registro.class);
        startActivity(i);
    }



}
