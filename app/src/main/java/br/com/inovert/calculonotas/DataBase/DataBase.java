package br.com.inovert.calculonotas.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.*;


/**
 * Created by roner on 13/08/15.
 */
public class DataBase extends SQLiteOpenHelper {



    //contrutor padrao cria o banco novonota
    public DataBase  (Context context)
    {

       super(context,"NOVONOTA",null,1);


    }




    @Override
    public void onCreate(SQLiteDatabase db) {


      db.execSQL(Tabela.getCreateNotas());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("drop table NOTABANCO ");
        onCreate(db);

    }
}
