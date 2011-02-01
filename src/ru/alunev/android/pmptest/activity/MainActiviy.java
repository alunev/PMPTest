package ru.alunev.android.pmptest.activity;

import ru.alunev.android.pmptest.R;
import ru.alunev.android.pmptest.ds.QuestionsDAO;
import ru.alunev.android.pmptest.ds.QuestionsOpenHelper;
import ru.alunev.android.pmptest.info.AtivityIntents;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.settings:
            // show settings
            return true;
        case R.id.about:
            //showAbout();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}