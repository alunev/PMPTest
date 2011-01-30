package ru.alunev.android.pmptest.activity;

import ru.alunev.android.pmptest.R;
import ru.alunev.android.pmptest.ds.QuestionsDAO;
import ru.alunev.android.pmptest.ds.QuestionsOpenHelper;
import ru.alunev.android.pmptest.info.AtivityIntents;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActiviy extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // init DB
        QuestionsOpenHelper oh = new QuestionsOpenHelper(this);
        oh.createDatabase();
        QuestionsDAO.init(getApplicationContext());

        final Button startButton = (Button) findViewById(R.id.startButton);

        startButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // launch main screen(feeds list view)
                Intent startStart = new Intent(AtivityIntents.questionIntent);
                startActivity(startStart);
            }
        });
    }
}