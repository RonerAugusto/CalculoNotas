package br.com.inovert.calculonotas.Dominio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.*;
import android.widget.*;
import android.content.*;

import br.com.inovert.calculonotas.R;


public class tela_reprovada extends AppCompatActivity implements View.OnClickListener {

    private EditText edtValor;
    private Button  btnFechar;
    private TextView viewNota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_reprovada);

        btnFechar=(Button)findViewById(R.id.btnFechar);
        viewNota=(TextView)findViewById(R.id.viewNota);
        btnFechar.setOnClickListener(this);




        Bundle bdl=getIntent().getExtras();

        if (bdl.containsKey("sifu")) {

            Double valor=bdl.getDouble("sifu");

            viewNota.setText(valor.toString());




        }
    }


    @Override
    public void onClick(View v) {
        finish();

    }
}
