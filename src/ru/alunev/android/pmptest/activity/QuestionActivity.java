package ru.alunev.android.pmptest.activity;

import ru.alunev.android.pmptest.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class QuestionActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

        final Button nextButton = (Button) findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // update view to show next question

            }
        });
    }
}
