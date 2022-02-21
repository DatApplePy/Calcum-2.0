package com.example.calcumv20.Tokens.UnaryOperation;

import androidx.annotation.NonNull;

public class Tangent extends UnaryOperation{
    @Override
    double evaluate(double operand) {
        return Math.tan(operand);
    }

    @NonNull
    @Override
    public String toString() {
        return "tan";
    }
}
