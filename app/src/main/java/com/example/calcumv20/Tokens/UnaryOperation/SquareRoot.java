package com.example.calcumv20.Tokens.UnaryOperation;

import androidx.annotation.NonNull;

public class SquareRoot extends UnaryOperation{
    @Override
    public double evaluate(double operand) {
        if(operand < 0) throw new ArithmeticException();
        return Math.sqrt(operand);
    }

    @NonNull
    @Override
    public String toString() {
        return "\u221A";
    }
}
