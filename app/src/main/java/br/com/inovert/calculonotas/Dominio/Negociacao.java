package br.com.inovert.calculonotas.Dominio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.Button;
import android.content.*;
import android.widget.TextView;

import br.com.inovert.calculonotas.R;


public class Negociacao extends AppCompatActivity implements View.OnClickListener {

    private Button btnFechar;
    private TextView viewNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_negociacao);

        btnFechar=(Button)findViewById(R.id.btnFechar);
        viewNota=(TextView)findViewById(R.id.viewNota);
        btnFechar.setOnClickListener(this);

       Bundle bundle=getIntent().getExtras();

        if (bundle.containsKey("negociacao"))
        {
             Double valor =bundle.getDouble("negociacao");
             viewNota.setText(valor.toString());


        }


    }


    @Override
    public void onClick(View v) {
        finish();

    }
}
