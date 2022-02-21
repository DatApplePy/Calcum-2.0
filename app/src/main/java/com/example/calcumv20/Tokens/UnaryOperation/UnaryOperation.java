package com.example.calcumv20.Tokens.UnaryOperation;

import com.example.calcumv20.Tokens.Token;
import com.example.calcumv20.Tokens.TokenType;

public abstract class UnaryOperation extends Token {

    protected UnaryOperation() {
        super(TokenType.UNARY_OPERATION);
    }

    abstract double evaluate(double operand);
}
