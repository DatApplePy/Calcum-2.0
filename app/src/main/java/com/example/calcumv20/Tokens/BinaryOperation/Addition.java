package com.example.calcumv20.Tokens.BinaryOperation;

import androidx.annotation.NonNull;

public class Addition extends BinaryOperation {
    @Override
    public int priority() {
        return 1;
    }

    @Override
    public double evaluate(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    @NonNull
    @Override
    public String toString() {
        return "+";
    }
}
