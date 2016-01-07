package br.com.inovert.calculonotas.Entidade;

/**
 * Created by roner on 10/08/15.
 */
public class Calculo_nota {

    private Double v1;
    private Double  v2;
    private Double result;


     public  double media  ( ){


         return ((v1*.4) + (v2*.6));

    }


    public double  restante (){


        return  ((6-(v1 *.4))/.6);

    }




    public Double getV1(Double v1) {
        return this.v1;
    }

    public void setV1(Double v1) {
        this.v1 = v1;
    }

    public Double getV2(double v) {
        return v2;
    }

    public void setV2(Double v2) {
        this.v2 = v2;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }




}
