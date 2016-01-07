package br.com.inovert.calculonotas.DataBase;

/**
 * Created by roner on 13/08/15.
 */
public class Tabela {

    public  static String getCreateNotas ()
    {



         StringBuilder sqlBuilder=new StringBuilder();

        sqlBuilder.append("CREATE TABLE IF NOT EXISTS NOTABANCO ( ");
        sqlBuilder.append("_id    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("NOTASFALTA       VARCHAR (255), "   );
        sqlBuilder.append("TIPOMATERIA       VARCHAR (1) "   );
        sqlBuilder.append("); ");


        return sqlBuilder.toString();




    }


}
