package br.com.inovert.calculonotas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import br.com.inovert.calculonotas.Entidade.Notas;


/**
 * Created by roner on 13/08/15.
 */
public class Persistencia {





    //conexao
    private SQLiteDatabase conn;

    public Persistencia (SQLiteDatabase conn){


        this.conn=conn;
    }



    public void inserir (Notas nota)
    {

        ContentValues values= new ContentValues();

        values.put("NOTASFALTA",    nota.getNotas()  );
        values.put("TIPOMATERIA",      nota.getMaterias() );

        conn.insertOrThrow("NOTABANCO",null,values);







    }

       public ArrayAdapter<Notas> lista_notas (Context context )
       {

           ArrayAdapter<Notas> adp_notas= new ArrayAdapter<Notas>(context,android.R.layout.simple_list_item_1);


           Cursor cursor=conn.query("NOTABANCO",null,null,null,null,null,null);

              if (cursor.getCount()>0)
              {


                  cursor.moveToFirst();

                  do
                  {

                      Notas pega_notas=new Notas();

                      pega_notas.setNotas(cursor.getString(cursor.getColumnIndex(Notas.NOTAS)));
                      pega_notas.setMaterias(cursor.getString(cursor.getColumnIndex(Notas.MATERIAS)));

                      adp_notas.add(pega_notas);

                  }
                  while (cursor.moveToNext());



              }

                 return adp_notas;





       }



}
