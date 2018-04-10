package laysesantos.com.savetheanimals;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InicioActivity extends AppCompatActivity {

    Button tTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        tTela = (Button) findViewById(R.id.buttonInicio); //botão para iniciar a apk
    }

    public void trocaTela(View v){

        Intent intent = new Intent(this, EscolherActivity.class); //chama a tela para cadastrar
        startActivity(intent); // inicia a tela nova
       // this.finish(); // fecha essa tela sozinho sem precisar do botão
    }

}
