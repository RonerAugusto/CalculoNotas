package br.com.inovert.calculonotas.Dominio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.*;
import android.widget.*;
import android.content.*;

import br.com.inovert.calculonotas.R;


public class TelaAprovado extends AppCompatActivity implements View.OnClickListener {

    private EditText edtValorDois;
    private Button btnFecharDois;
    private TextView viewNota;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_aprovado);

       // edtValorDois=(EditText)findViewById(R.id.edtValorDois);
        btnFecharDois=(Button)findViewById(R.id.btnFecharDois);
        viewNota=(TextView)findViewById(R.id.viewNota);
        btnFecharDois.setOnClickListener(this);

        Bundle bundle=getIntent().getExtras();

        if (bundle.containsKey("safu")){


            Double valornum= bundle.getDouble("safu");


            viewNota.setText(valornum.toString());
        }


    }


    @Override
    public void onClick(View v) {

        finish();

    }
}
