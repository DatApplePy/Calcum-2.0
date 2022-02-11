package com.example.calcumv20.Tokens;

public abstract class Token {
    private TokenType type;

    protected Token(TokenType type) {
        this.type = type;
    }

    public TokenType getType() {
        return type;
    }
}
