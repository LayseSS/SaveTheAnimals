package laysesantos.com.savetheanimals;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by layss on 22/03/2018.
 */

public class AnimalDataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "savetheanimals.db";
    private static final int DATABASE_VERSION = 1;

    public AnimalDataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        final String CREATE = "CREATE TABLE IF NOT EXISTS animal(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(100), raca  VARCHAR(100), idade  INTEGER, peso REAL)";
        db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }

}
