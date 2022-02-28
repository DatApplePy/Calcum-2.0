package com.example.calcumv20.Util;

import com.example.calcumv20.Tokens.BinaryOperation.*;
import com.example.calcumv20.Tokens.Parenthesis.*;
import com.example.calcumv20.Tokens.UnaryOperation.*;
import com.example.calcumv20.Tokens.Token;

import java.util.HashMap;

public class OperationContainer {
    private final HashMap<String, Token> operations;

    public OperationContainer() {
        operations = new HashMap<>();
        operations.put("(", new OpenParenthesis());
        operations.put(")", new CloseParenthesis());
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("×", new Multiplication());
        operations.put("÷", new Division());
        operations.put("^", new Exponential());
        operations.put("√", new SquareRoot());
        operations.put("neg", new Negation());
        operations.put("sin", new Sine());
        operations.put("cos", new Cosine());
        operations.put("tan", new Tangent());
        operations.put("log", new Logarithm());
    }

    public Token getToken(String key) {
        return operations.get(key);
    }
    public Token getToken(Character key) {
        return getToken(Character.toString(key));
    }
}
