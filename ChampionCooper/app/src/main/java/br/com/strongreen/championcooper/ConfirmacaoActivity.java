package br.com.strongreen.championcooper;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ConfirmacaoActivity extends AppCompatActivity {

    String nome,genFem,genMasc,mod, fone, cpf, data;
    TextView mtxtnome,mtxtfone,mtxtcpf,mtxtgenero,mtxtnas,mtxtmod;
    Button mbtnEnviar,mbtnVoltar;

    Intent it = new Intent(ConfirmacaoActivity.this, CadastroActivity.class);

    private static ArrayList<Activity> activities=new ArrayList<Activity>();

    View.OnClickListener Editar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            startActivity(it);

        }
    };

    View.OnClickListener EnviarFor = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Toast.makeText(getApplicationContext(),"Sua Inscrição foi enviada com sucesso!", Toast.LENGTH_SHORT).show();
            onDestroy();
            finishAll();
            startActivity(it);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);


        mtxtnome = (TextView) findViewById(R.id.txtnome);
        mtxtfone = (TextView) findViewById(R.id.txtfone);
        mtxtcpf = (TextView) findViewById(R.id.txtcpf);

        mtxtgenero = (TextView) findViewById(R.id.txtgenero);

        mtxtnas = (TextView) findViewById(R.id.txtnas);
        mtxtmod = (TextView) findViewById(R.id.txtmod);

        mbtnEnviar = (Button) findViewById(R.id.btnEnviar);
        mbtnVoltar = (Button) findViewById(R.id.btnVoltar);

        mbtnEnviar.setOnClickListener(EnviarFor);
        mbtnVoltar.setOnClickListener(Editar);

        Intent it = getIntent();

        nome = it.getStringExtra("nome");
        fone = it.getStringExtra("fone");
        cpf = it.getStringExtra("cpf");
        genMasc = it.getStringExtra("genMasc");
        genFem = it.getStringExtra("genFem");
        data = it.getStringExtra("data");
        mod = it.getStringExtra("mod");


        mtxtnome.setText(nome);
        mtxtfone.setText(fone.toString());
        mtxtcpf.setText(cpf.toString());

        if(genMasc.equals("nulo")) {
            mtxtgenero.setText(genFem .toString());
        }
        else{
            if(genFem.equals("nulo")) {
                mtxtgenero.setText(genMasc.toString());
            }
        }

        mtxtnas.setText(data.toString());
        mtxtmod.setText(mod.toString());

    }

    public void onDestroy()
    {
        super.onDestroy();
        activities.remove(this);
    }

    public static void finishAll()
    {
        for(Activity activity:activities)
            activity.finish();
    }

}
