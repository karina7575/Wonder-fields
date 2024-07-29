package org.javaacademy.wonder_field;

import java.util.Scanner;

public class Game {
    public static Scanner in = new Scanner(System.in);
    public static final int PLAYERS = 3;
    public static final int ROUNDS = 4;
    public static final int GROUP_ROUNDS = 3;
    public static final int FINAL_ROUND_INDEX = 3;
    private static String [] questionsAndAnswers = new String[8];
    private Tableau tableau;

    public void init () throws InterruptedException {
        System.out.println("Запуск игры \"Поле Чудес\" - подготовка к игре. Вам нужно ввести вопросы и ответы для игры.");
        for(int round = 1;round <= ROUNDS; round++) {
            System.out.println("Введите вопрос #" + round);
            //questionsAndAnswers[round-1] = "Столица Австрии?";
            questionsAndAnswers[round-1] = in.nextLine();
            System.out.println("Введите ответ на вопрос #" + round);
            //questionsAndAnswers[round] = "ВЕНА";
            questionsAndAnswers[round] = in.nextLine().toUpperCase();
            round++;
        }
        System.out.println("Иницализация закончена, игра начнется через 5 секунд");
        Thread.sleep(5000);
        System.out.println("\n".repeat(50));
    }
    private void initTest () throws InterruptedException {
        System.out.println("Запуск игры \"Поле Чудес\" - подготовка к игре. Вам нужно ввести вопросы и ответы для игры.");
        for(int round = 1;round <= ROUNDS; round++) {
            System.out.println("Введите вопрос #" + round);
            questionsAndAnswers[round-1] = "Столица Австрии?";
            System.out.println("Введите ответ на вопрос #" + round);
            questionsAndAnswers[round] = "ВЕНА";
            round++;
        }
        System.out.println("Иницализация закончена, игра начнется через 5 секунд");
        Thread.sleep(5000);
        System.out.println("\n".repeat(50));
    }
}
