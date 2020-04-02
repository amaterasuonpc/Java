package com.company;

import java.util.Random;

public class Token {

    Random rand = new Random();
    int m;
    int value;

    public void setM(int m) {
        this.m = m;
    }

    public Token(int m) {
        this.m = m;
        value=rand.nextInt(m);
    }
}
