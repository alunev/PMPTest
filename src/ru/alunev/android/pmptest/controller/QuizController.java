package ru.alunev.android.pmptest.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import ru.alunev.android.pmptest.ds.QuestionsDAO;
import ru.alunev.android.pmptest.info.Question;
import ru.alunev.android.pmptest.info.Results;

public class QuizController {
    private static QuizController instance;

    private List<Question> askedQuestions = new ArrayList<Question>();
    private List<Integer> answers = new ArrayList<Integer>();
    private Set<Integer> seenNumbers = new HashSet<Integer>();

    private static int QUESTIONS_IN_QUIZ = 4;

    private QuizController() {
        // TODO Auto-generated constructor stub
    }

    public static QuizController getInstance() {
        if (instance == null) {
            instance = new QuizController();
        }
        return instance;
    }

    public Question getNextQuestion() {
        Question q = null;
        int questionsCout = 0;
        try {
            questionsCout = QuestionsDAO.getInstance().getQuestionsCount();
            q = QuestionsDAO.getInstance().getQuestionById(getNextQuestionNumber(questionsCout));
        } catch (Exception e) {
            e.printStackTrace();
        }
        askedQuestions.add(q);

        return q;
    }

    private int getNextQuestionNumber(int questionsCout) {
        Random random = new Random(System.currentTimeMillis());

        int next;
        while(seenNumbers.contains(next = random.nextInt(questionsCout) + 1)) {
            next = random.nextInt(questionsCout) + 1;
        }
        seenNumbers.add(next);

        return next;
    }

    public void startQuiz() {
        this.askedQuestions.clear();
        this.answers.clear();
        this.seenNumbers.clear();
    }

    public void endQuiz() {
        // maybe we'll do something later here (like writing stats in DB)
    }

    public Results getResults() {
        Results results = new Results();

        // no way to do this other way?
        results.setAskedQuestions((ArrayList<Question>) ((ArrayList<Question>) askedQuestions).clone());
        results.setUserAnswers((ArrayList<Integer>) ((ArrayList<Integer>) answers).clone());

        Set<Question> correctQuestions = new HashSet<Question>();
        int idx = 0;
        for (Question q : askedQuestions) {
            if (answers.get(idx++) == q.getCorrect()) {
                correctQuestions.add(q);
            }
        }
        results.setCorrectQuestions(correctQuestions);

        return results;
    }

    public void submitAnswer(int answerNumber) {
        answers.add(answerNumber);
    }

    public boolean askMoreQuestions() {
        return answers.size() < QUESTIONS_IN_QUIZ;
    }
}
