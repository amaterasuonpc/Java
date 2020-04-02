package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {

    List<Token> tokenList= new ArrayList<>();
    Board board;
    String name;
    Random rand = new Random();
    public Player(Board board, String name) {
        this.board = board;
        this.name=name;
    }

    @Override
    public void run() {
        int temp = rand.nextInt(board.getN());






    }
}
