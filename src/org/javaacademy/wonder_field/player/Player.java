package org.javaacademy.wonder_field.player;

import org.javaacademy.wonder_field.Game;

public class Player {
    private String name;
    private String city;
    private PlayerAnswer playerAnswer;

    /**
     * игрок умеет кричать букву
     */
    public void shoutTheLetter(){
        String answer = Game.in.nextLine();
        if(answer.length() == 1) {
            playerAnswer = new PlayerAnswer(TypeOfAnswer.LETTER, answer);
        }
        else System.out.println("Некорректное значение! Введите букву");
    }

    /**
     * игрок умеет кричать слово целиком
     */
    public void shoutTheWord(){
        String answer = Game.in.nextLine();
        playerAnswer = new PlayerAnswer(TypeOfAnswer.WORD, answer);
    }

    /**
     * игрок умеет делать ход
     */
    public void move (){
        System.out.println("Ход игрока " + this.name + " из " + this.city);
        System.out.println("Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'c' и enter");
        char choice = Game.in.next().charAt(0);
        if(choice == 'б'){
            this.shoutTheLetter();
        }
        else if (choice == 'с'){
            this.shoutTheWord();
        }
        else System.out.println("Некорректное значение, введите 'б' или 'с'");
    }

    public String getName() {
        return name;
    }
}
