package com.example.calcumv20.Tokens.UnaryOperation;

import androidx.annotation.NonNull;

public class Sine extends UnaryOperation {
    @Override
    public double evaluate(double operand) {
        return Math.sin(operand * Math.PI / 180);
    }

    @NonNull
    @Override
    public String toString() {
        return "sin";
    }
}
