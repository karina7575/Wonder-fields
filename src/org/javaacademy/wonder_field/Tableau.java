package org.javaacademy.wonder_field;

import java.util.Locale;

public class Tableau {
    private String correctWord;
    private char letter;
    private char[] letterArray;

    public void initTableau (String correctWordFromGame){                        //инициализация табло
        this.correctWord = correctWordFromGame;
        char[] letterArray = new char[correctWord.length()];
        for (char ch: letterArray){
            letterArray[ch] = '_';
        }
    }

    public void openLetter(char letter){                                 //проверка и открытие буквы
        for(int i = 0; i < correctWord.length(); i++) {
            if (letter == correctWord.charAt(i)){
                letterArray[i] = correctWord.charAt(i);
            }
        }
    }

    public void openWord (String word){                                    //проверка и открытие слова целиком
        String wordInUpperCase = word.toUpperCase();
        if(wordInUpperCase.equals(correctWord)) {
            letterArray = correctWord.toCharArray();
        }
        else {
            System.out.println("Неправильный ответ!");
        }
    }

    public boolean hasUnknownLetters(){                                    //проверка остались ли неизвестные буквы
        for(int j = 0; j < letterArray.length; j++) {
            if(letterArray[j] == '_'){
                return true;
            }
        }
        return false;
    }

    public void showtableau (){                                            //отображение в консоли всех букв
        System.out.println(letterArray);
    }

    public boolean wordIsNotEmpty(String word){                             //проверка пустая ли строка со словом
        return !word.isEmpty();
    }

    public boolean letterIsNotEmpty(char letter){                          //проверка пустой ли символ
        return !(letter == '\u0000');

    }

}
