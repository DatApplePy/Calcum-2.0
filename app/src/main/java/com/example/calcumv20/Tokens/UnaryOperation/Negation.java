package com.example.calcumv20.Tokens.UnaryOperation;

import androidx.annotation.NonNull;

public class Negation extends UnaryOperation{
    @Override
    public double evaluate(double operand) {
        return -operand;
    }

    @NonNull
    @Override
    public String toString() {
        return "--";
    }
}
