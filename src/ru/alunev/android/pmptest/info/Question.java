package ru.alunev.android.pmptest.info;

public class Question {
    int id;
    String question;
    String ans1;
    String ans2;
    String ans3;
    String ans4;
    int correct;
    String just;
    int pg_id;
    int ka_id;

    public Question(int id, String question, String ans1, String ans2,
            String ans3, String ans4, int correct, String just, int pgId,
            int kaId) {
        this.id = id;
        this.question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.correct = correct;
        this.just = just;
        this.pg_id = pgId;
        this.ka_id = kaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public String getJust() {
        return just;
    }

    public void setJust(String just) {
        this.just = just;
    }

    public int getPg_id() {
        return pg_id;
    }

    public void setPg_id(int pgId) {
        pg_id = pgId;
    }

    public int getKa_id() {
        return ka_id;
    }

    public void setKa_id(int kaId) {
        ka_id = kaId;
    }

    @Override
    public String toString() {
        return "Question [ans1=" + ans1 + ", ans2=" + ans2 + ", ans3=" + ans3
                + ", ans4=" + ans4 + ", correct=" + correct + ", id=" + id
                + ", just=" + just + ", ka_id=" + ka_id + ", pg_id=" + pg_id
                + ", question=" + question + "]";
    }
}
