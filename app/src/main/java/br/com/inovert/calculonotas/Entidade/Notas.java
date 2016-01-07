package br.com.inovert.calculonotas.Entidade;

/**
 * Created by roner on 13/08/15.
 */
public class Notas {

    public static String ID="_id";
    public static String NOTAS="NOTASFALTA ";
    public static String MATERIAS="TIPOMATERIA ";

    private long id;
    private String notas;
    private String materia;



    public Notas ()
    {



    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getMaterias() {
        return materia;
    }

    public void setMaterias(String materias) {
        materia = materias;
    }

    @Override
    public String toString ()
    {
       return notas+""+materia;
        
        
    }


}
