package org.javaacademy.wonder_field;

import java.util.Locale;

public class Tableau {
    private String correctWord;
    private char letter;
    private char[] letterArray;

    public void initTableau (String correctWordFromGame){
        this.correctWord = correctWordFromGame;
        char[] letterArray = new char[correctWord.length()];
        for (char ch: letterArray){
            letterArray[ch] = '_';
        }
    }

    /**
     * проверка и открытие буквы
     */
    public void openLetter(char letter){
        for(int i = 0; i < correctWord.length(); i++) {
            if (letter == correctWord.charAt(i)){
                letterArray[i] = correctWord.charAt(i);
            }
        }
    }

    /**
     * проверка и открытие слова целиком
     */
    public void openWord (String word){
        String wordInUpperCase = word.toUpperCase();
        if(wordInUpperCase.equals(correctWord)) {
            letterArray = correctWord.toCharArray();
        }
        else {
            System.out.println("Неправильный ответ!");
        }
    }

    /**
     * проверка остались ли неизвестные буквы
     */
    public boolean hasUnknownLetters(){
        for(int j = 0; j < letterArray.length; j++) {
            if(letterArray[j] == '_'){
                return true;
            }
        }
        return false;
    }

    /**
     * отображение в консоли всех букв
     */
    public void showtableau (){
        System.out.println(letterArray);
    }

    /**
     * проверка пустая ли строка со словом
     */
    private boolean wordIsNotEmpty(String word){
        return !word.isEmpty();
    }

    /**
     * проверка пустой ли символ
     */
    private boolean letterIsNotEmpty(char letter){
        return !(letter == '\u0000');

    }

}
