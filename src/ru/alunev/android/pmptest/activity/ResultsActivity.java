package ru.alunev.android.pmptest.activity;

import ru.alunev.android.pmptest.R;
import ru.alunev.android.pmptest.controller.QuizController;
import ru.alunev.android.pmptest.info.Question;
import ru.alunev.android.pmptest.info.Results;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Results res = QuizController.getInstance().getResults();

        TextView tv = (TextView) findViewById(R.id.result_score);
        tv.setText(res.getCorrectQuestions().size() + "/" + res.getAskedQuestions().size());

        int idx = 0;
        for (Question q : res.getAskedQuestions()) {
            addResultLine(q, idx + 1, res.getUserAnswers().get(idx));
            idx++;
        }

        final Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // goto home
                Intent intent = new Intent(getBaseContext(), MainActiviy.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    private void addResultLine(Question q, int idx, int answer) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.results_content);
        TextView textView = new TextView(this);
        textView.setText(q.getId() + "              " + answer
                + "                  " + q.getCorrect());

        ll.addView(textView);
    }
}
