package ru.alunev.android.pmptest.ds;

import java.util.ArrayList;
import java.util.List;

import ru.alunev.android.pmptest.info.Question;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class QuestionsDAO {
    public static final String QUESTIONS_TABLE_NAME = "questions";
    public static final String QUESTIONS_ID = "_id";
    public static final String QUESTIONS_QUESTION = "question";
    public static final String QUESTIONS_ANS1 = "ans1";
    public static final String QUESTIONS_ANS2 = "ans2";
    public static final String QUESTIONS_ANS3 = "ans3";
    public static final String QUESTIONS_ANS4 = "ans4";
    public static final String QUESTIONS_CORRECT = "correct";
    public static final String QUESTIONS_JUST = "just";
    public static final String QUESTIONS_PG_ID = "pg_id";
    public static final String QUESTIONS_KA_ID = "ka_id";

    private static QuestionsDAO instance;
    private static SQLiteDatabase db;

    private QuestionsDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public static QuestionsDAO getInstance() throws Exception {
        if (instance == null) {
            throw new Exception("Please init first!");
        }
        return instance;
    }

    public static void init(Context context) {
        if (instance == null) {
            QuestionsOpenHelper openHelper = new QuestionsOpenHelper(context);
            db = openHelper.getReadableDatabase();
            instance = new QuestionsDAO(db);
        }
    }

    public Question getQuestionById(int id) {
        Cursor cursor = db.query(QUESTIONS_TABLE_NAME,
                allColumns(), QUESTIONS_ID + "=" + id, null, null, null, null);

        Question question = null;
        if (cursor.moveToFirst()) {
            question = readObjet(cursor);
        }

        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return question;
    }

    public int getQuestionsCount() {
        Cursor cursor = db.rawQuery("select count(*) from " + QUESTIONS_TABLE_NAME, new String[] {});

        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return count;
    }

    private String[] allColumns() {
        List<String> list = new ArrayList<String>();
        list.add(QUESTIONS_ID);
        list.add(QUESTIONS_QUESTION);
        list.add(QUESTIONS_ANS1);
        list.add(QUESTIONS_ANS2);
        list.add(QUESTIONS_ANS3);
        list.add(QUESTIONS_ANS4);
        list.add(QUESTIONS_CORRECT);
        list.add(QUESTIONS_JUST);
        list.add(QUESTIONS_PG_ID);
        list.add(QUESTIONS_KA_ID);

        return list.toArray(new String[] {});
    }

    private Question readObjet(Cursor cursor) {
        return new Question(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getInt(6),
                cursor.getString(7),
                cursor.getInt(8),
                cursor.getInt(9));
    }
}
