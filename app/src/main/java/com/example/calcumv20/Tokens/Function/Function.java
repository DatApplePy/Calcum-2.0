package com.example.calcumv20.Tokens.Function;

import com.example.calcumv20.Tokens.Token;
import com.example.calcumv20.Tokens.TokenType;

public abstract class Function extends Token {

    protected Function() {
        super(TokenType.FUNCTION);
    }

    abstract double evaluate(double operand);
}
