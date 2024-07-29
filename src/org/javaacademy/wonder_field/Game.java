package org.javaacademy.wonder_field;

import java.util.Scanner;

public class Game {
    public static Scanner in = new Scanner(System.in);
    public static final int PLAYERS = 3;
    public static final int ROUNDS = 4;
    public static final int GROUP_ROUNDS = 3;
    public static final int FINAL_ROUND_INDEX = 3;
    private QuestionsAndAnswers[] questionAndAnswer = new QuestionsAndAnswers[4];
    private Tableau tableau;
    private Yakubovich yakubovich;

    public void init () throws InterruptedException {
        System.out.println("Запуск игры \"Поле Чудес\" - подготовка к игре. Вам нужно ввести вопросы и ответы для игры.");
        for(int round = 1;round <= ROUNDS; round++) {
            System.out.println("Введите вопрос #" + round);
            String question = in.nextLine();
            System.out.println("Введите ответ на вопрос #" + round);
            String answer = in.nextLine().toUpperCase();
            questionAndAnswer[round-1] = new QuestionsAndAnswers(question, answer);
            System.out.println(questionAndAnswer[round-1]);
        }
        System.out.println("Иницализация закончена, игра начнется через 5 секунд");
        Thread.sleep(5000);
        System.out.println("\n".repeat(50));
        yakubovich = new Yakubovich();
    }

    public static int getFINAL_ROUND_INDEX() {
        return FINAL_ROUND_INDEX;
    }

    public String getQuestions(int round) {
       return questionAndAnswer[round].getQuestion();
    }
}
