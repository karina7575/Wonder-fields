package org.javaacademy.wonder_field.player;

public class PlayerAnswer {
    private TypeOfAnswer typeOfAnswer;
    private String answerWord;
    private char answerLetter;

    public PlayerAnswer(TypeOfAnswer typeOfAnswer, String answer) {
        this.typeOfAnswer = typeOfAnswer;
        if (typeOfAnswer == TypeOfAnswer.WORD) {
            this.answerWord = answer;
        } else if (typeOfAnswer == TypeOfAnswer.LETTER) {
            this.answerLetter = answer.charAt(0);
        }
    }

    public TypeOfAnswer getTypeOfAnswer() {
        return typeOfAnswer;
    }

    public char getAnswerLetter() {
        return answerLetter;
    }

    public String getAnswerWord() {
        return answerWord;
    }
}
