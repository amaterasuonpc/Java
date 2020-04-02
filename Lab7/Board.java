package com.company;

public class Board {

    int n;
    int m;
    Token[] tokens;

    public void setN(int n) {
        this.n = n;

    }

    public Board(int n, int m) {
        this.n = n;
        this.m = m;
        tokens= new Token[n];
        for(int i=0;i<n;i++){
            tokens[i]= new Token(m);
        }

    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
}
