package com.example.calcumv20.Tokens.Operation;

import com.example.calcumv20.Tokens.Token;
import com.example.calcumv20.Tokens.TokenType;

public abstract class Operation extends Token {
    protected Operation() {
        super(TokenType.OPERATION);
    }

    abstract int priority();
    abstract double evaluate(double firstOperand, double secondOperand);
}
