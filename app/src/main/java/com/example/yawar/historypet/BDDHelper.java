package com.example.yawar.historypet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;

public class BDDHelper extends SQLiteOpenHelper{
    Context ctx;
     public BDDHelper(Context context) {
        super(context, "HistoryPet", null, 1);
        this.ctx=context;
     }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios(id_usuarios INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, apellido TEXT NOT NULL, correo TEXT NOT NULL, password TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST usuarios");
        onCreate(db);
    }
    // manejo de base de datos
    BDDHelper ayuda;
    SQLiteDatabase db;
    public void abrir(){
        ayuda=new BDDHelper(ctx);
        db=ayuda.getWritableDatabase();
    }
    public void cerrar(){
        db.close();
    }
    public long registrar(Usuario u)throws Exception{
        ContentValues val=new ContentValues();
        val.put("nombre",u.getNombre());
        val.put("apellido",u.getApellido());
        val.put("correo",u.getCorreo());
        val.put("password",u.getPassword());
        return db.insert("usuarios", null,val);
    }
    public String consulta(String correo)throws IOException{
        Cursor c=db.rawQuery("SELECT nombre, correo, password FROM usuarios",null);
        String sus="x";
        if (c.moveToFirst()){
            do{
                String nombre=c.getString(0);
                String email=c.getString(1);
                String contra=c.getString(2);
                if(email.compareTo(correo)==0){
                    sus=nombre+";"+email+";"+contra;
                    return sus;
                }
            }while (c.moveToNext());
        }
        return sus;
    }

}
