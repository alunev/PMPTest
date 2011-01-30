package ru.alunev.android.pmptest.activity;

import ru.alunev.android.pmptest.R;
import ru.alunev.android.pmptest.controller.QuizController;
import ru.alunev.android.pmptest.info.Question;
import android.app.Activity;
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

        QuizController.getInstance().startQuiz();
        populateView();

        final Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (QuizController.getInstance().askMoreQuestions()) {
                    // update view to show next question
                    captureAnswer();
                    populateView();
                } else {
                    // goto result screen

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
    }

    private void captureAnswer() {
        QuizController qc = QuizController.getInstance();
        RadioGroup answers = (RadioGroup) findViewById(R.id.answer_variants);

        if (R.id.answer1 == answers.getCheckedRadioButtonId()) {
            qc.submitAnswer(1);
        } else if (R.id.answer2 == answers.getCheckedRadioButtonId()) {
            qc.submitAnswer(2);
        } else if (R.id.answer3 == answers.getCheckedRadioButtonId()) {
            qc.submitAnswer(3);
        } else if (R.id.answer4 == answers.getCheckedRadioButtonId()) {
            qc.submitAnswer(4);
        }

        answers.clearCheck();
    }
}
