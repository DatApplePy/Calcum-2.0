package com.example.calcumv20.Tokens.UnaryOperation;

import androidx.annotation.NonNull;

public class SquareRoot extends UnaryOperation{
    @Override
    double evaluate(double operand) {
        return Math.sqrt(operand);
    }

    @NonNull
    @Override
    public String toString() {
        return "\u221A";
    }
}
