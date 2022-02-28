package com.example.calcumv20.Tokens.BinaryOperation;

import androidx.annotation.NonNull;

public class Exponential extends BinaryOperation {
    @Override
    public int priority() {
        return 3;
    }

    @Override
    public double evaluate(double firstOperand, double secondOperand) {
        return Math.pow(firstOperand, secondOperand);
    }

    @NonNull
    @Override
    public String toString() {
        return "^";
    }
}
