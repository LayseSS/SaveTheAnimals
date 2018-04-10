package laysesantos.com.savetheanimals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeletarActivity extends AppCompatActivity {

   EditText tId;
   Button tela_deletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar);

        tId = (EditText) findViewById(R.id.editTextoIdentificacao);
        tela_deletar = (Button) findViewById(R.id.button_deletar);

    }

    public void deletarAnimal(View v){

        Animal a = new Animal();
        a.setId(Integer.parseInt(tId.getText().toString()));

        AnimalController ac = new AnimalController(this);
        String msg = ac.deletarDados(a);

        //limpa os campos
        tId.setText("");

        //exibir mensagem confirmando o cadastro
        Toast mensagem = Toast.makeText(DeletarActivity.this, msg, Toast.LENGTH_SHORT);
        mensagem.show();
    }

    public void trocaTela5(View v){
        Intent intent = new Intent(this, ListaActivity.class); //chama a tela da lista
        startActivity(intent);

    }

    public void trocaTela6(View v){

        Intent intent = new Intent(this, EscolherActivity.class); //chama a tela da lista
        startActivity(intent); // inicia a tela nova

    }
}
