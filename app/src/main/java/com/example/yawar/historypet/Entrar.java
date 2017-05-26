package com.example.yawar.historypet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Entrar extends AppCompatActivity {
    protected ImageButton b1,b2,b3,b4,b5;
    protected Button sal;
    protected ImageButton dat,res,tra,resu;
    protected TextView tv,tvf;
    protected LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);
        getSupportActionBar().hide();
        layout=(LinearLayout)findViewById(R.id.linear_layout_tags);
        sal=(Button) findViewById(R.id.sal);
        dat=(ImageButton) findViewById(R.id.datb);
        res=(ImageButton) findViewById(R.id.res);
        tra=(ImageButton) findViewById(R.id.tra);
        resu=(ImageButton) findViewById(R.id.resu);
        tv=(TextView)findViewById(R.id.cam);
        b1=(ImageButton)findViewById(R.id.button1);
        b2=(ImageButton)findViewById(R.id.button2);
        b3=(ImageButton)findViewById(R.id.button3);
        b4=(ImageButton)findViewById(R.id.button4);
        b5=(ImageButton)findViewById(R.id.button5);

    }
    protected void cambiarNom(View view){
        String nombre="";
        if(b1.isPressed()==true){
            tv.setText("Mascota 1");
        }
        else{
            if(b2.isPressed()==true){
                tv.setText("Mascota 2");
            }
            else{
                if(b3.isPressed()==true){
                    tv.setText("Mascota 3");
                }
                else{
                    if(b4.isPressed()==true){
                        tv.setText("Mascota 4");
                    }
                    else{
                        if(b5.isPressed()==true){
                            Toast t = Toast.makeText(this,"Creando nueva msacota...", Toast.LENGTH_SHORT);
                            t.show();
                            Intent i=new Intent(this,Registro2.class);
                            startActivity(i);
                        }
                        else{
                            Toast t = Toast.makeText(this,"Oh, oh algo pasó", Toast.LENGTH_SHORT);
                            t.show();
                        }
                    }
                }

            }
        }
    }
    /*protected void add(View view){


        LinearLayout row = new LinearLayout(this);
        row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Button btnTag = new Button(this);
        btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btnTag.setText("Button ");

        row.addView(btnTag);
        layout.addView(row);
    }*/
    protected void datos(View view){
        Intent i=new Intent(this,Datos_Basicos.class);
        i.putExtra("mascota",tv.getText().toString());
        startActivity(i);

    }
    protected void reserva(View view){
        Intent i=new Intent(this,Reserva.class);
        i.putExtra("mascota",tv.getText().toString());
        startActivity(i);

    }
    protected void trata(View view){
        Intent i=new Intent(this,Tratamiento.class);
        i.putExtra("mascota",tv.getText().toString());
        startActivity(i);

    }
    protected void resul(View view){
        Intent i=new Intent(this,Resultado.class);
        i.putExtra("mascota",tv.getText().toString());
        startActivity(i);

    }
    protected void exit(View view){
        finish();
        Intent i=new Intent(this,Inicio.class);
        startActivity(i);
    }

}
