package com.example.calcumv20.Tokens.Operation;

public class Exponention extends Operation{
    @Override
    public int priority() {
        return 3;
    }

    @Override
    public double evaluate(double firstOperand, double secondOperand) {
        return Math.pow(firstOperand, secondOperand);
    }
}
