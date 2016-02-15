package br.com.inovert.calculonotas.Entidade;

/**
 * Created by roner on 13/08/15.
 */
public class Notas {

    public static String ID="_id";
    public static String NOTAS="NOTASFALTA";
    public static String MATERIAS="TIPOMATERIA";
    public static String PRIMEIRANOTA="PRIMEIRANOTA";

    private long id;
    private String notas;
    private String materia;
    private Integer primeiraNota;



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
       return notas+" "+materia+""+primeiraNota;
        
        
    }


    public Integer getPrimeiraNota() {
        return primeiraNota;
    }

    public void setPrimeiraNota(Integer primeiraNota) {
        this.primeiraNota = primeiraNota;
    }
}
