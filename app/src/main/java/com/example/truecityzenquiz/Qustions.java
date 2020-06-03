package com.example.truecityzenquiz;

public class Qustions {
    private int anserId;
    private boolean anserTrue;

    public Qustions(int anserId, boolean anserTrue) {
        this.anserId = anserId;
        this.anserTrue = anserTrue;
    }

    public int getAnserId() {
        return anserId;
    }

    public boolean isAnserTrue() {
        return anserTrue;
    }

    public void setAnserId(int anserId) {
        this.anserId = anserId;
    }

    public void setAnserTrue(boolean anserTrue) {
        this.anserTrue = anserTrue;
    }
}
