package org.example;
import java.util.ArrayList;
import java.util.List;

enum RomanNumber {
    I(1), IV(4), V(5), IX(9),
    X(10),XL(40), L(50), XC(90), C(100);
    private int value;

    RomanNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<RomanNumber> getValuesBackwards() {
        List<RomanNumber> list = new ArrayList<>();
        list.add(RomanNumber.C);
        list.add(RomanNumber.XC);
        list.add(RomanNumber.L);
        list.add(RomanNumber.XL);
        list.add(RomanNumber.X);
        list.add(RomanNumber.IX);
        list.add(RomanNumber.V);
        list.add(RomanNumber.IV);
        list.add(RomanNumber.I);
        return list;
    }
}