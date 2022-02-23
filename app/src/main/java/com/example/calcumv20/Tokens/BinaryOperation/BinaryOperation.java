package com.example.calcumv20.Tokens.BinaryOperation;

import com.example.calcumv20.Tokens.Token;
import com.example.calcumv20.Tokens.TokenType;

public abstract class BinaryOperation extends Token {
    protected BinaryOperation() {
        super(TokenType.BINARY_OPERATION);
    }

    public abstract int priority();
    public abstract double evaluate(double firstOperand, double secondOperand);
}
