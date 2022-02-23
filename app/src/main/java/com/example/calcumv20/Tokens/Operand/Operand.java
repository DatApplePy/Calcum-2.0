package com.example.calcumv20.Tokens.Operand;

import androidx.annotation.NonNull;

import com.example.calcumv20.Tokens.*;

public class Operand extends Token {
    private double value;

    public Operand(double value) {
        super(TokenType.OPERAND);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @NonNull
    @Override
    public String toString() {
        return Double.toString(value);
    }
}
