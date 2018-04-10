package laysesantos.com.savetheanimals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EscolherActivity extends AppCompatActivity {

    Button tTela2, tTela3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher);

        tTela2 = (Button) findViewById(R.id.buttonCadastrar);
        tTela3 = (Button) findViewById(R.id.button_visualizar2);
    }

    public void trocaTela2 (View v){

        Intent intent = new Intent(this, CadastrarActivity.class); //chama a tela para cadastrar
        startActivity(intent); // inicia a tela nova
        // this.finish(); // fecha essa tela sozinho sem precisar do botão
    }

    public void trocaTela3(View v) {

        Intent intent = new Intent(this, ListaActivity.class); //chama a tela para cadastrar
        startActivity(intent); // inicia a tela nova
    }

    public void trocaTela7(View v){

        Intent intent = new Intent(this, DeletarActivity.class); //chama a tela da lista
        startActivity(intent); // inicia a tela nova

    }
}
