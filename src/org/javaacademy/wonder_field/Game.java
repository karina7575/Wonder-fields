package org.javaacademy.wonder_field;

import org.javaacademy.wonder_field.player.Player;
import org.javaacademy.wonder_field.player.PlayerAnswer;
import org.javaacademy.wonder_field.player.TypeOfAnswer;

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
    private Player[] winners = new Player[PLAYERS];
    private Player[] playersForRound = new Player[PLAYERS];

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

    public void initTest () throws InterruptedException {
        String[] questions = new String[4];
        questions[0] = "Столица России";
        questions[1] = "Что делает собака";
        questions[2] = "Как зовут Бузову";
        questions[3] = "Сколько колес у машины";
        String[] answers = new String[4];
        answers[0] = "Москва";
        answers[1] = "гавкает";
        answers[2] = "Ольга";
        answers[3] = "четыре";
        System.out.println("Запуск игры \"Поле Чудес\" - подготовка к игре. Вам нужно ввести вопросы и ответы для игры.");
        for(int round = 1 ;round <= ROUNDS; round++) {
            System.out.println("Введите вопрос #" + round);
            String question = questions[round - 1];
            System.out.println("Введите ответ на вопрос #" + round);
            String answer = answers[round - 1].toUpperCase();
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

    /**
     * создание игроков
     */
    public Player[] createPlayers (){
        for (int i = 1; i < 4; i++) {
            System.out.println("Игрок №" + (i) + "представьтесь: имя,город. Например: Иван,Москва");
            String arrayLocal[] = in.nextLine().split(",");
            playersForRound[i - 1] = new Player(arrayLocal[0].trim(), arrayLocal[1].trim());
        }
        return playersForRound;
    }
    public Player[] createPlayersTest (){
        playersForRound[0] = new Player ("Василий", "Вологда");
        playersForRound[1] = new Player ("Ольга", "Москва");
        playersForRound[2] = new Player ("Клавдия", "Саратов");
        return playersForRound;
    }

    /**
     * проверка заполнено ли табло
     */
    public boolean isTableauFull (Tableau tableau){
        if (tableau.hasUnknownLetters()) {
            return false;
        }
        else return true;
    }

    /**
     * ход игрока
     */
    public boolean playerStep (Player player, String question) {
        System.out.println("Будете говорить букву или слово целиком? Введите 1 - букву, 2 - слово");
        int flag = in.nextInt();
        in.nextLine();
        if (flag == 1) {
            System.out.println("Введите букву");
            String letter = in.nextLine().toUpperCase();
            PlayerAnswer answer = new PlayerAnswer(TypeOfAnswer.LETTER, letter);
            yakubovich.checkPlayerAnswer(answer, tableau);
        }
        else if (flag == 2) {
            System.out.println("Введите слово");
            String word = in.nextLine();
            PlayerAnswer answer = new PlayerAnswer(TypeOfAnswer.WORD, word);
            yakubovich.checkPlayerAnswer(answer, tableau);
        }
        else {
            System.out.println("Некорректное значение");
        }
        if (isTableauFull(tableau)) {
            return true;
        }
        else return false;
    }
    /**
     * сыграть раунд
     */
    public void playRound (int round, Player playerForRound1, Player playerForRound2, Player playerForRound3, String questionAngAnswerForRound) {
        boolean win, finalRound;
        int numberOfPlayer;
        while (true) {
            win = playerStep(playerForRound1, questionAngAnswerForRound);
            numberOfPlayer = 1;
            if (win == true) {
                break;
            }
            win = playerStep(playerForRound2, questionAngAnswerForRound);
            numberOfPlayer = 2;
            if (win == true) {
                break;
            }
            win = playerStep(playerForRound3, questionAngAnswerForRound);
            numberOfPlayer = 3;
            if (win == true) {
                break;
            }
        }
        if(round < FINAL_ROUND_INDEX + 1) {
            winners[round - 1] = playersForRound[numberOfPlayer - 1];
            finalRound = true;
        }
        else {
            finalRound = false;
        }
        yakubovich.shoutToWinner(playersForRound[numberOfPlayer - 1].getName(), playersForRound[numberOfPlayer - 1].getCity(), finalRound);
    }

    /**
     * сыграть все групповые раунды
     */
    public void playAllGroupRounds () {
        for (int round = 1; round < 4; round++) {
            createPlayersTest();
            tableau = new Tableau(questionAndAnswer[round - 1].getAnswer());
            yakubovich.welcome3players(playersForRound[0], playersForRound[1], playersForRound[2], round);
            yakubovich.askPlayers(questionAndAnswer[round - 1].getQuestion());
            tableau.initTableau(questionAndAnswer[round - 1].getAnswer());
            playRound(round, playersForRound[0], playersForRound[1], playersForRound[2], questionAndAnswer[round - 1].getQuestion());
        }
    }

    /**
     * сыграть финальный раунд
     */
    public void playFinalRound () {
        //tableau.initTableau(questionAndAnswer[FINAL_ROUND_INDEX].getAnswer());
        yakubovich.welcome3players(winners[0], winners[1], winners[2], FINAL_ROUND_INDEX);
        yakubovich.askPlayers(questionAndAnswer[FINAL_ROUND_INDEX].getQuestion());
        tableau.initTableau(questionAndAnswer[FINAL_ROUND_INDEX].getAnswer());
        playRound(FINAL_ROUND_INDEX + 1, winners[0], winners[1], winners[2], questionAndAnswer[FINAL_ROUND_INDEX].getQuestion());
    }

    /**
     * сыграть финальный раунд
     */
    public void start () {
        yakubovich.greeting();
        playAllGroupRounds();
        playFinalRound();
        yakubovich.parting();
    }
}
