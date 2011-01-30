package ru.alunev.android.pmptest.info;

import java.util.List;
import java.util.Set;

public class Results {
    private List<Question> askedQuestions;
    private Set<Question> correctQuestions;
    private List<Integer> userAnswers;

    public List<Question> getAskedQuestions() {
        return askedQuestions;
    }
    public void setAskedQuestions(List<Question> askedQuestions) {
        this.askedQuestions = askedQuestions;
    }
    public Set<Question> getCorrectQuestions() {
        return correctQuestions;
    }
    public void setCorrectQuestions(Set<Question> correctQuestions) {
        this.correctQuestions = correctQuestions;
    }
    public List<Integer> getUserAnswers() {
        return userAnswers;
    }
    public void setUserAnswers(List<Integer> userAnswers) {
        this.userAnswers = userAnswers;
    }
}
