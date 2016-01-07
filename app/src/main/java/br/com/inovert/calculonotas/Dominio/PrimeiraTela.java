package br.com.inovert.calculonotas.Dominio;

import android.app.AlertDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.content.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.inovert.calculonotas.DataBase.DataBase;
import br.com.inovert.calculonotas.Entidade.Calculo_nota;
import br.com.inovert.calculonotas.R;
import android.database.*;
import android.database.sqlite.*;



public class PrimeiraTela extends AppCompatActivity implements View.OnClickListener{

    private EditText edtnotaum;
    private EditText edtnotadois;
    private Button  btnCalcular;
    private Calculo_nota calculo_nota;
    private ImageButton btnavaliacao;
    private DataBase   database;
    private SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_tela);

        edtnotaum = (EditText) findViewById(R.id.edtnotaum);
        edtnotadois = (EditText) findViewById(R.id.edtnotadois);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnavaliacao = (ImageButton) findViewById(R.id.btnavaliacao);

        btnavaliacao.setOnClickListener(this);
        btnCalcular.setOnClickListener(this);

        try {


            database = new DataBase(this);
            conn = database.getReadableDatabase();



        } catch (SQLException ex) {

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("conectado com sucesso" + ex.getMessage());
            alert.setNeutralButton("OK", null);
            alert.show();


        }


    }


    @Override
    public void onClick(View v) {

     // double media;

        switch (v.getId())
        {


            case R.id.btnavaliacao :

                Intent intent = new Intent(this, Avaliar.class);
                startActivity(intent);
                break;



            case R.id.btnCalcular:

            String n1 = edtnotaum.getText().toString();
            String n2 = edtnotadois.getText().toString();

            if (n2.trim().isEmpty() || n1.trim().isEmpty())
            {

                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("preencha todos os campos");
                alert.setNeutralButton("OK", null);
                alert.show();

            } else
             {

                calculo_nota = new Calculo_nota();

                calculo_nota.setV1(Double.parseDouble(n1));
                calculo_nota.setV2(Double.parseDouble(n2));

                Double media = Double.valueOf(String.format(Locale.US, "%2f", calculo_nota.media()));



                if (media < 5.7)
                {


                    Intent inte = new Intent(this, tela_reprovada.class);

                    inte.putExtra("sifu", media);
                    startActivity(inte);

                }
                if (media >= 6)
                {

                    Intent inte = new Intent(this, TelaAprovado.class);
                    inte.putExtra("safu", media);
                    startActivity(inte);


                }

                if (media == 5.7 || media == 5.8 || media == 5.9)

                {
                    Intent inte = new Intent(this, Negociacao.class);
                    inte.putExtra("negociacao", media);
                    startActivity(inte);

                }




             }

          break;
        }


    }
}
