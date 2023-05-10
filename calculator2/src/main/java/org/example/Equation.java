package org.example;

class Equation {
    private final int left;
    private final int right;
    private final char sign;
    public Equation(int left, int right, char sign){
        this.left = left;
        this.right = right;
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
    }
}
