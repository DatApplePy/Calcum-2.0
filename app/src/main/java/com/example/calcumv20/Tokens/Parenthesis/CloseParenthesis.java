package com.example.calcumv20.Tokens.Parenthesis;

import androidx.annotation.NonNull;

import com.example.calcumv20.Tokens.Token;
import com.example.calcumv20.Tokens.TokenType;

public class CloseParenthesis extends Token {

    public CloseParenthesis() {
        super(TokenType.CLOSE);
    }

    @NonNull
    @Override
    public String toString() {
        return ")";
    }
}
