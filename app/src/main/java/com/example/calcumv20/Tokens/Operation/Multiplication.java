package com.example.calcumv20.Tokens.Operation;

public class Multiplication extends Operation{
    @Override
    public int priority() {
        return 2;
    }

    @Override
    public double evaluate(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }
}
