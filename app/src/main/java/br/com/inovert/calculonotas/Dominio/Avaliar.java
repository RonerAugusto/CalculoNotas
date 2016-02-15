package br.com.inovert.calculonotas.Dominio;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

import br.com.inovert.calculonotas.DataBase.DataBase;
import br.com.inovert.calculonotas.Entidade.Calculo_nota;
import br.com.inovert.calculonotas.Entidade.Notas;
import br.com.inovert.calculonotas.Persistencia;
import br.com.inovert.calculonotas.R;
import android.database.*;
import  android.database.sqlite.*;



public class Avaliar extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText edt_nota;
    private Button   btn_verificar;
    private Spinner  spn_materia;
    private ListView lst_media;
    private TextView txt_nota;
    private Persistencia persistencia;
    private DataBase database;
    private SQLiteDatabase conn;
    private Notas notas;




    private ArrayAdapter <String> adp_opcoes;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliar);

        edt_nota=(EditText)findViewById(R.id.edt_nota);
        btn_verificar=(Button)findViewById(R.id.btn_verificar);
        spn_materia=(Spinner)findViewById(R.id.spn_materia);
        lst_media=(ListView)findViewById(R.id.lst_media);
        txt_nota=(TextView)findViewById(R.id.txt_nota);
        lst_media.setOnItemClickListener(this);

        btn_verificar.setOnClickListener(this);



        adp_opcoes= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adp_opcoes.setDropDownViewResource(android.R.layout.simple_spinner_item);//para abrir a caixa de opçoes
        spn_materia.setAdapter(adp_opcoes);

        adp_opcoes.add("Materia");
        adp_opcoes.add("Eletrônica Digital");
        adp_opcoes.add("Eletrônica Analogica");
        adp_opcoes.add("Sistemas   Lineares");
        adp_opcoes.add("Inteligência Artificial");
        adp_opcoes.add("Resistência dos materiais");
        adp_opcoes.add("Eletrônica de Potência");
        adp_opcoes.add("Microcontroladores");


        //banco de dados
        try
            {
                database=new DataBase(this); //cria o banco

                conn=database.getWritableDatabase();//conecta com o banco

                persistencia= new Persistencia(conn); //metodo da classe persistencia





                lst_media.setAdapter(persistencia.lista_notas(this));



            }
        catch (SQLException e)
        {

            AlertDialog.Builder  alert= new AlertDialog.Builder(this);
            alert.setMessage("erro ao conectar no banco" + e.getMessage());
            alert.setNeutralButton("OK", null);
            alert.show();

        }



        Bundle bundle=getIntent().getExtras();








    }



         public void calcular ()


         {

             Calculo_nota calculo=new Calculo_nota();

             calculo.setV1(Double.parseDouble(edt_nota.getText().toString()));

             NumberFormat format = NumberFormat.getInstance();
             format.setMaximumFractionDigits(2);
             String media = format.format(calculo.restante());
             // Double media=calculo.restante();


             txt_nota.setText(media.toString());



         }

           public void startint ()
                   {
                       Intent inter = new Intent(this, Avaliar.class);
                       startActivityForResult(inter, 0);


                   }


                @Override
                protected void onActivityResult(int requestCode, int resultCode, Intent data)
                {
                    persistencia= new Persistencia(conn);
                    lst_media.setAdapter(persistencia.lista_notas(this));


                    super.onActivityResult(requestCode, resultCode, data);
                }

    @Override
         public void onClick(View v)
                {

                    switch (v.getId())
                    {
                        case R.id.btn_verificar:
                            calcular();

                            break;

                    }






                }


                      @Override
                      public boolean onCreateOptionsMenu(Menu menu)
                      {
                          MenuInflater inflater=getMenuInflater();
                          inflater.inflate(R.menu.menu_avaliar, menu);



                          return super.onCreateOptionsMenu(menu);
                      }

                         @Override
                         public boolean onOptionsItemSelected(MenuItem item)
                         {


                             switch (item.getItemId())
                            {



                              case  R.id.acao_salvar:

                                  if (notas==null)
                                  {

                                      insert();
                                      startint();

                                  }

                                       break;






                             }


                            return super.onOptionsItemSelected(item);
                         }


                            public void insert ()
                            {
                                try
                                {


                                     notas = new Notas();

                                    String itemdaspinner = spn_materia.getSelectedItem().toString();

                                    notas.setNotas(txt_nota.getText().toString());
                                    notas.setMaterias(itemdaspinner);
                                    notas.setPrimeiraNota(Integer.parseInt( edt_nota.getText().toString()));


                                    persistencia.inserir(notas);

                                }catch (Exception e)
                                {

                                    AlertDialog.Builder alert= new AlertDialog.Builder(this);
                                    alert.setMessage("Nao foi possivel cadastrar" + e.getMessage());
                                    alert.setNeutralButton("OK", null);
                                    alert.show();

                                }



                            }


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                AlertDialog.Builder alert= new AlertDialog.Builder(this);
                alert.setMessage("Deseja Deletar" );
               // alert.setPositiveButton("Excluir", new AlertDialog() );


                alert.show();


            }
}
