package ru.alunev.android.pmptest.ds;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class QuestionsOpenHelper extends SQLiteOpenHelper {
    private static String DB_PATH = "/data/data/ru.alunev.android.pmptest/databases/";
    private static final String DATABASE_NAME = "pmptest.db";
    private static final int DATABASE_VERSION = 1;

    private Context context;
/*
    private static final String QUESTIONS_TABLE_CREATE =
                "CREATE TABLE " + QUESTIONS_TABLE_NAME + " ("
                    + QUESTIONS_ID + " INT, "
                    + QUESTIONS_QUESTION + " INT, "
                    + QUESTIONS_ANS1 + " TEXT, "
                    + QUESTIONS_ANS2 + " TEXT, "
                    + QUESTIONS_ANS3 + " TEXT, "
                    + QUESTIONS_ANS4 + " TEXT, "
                    + QUESTIONS_CORRECT + " INT, "
                    + QUESTIONS_JUST + " TEXT, "
                    + QUESTIONS_PG_ID + " INT, "
                    + QUESTIONS_KA_ID + " INT"
                    + ");";
*/
    public QuestionsOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }

    public void createDatabase() {
        boolean dbExist = checkDataBase();
        SQLiteDatabase db_Read = null;

        if(dbExist){
            //do nothing - database already exist
        }else{
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            db_Read = this.getReadableDatabase();
            db_Read.close();

            copyDataBase();
        }
    }

    private void copyDataBase() {
        InputStream is = null;
        try {
            is = context.getAssets().open("PMP_quizs.db", AssetManager.ACCESS_STREAMING);

            int size = is.available();
            byte[] buf = new byte[size];
            int read = 0;
            FileOutputStream fos = new FileOutputStream(DB_PATH + DATABASE_NAME);
            while ((read = is.read(buf)) > 0) {
                fos.write(buf, 0, read);
            }

            is.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch(SQLiteException e){
            //database does't exist yet.
        }

        if(checkDB != null){
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

}

