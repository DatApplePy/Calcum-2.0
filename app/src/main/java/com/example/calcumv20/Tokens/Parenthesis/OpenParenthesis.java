package com.example.calcumv20.Tokens.Parenthesis;

import androidx.annotation.NonNull;

import com.example.calcumv20.Tokens.Token;
import com.example.calcumv20.Tokens.TokenType;

public class OpenParenthesis extends Token {

    public OpenParenthesis() {
        super(TokenType.OPEN);
    }

    @NonNull
    @Override
    public String toString() {
        return "(";
    }
}
