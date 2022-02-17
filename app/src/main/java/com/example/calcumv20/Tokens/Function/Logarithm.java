package com.example.calcumv20.Tokens.Function;

public class Logarithm extends Function {
    @Override
    double evaluate(double operand) {
        return Math.log10(operand);
    }
}
