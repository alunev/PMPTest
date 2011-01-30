package ru.alunev.android.pmptest.activity;

import ru.alunev.android.pmptest.R;
import ru.alunev.android.pmptest.controller.QuizController;
import ru.alunev.android.pmptest.info.Question;
import ru.alunev.android.pmptest.info.Results;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class ResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        int idx = 0;
        Results res = QuizController.getInstance().getResults();
        for (Question q : res.getAskedQuestions()) {
            addResultLine(q, res.getUserAnswers().get(idx++));
        }
    }

    private void addResultLine(Question q, int answer) {
        ScrollView resTable = (ScrollView) findViewById(R.id.results_table);
        TextView textView = new TextView(this);
        textView.setText("1        " + answer + "        " + q.getCorrect());

        resTable.addView(textView);
    }
}
