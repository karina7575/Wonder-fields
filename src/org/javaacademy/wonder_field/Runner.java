package org.javaacademy.wonder_field;

import org.javaacademy.wonder_field.player.Player;

import java.util.Scanner;

import static org.javaacademy.wonder_field.Game.in;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        Game game1 = new Game();
        game1.initTest();
        game1.start();

    }
}
