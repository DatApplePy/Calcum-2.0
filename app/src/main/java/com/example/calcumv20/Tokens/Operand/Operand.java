package com.example.calcumv20.Tokens.Operand;

import com.example.calcumv20.Tokens.*;

public class Operand extends Token {
    private float value;

    public Operand(float value) {
        super(TokenType.OPERAND);
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
