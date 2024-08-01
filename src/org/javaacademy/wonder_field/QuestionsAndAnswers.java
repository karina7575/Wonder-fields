package org.javaacademy.wonder_field;

public class QuestionsAndAnswers {
    String question;
    String answer;

    public QuestionsAndAnswers(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "QuestionsAndAnswers{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
