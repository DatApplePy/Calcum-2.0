package com.example.calcumv20.Tokens.UnaryOperation;

import androidx.annotation.NonNull;

public class Tangent extends UnaryOperation{
    @Override
    public double evaluate(double operand) {
        while (operand > 180) {
            operand -= 180;
        }
        if (operand == 90) throw new ArithmeticException();
        return Math.tan(operand * Math.PI / 180);
    }

    @NonNull
    @Override
    public String toString() {
        return "tan";
    }
}
