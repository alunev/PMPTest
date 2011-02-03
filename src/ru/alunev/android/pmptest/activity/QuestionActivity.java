package ru.alunev.android.pmptest.activity;

import ru.alunev.android.pmptest.R;
import ru.alunev.android.pmptest.controller.QuizController;
import ru.alunev.android.pmptest.info.AtivityIntents;
import ru.alunev.android.pmptest.info.Question;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

        QuizController.getInstance().startQuiz(getBaseContext());
        populateView();

        final Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                captureAnswer();
                if (QuizController.getInstance().askMoreQuestions()) {
                    // update view to show next question
                    populateView();
                } else {
                    // goto result screen
                    Intent resStart = new Intent(AtivityIntents.resultsIntent);
                    startActivity(resStart);
                }
            }
        });
    }

    private void populateView() {
        Question q = QuizController.getInstance().getNextQuestion();

        // fill elements with info
        TextView question = (TextView) findViewById(R.id.question_content);
        question.setText(q.getQuestion());

        RadioGroup answers = (RadioGroup) findViewById(R.id.answer_variants);
        RadioButton answer = (RadioButton) answers.getChildAt(0);
        answer.setText(q.getAns1());

        answer = (RadioButton) answers.getChildAt(1);
        answer.setText(q.getAns2());

        answer = (RadioButton) answers.getChildAt(2);
        answer.setText(q.getAns3());

        answer = (RadioButton) answers.getChildAt(3);
        answer.setText(q.getAns4());

        answers.clearCheck();
    }

    private void captureAnswer() {
        QuizController qc = QuizController.getInstance();
        RadioGroup answers = (RadioGroup) findViewById(R.id.answer_variants);

        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer1:
                qc.submitAnswer(1);
                break;
            case R.id.answer2:
                qc.submitAnswer(2);
                break;
            case R.id.answer3:
                qc.submitAnswer(3);
                break;
            case R.id.answer4:
                qc.submitAnswer(4);
                break;
            default:
                qc.submitAnswer(0);
                break;
        }
    }
}
