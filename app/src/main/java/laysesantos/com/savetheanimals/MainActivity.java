package laysesantos.com.savetheanimals;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etNome, etRaca, etIdade, etPeso;
    private Button btSalvar;
    private ListView lvAnimais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = (EditText) findViewById(R.id.editTextNome);
        etRaca = (EditText) findViewById(R.id.editTextRaca);
        etIdade = (EditText) findViewById(R.id.editTextIdade);
        etPeso = (EditText) findViewById(R.id.editTextPeso);
        btSalvar = (Button) findViewById(R.id.buttonSalvar);
        lvAnimais = (ListView) findViewById(R.id.listViewAnimais);

        listarAnimais();
    }

    public void salvarAnimal(View v){
        //cria animal
        Animal a = new Animal();
        a.setNome(etNome.getText().toString());
        a.setRaca(etRaca.getText().toString());
        a.setIdade(Integer.parseInt(etIdade.getText().toString()));
        a.setPeso(Float.parseFloat(etPeso.getText().toString()));

        //insere animal no banco
        AnimalController ac = new AnimalController(this);
        ac.inserirDados(a);

        //limpa os campos
        etNome.setText("");
        etRaca.setText("");
        etIdade.setText("");
        etPeso.setText("");

        //lista todos
        listarAnimais();
    }

    public void listarAnimais(){
        AnimalController ac = new AnimalController(this);
        List<Animal> animais = ac.listarDados();
        List<String> textos = new ArrayList<String>();

        for(Animal a2 : animais){
            String texto = a2.getNome() + " é da raça " + a2.getRaca() + ", com idade " +
                    a2.getIdade() + " anos e peso de " + a2.getPeso() + "kg.";
            textos.add(texto);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, textos);
        lvAnimais.setAdapter(adapter);
    }
}
