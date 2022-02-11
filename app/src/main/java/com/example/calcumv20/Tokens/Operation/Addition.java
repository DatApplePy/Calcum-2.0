package com.example.calcumv20.Tokens.Operation;

public class Addition extends Operation {
    @Override
    public int priority() {
        return 1;
    }

    @Override
    public double evaluate(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }
}
