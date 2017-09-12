package br.com.strongreen.championcooper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


public class CadastroActivity extends AppCompatActivity {

    EditText medtnome,medtFone,medtCpf,medtData;
    RadioButton mrdBtnFem,mrdBtnMasc;
    Button mbtnConfirma;
    Spinner mspnmod;

    View.OnClickListener tratadorDeClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String sedtnome,srdBtnMasc, srdBtnFem, sedtFone,sedtCpf,sedtData, sspnmod;

            String item = mspnmod.getSelectedItem().toString();

            sedtnome = medtnome.getText().toString();
            sedtFone = medtFone.getText().toString();
            sedtCpf = medtCpf.getText().toString();
            sedtData =medtData.getText().toString();
            sspnmod = item;
            srdBtnMasc = mrdBtnMasc.getText().toString();
            srdBtnFem = mrdBtnFem.getText().toString();

            Intent it = new Intent(CadastroActivity.this, ConfirmacaoActivity.class);

            String nulo = "nao";

            if(mrdBtnMasc.isChecked()) {
                Toast.makeText(getApplicationContext(),"Genero Masculino", Toast.LENGTH_SHORT).show();
                it.putExtra("genMasc",srdBtnMasc);
            }
            else {
                it.putExtra("genMasc",nulo);
            }
            if(mrdBtnFem.isActivated()) {
                Toast.makeText(getApplicationContext(),"Genero Feminino", Toast.LENGTH_SHORT).show();
                it.putExtra("genFem",srdBtnFem);
            }
            else {
                it.putExtra("genFem",nulo);
            }

            it.putExtra("nome",sedtnome);
            it.putExtra("fone",sedtFone);
            it.putExtra("cpf",sedtCpf);
            it.putExtra("data",sedtData);
            it.putExtra("mod",sspnmod);



            startActivity(it);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mspnmod = (Spinner) findViewById(R.id.spnMod);

        medtnome = (EditText) findViewById(R.id.edtnome);
        medtFone = (EditText) findViewById(R.id.edtFone);
        medtCpf = (EditText) findViewById(R.id.edtCpf);
        medtData = (EditText) findViewById(R.id.edtData);

        mrdBtnFem = (RadioButton) findViewById(R.id.rdBtnFem);
        mrdBtnMasc = (RadioButton) findViewById(R.id.rdBtnMasc);

        mbtnConfirma = (Button) findViewById(R.id.btnConfirma);

        mbtnConfirma.setOnClickListener(tratadorDeClique);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.categorias, android.R.layout.simple_spinner_item);

        mspnmod.setAdapter(adapter);


        AdapterView.OnItemSelectedListener modal= new AdapterView.OnItemSelectedListener(){


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String item = mspnmod.getSelectedItem().toString();

               if(i != 0) {
                    Toast.makeText(getApplicationContext(), "Selecionado "+ item, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Selecione uma modalidade ", Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                }
        };

        mspnmod.setOnItemSelectedListener(modal);
    }

}
