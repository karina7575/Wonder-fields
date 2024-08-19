package org.javaacademy.wonder_field;

import java.util.Arrays;
import java.util.Locale;

public class Tableau {
    private String correctWord;
    private char letter;
    private char[] letterArray;

    public Tableau(String correctWord) {
        this.correctWord = correctWord;
    }

    public void initTableau(String correctWordFromGame) {
        this.correctWord = correctWordFromGame;
        letterArray = new char[correctWord.length()];
        for (int i = 0; i < letterArray.length; i++) {
            letterArray[i] = '_';
        }
    }

    /**
     * проверка и открытие буквы
     */
    public boolean openLetter(char letter) {
        boolean flag = false;
        for (int i = 0; i < correctWord.length(); i++) {
            if (letter == correctWord.charAt(i)) {
                letterArray[i] = correctWord.charAt(i);
                flag = true;
            }
        }
        if (flag == true) {
            return true;
        } else return false;
    }

    /**
     * проверка и открытие слова целиком
     */
    public boolean openWord(String word) {
        boolean flagWord = false;
        String wordInUpperCase = word.toUpperCase();
        if (wordInUpperCase.equals(correctWord)) {
            letterArray = correctWord.toCharArray();
            flagWord = true;
        }
        if (flagWord == true) {
            return true;
        } else return false;
    }

    /**
     * проверка остались ли неизвестные буквы
     */
    public boolean hasUnknownLetters() {
        for (int j = 0; j < letterArray.length; j++) {
            if (letterArray[j] == '_') {
                return true;
            }
        }
        return false;
    }

    /**
     * отображение в консоли всех букв
     */
    public void showtableau() {
        System.out.println(letterArray);
    }

    /**
     * проверка пустая ли строка со словом
     */
    private boolean wordIsNotEmpty(String word) {
        return !word.isEmpty();
    }

    /**
     * проверка пустой ли символ
     */
    private boolean letterIsNotEmpty(char letter) {
        return !(letter == '\u0000');

    }

}
