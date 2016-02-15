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

        values.put("NOTASFALTA",       nota.getNotas()  );
        values.put("TIPOMATERIA",      nota.getMaterias() );
        values.put("PRIMEIRANOTA",     nota.getPrimeiraNota() );


        conn.insertOrThrow("NOTABANCO",null,values);







    }


     public  void excluir ()
     {








     }

       public ArrayAdapter<Notas> lista_notas (Context context )
       {

           ArrayAdapter<Notas> adp_notas= new ArrayAdapter<Notas>(context,android.R.layout.simple_expandable_list_item_1);


           Cursor cursor=conn.query("NOTABANCO",null,null,null,null,null,null);

              if (cursor.getCount() > 0)
             {


                  cursor.moveToFirst();

                  do
                  {

                      Notas pega_notas=new Notas();

                      String N1;


                      pega_notas.setNotas("Falta= " + cursor.getString(cursor.getColumnIndex(Notas.NOTAS)) + "        ");
                      pega_notas.setMaterias("Matéria= " + cursor.getString(cursor.getColumnIndex(Notas.MATERIAS)) + "      Nota N1= ");
                      pega_notas.setPrimeiraNota(+cursor.getInt(cursor.getColumnIndex(Notas.PRIMEIRANOTA)));

                      adp_notas.add(pega_notas);

                  }
                  while (cursor.moveToNext());



              }

                 return adp_notas;





       }



}
