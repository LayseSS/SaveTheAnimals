package laysesantos.com.savetheanimals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private ListView lvAnimais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvAnimais = (ListView) findViewById(R.id.listaPrincipal);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listarAnimais();
    }

    public void listarAnimais(){
        AnimalController ac = new AnimalController(this);
        List<Animal> animais = ac.listarDados();
        List<String> textos = new ArrayList<String>();

        for(Animal a2 : animais){
            String texto = "ID: " + a2.getId() + " " +  a2.getNome() + ", é da raça " + a2.getRaca() + ", com idade " +
                    a2.getIdade() + " e peso de " + a2.getPeso() + "kg.";
            textos.add(texto);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, textos);
        lvAnimais.setAdapter(adapter);
    }

    public void trocaTela4(View v){

        Intent intent = new Intent(this, EscolherActivity.class); //chama a tela para cadastrar
        startActivity(intent); // inicia a tela nova
        // this.finish(); // fecha essa tela sozinho sem precisar do botão
    }

    public void trocaTela8(View v){

        Intent intent = new Intent(this, DeletarActivity.class); //chama a tela para cadastrar
        startActivity(intent); // inicia a tela nova
        // this.finish(); // fecha essa tela sozinho sem precisar do botão
    }
}
