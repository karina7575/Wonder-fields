package org.javaacademy.wonder_field;

public class Game {
    public final int PLAYERS = 3;
    public final int ROUNDS = 4;
    public final int GROUP_ROUNDS = 3;
    public static final int FINAL_ROUND_INDEX = 3;
    private static String [] questionsAndAnswers = new String[8];

    public void init () throws InterruptedException {
        int round = 1;
        System.out.println("Запуск игры \"Поле Чудес\" - подготовка к игре. Вам нужно ввести вопросы и ответы для игры.");
        while(round <= ROUNDS) {
            System.out.println("Введите вопрос #" + round);
            //questionsAndAnswers[round-1] = "Столица Австрии?";
            questionsAndAnswers[round-1] = Runner.in.nextLine();
            System.out.println("Введите ответ на вопрос #" + round);
            //questionsAndAnswers[round] = "ВЕНА";
            questionsAndAnswers[round] = Runner.in.nextLine().toUpperCase();
            round++;
        }
        System.out.println("Иницализация закончена, игра начнется через 5 секунд");
        Thread.sleep(5000);
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
    }
}
