package com.example.calcumv20.Tokens.UnaryOperation;

import androidx.annotation.NonNull;

public class Cosine extends UnaryOperation {
    @Override
    double evaluate(double operand) {
        return Math.cos(operand);
    }

    @NonNull
    @Override
    public String toString() {
        return "cos";
    }
}
