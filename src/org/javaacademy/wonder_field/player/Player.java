package org.javaacademy.wonder_field.player;

import org.javaacademy.wonder_field.Game;

public class Player {
    private String name;
    private String city;
    private PlayerAnswer playerAnswer;
    private int points;

    public Player(String name, String city) {
        this.name = name;
        this.city = city;
        this.points = 0;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public String getCity() {
        return city;
    }

    /**
     * игрок умеет кричать букву
     */
    public String shoutTheLetter() {
        System.out.println("Введите букву: ");
        String answer;
        while (true) {
            answer = Game.in.nextLine().trim().toUpperCase();
            System.out.println("Игрок: " + this.name + " буква " + answer);
            if ((answer.length() == 1) && 1041 < (int) answer.charAt(0) && (int) answer.charAt(0) < 1071) {
                System.out.println("Игрок: " + this.name + " буква " + answer);
                return answer;
            } else {
                System.out.println("Ошибка! это не русская буква, введите русскую букву");
            }
        }
    }

    /**
     * игрок умеет кричать слово целиком
     */
    public String shoutTheWord() {
        System.out.println("Введите слово: ");
        String answer = Game.in.nextLine().toUpperCase();
        return answer;
    }

    /**
     * игрок умеет делать ход
     */
    public PlayerAnswer move() {
        System.out.println("Ход игрока " + this.name + " из " + this.city);
        System.out.println("Если хотите букву, нажмите 'б' и enter, если хотите слово, нажмите 'c' и enter");
        String choice;
        do {
            choice = Game.in.nextLine();
            if (choice.equals("б")) {
                playerAnswer = new PlayerAnswer(TypeOfAnswer.LETTER, this.shoutTheLetter());
            } else if (choice.equals("с")) {
                playerAnswer = new PlayerAnswer(TypeOfAnswer.WORD, this.shoutTheWord());
            } else {
                System.out.println("Некорректное значение, введите 'б' или 'с'");
            }
        } while (!choice.equals("б") && !choice.equals("с"));
        return playerAnswer;
    }

    public String getName() {
        return name;
    }
}
