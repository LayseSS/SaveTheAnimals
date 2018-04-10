package laysesantos.com.savetheanimals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarActivity extends AppCompatActivity {

    EditText tNome, tRaca, tIdade, tPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        tNome = (EditText) findViewById(R.id.editTextoNome);
        tRaca = (EditText) findViewById(R.id.editTextoRaca);
        tIdade = (EditText) findViewById(R.id.editTextoIdade);
        tPeso = (EditText) findViewById(R.id.editTextoPeso);

    }

    public void salvarAnimal(View v){   //metodo de salvar no banco de dados
        //cria animal
        Animal a = new Animal();
        a.setNome(tNome.getText().toString());
        a.setRaca(tRaca.getText().toString());
        a.setIdade(Integer.parseInt(tIdade.getText().toString()));
        a.setPeso(Float.parseFloat(tPeso.getText().toString()));

        //insere animal no banco
        AnimalController ac = new AnimalController(this);
        ac.inserirDados(a);

        //limpa os campos
        tNome.setText("");
        tRaca.setText("");
        tIdade.setText("");
        tPeso.setText("");

        //exibir mensagem confirmando o cadastro
        String msg = "Dados cadastrados com sucesso!";
        Toast mensagem = Toast.makeText(CadastrarActivity.this, msg, Toast.LENGTH_SHORT);
        mensagem.show();
    }

    public void trocaTela1(View v){

        Intent intent = new Intent(this, ListaActivity.class); //chama a tela da lista
        startActivity(intent); // inicia a tela nova

    }
}
