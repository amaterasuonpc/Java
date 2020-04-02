package com.company;

public class Game {
    int m;
    int n;


    Board board= new Board(n,m);

    public Game(int m, int n) {
        this.m = m;
        this.n = n;
    }
   
}
