package laysesantos.com.savetheanimals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by layss on 22/03/2018.
 */

public class AnimalController {

    private SQLiteDatabase db;
    private AnimalDataBaseHelper dbAnimal;

    public AnimalController(Context context) {
        dbAnimal = new AnimalDataBaseHelper(context);
    }

    public String inserirDados(Animal animal) {
        db = dbAnimal.getReadableDatabase();
        ContentValues valores = new ContentValues();
        //valores.put("identificacao", animal.getId());
        valores.put("nome", animal.getNome());
        valores.put("raca", animal.getRaca());
        valores.put("idade", animal.getIdade());
        valores.put("peso", animal.getPeso());

        long resultado;
        resultado = db.insert("animal", null, valores);
        db.close();
        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }

    public String deletarDados(Animal animal) {
        db = dbAnimal.getReadableDatabase();

        long resultado;
        resultado = db.delete("animal", "id = " + animal.getId(), null);
        db.close();
        if (resultado <= 0) {
            return "Erro ao deletar registro";
        } else {
            return "Registro deletado com sucesso";
        }
    }

    public List<Animal> listarDados() {
        db = dbAnimal.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM animal ORDER BY nome", null);
        cursor.moveToFirst();
        List<Animal> animalList = new ArrayList<Animal>();
        for (int i = 0; i < cursor.getCount(); i++) {
            Animal animal = new Animal();
            animal.setId(cursor.getInt(0));
            animal.setNome(cursor.getString(1));
            animal.setRaca(cursor.getString(2));
            animal.setIdade(cursor.getInt(3));
            animal.setPeso(cursor.getFloat(4));
            animalList.add(animal);
            cursor.moveToNext();
        }
        cursor.close();
        return animalList;
    }
}
