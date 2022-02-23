package com.example.calcumv20.Tokens.UnaryOperation;

import androidx.annotation.NonNull;

public class Logarithm extends UnaryOperation {
    @Override
    public double evaluate(double operand) {
        return Math.log10(operand);
    }

    @NonNull
    @Override
    public String toString() {
        return "log";
    }
}
