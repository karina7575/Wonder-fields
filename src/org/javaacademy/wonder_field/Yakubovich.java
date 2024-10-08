package org.javaacademy.wonder_field;

import org.javaacademy.wonder_field.player.Player;
import org.javaacademy.wonder_field.player.PlayerAnswer;
import org.javaacademy.wonder_field.player.TypeOfAnswer;


public class Yakubovich {
    public void greeting() {
        System.out.println("Якубович: Здравствуйте, уважаемые дамы и господа! Пятница! В эфире капитал-шоу «Поле чудес»!");
    }

    public void parting() {
        System.out.println("Якубович: Мы прощаемся с вами ровно на одну неделю! Здоровья вам, до встречи!");
    }

    /**
     * приглашает тройку игроков
     */
    public void welcome3players(Player player1, Player player2, Player player3, int numberOfRound) {
        if (numberOfRound < Game.getFINAL_ROUND_INDEX()) {
            System.out.println("Якубович: приглашаю (номер тройки) тройку игроков: " + player1.getName() + ", " + player2.getName() + ", " + player3.getName());
        } else {
            System.out.println("Якубович: приглашаю победителей групповых этапов: " + player1.getName() + ", " + player2.getName() + ", " + player3.getName());
        }
    }

    /**
     * задает вопрос игрокам
     */
    public void askPlayers(String question) {
        System.out.println("Якубович: Внимание, вопрос!");
        System.out.println(question);
    }

    /**
     * кричит о победе
     */
    public void shoutToWinner(String name, String city, boolean finalRound, Player player) {
        if (finalRound) {
            System.out.println("Якубович: Молодец! " + name + " из " + city + " проходит в финал!");
        } else {
            System.out.println("Якубович: И перед нами победитель Капитал шоу поле чудес! Это " + name + " из города " + city + ". Количество очков: " + player.getPoints());
        }
    }

    public boolean checkPlayerAnswer(PlayerAnswer playerAnswer, Tableau tableau) {
        boolean right = false;
        try {
            if (playerAnswer.getTypeOfAnswer() == TypeOfAnswer.LETTER) {
                if (tableau.openLetter(playerAnswer.getAnswerLetter())) {
                    System.out.println("Якубович: Есть такая буква, откройте ее!");
                    tableau.showtableau();
                    right = true;

                } else {
                    System.out.println("Якубович: Нет такой буквы! Следующий игрок, крутите барабан!");
                }
                System.out.println("__________________________________");
            } else if (playerAnswer.getTypeOfAnswer() == TypeOfAnswer.WORD) {
                if (tableau.openWord(playerAnswer.getAnswerWord())) {
                    System.out.println("Якубович: " + playerAnswer.getAnswerWord() + "! Абсолютно верно!");
                    tableau.showtableau();
                    right = true;
                } else {
                    System.out.println("Якубович: Неверно! Следующий игрок!");
                }
                System.out.println("__________________________________");
            }
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }

        return right;
    }
}
