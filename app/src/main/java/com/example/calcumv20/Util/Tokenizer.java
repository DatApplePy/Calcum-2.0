package com.example.calcumv20.Util;

import com.example.calcumv20.Tokens.BinaryOperation.*;
import com.example.calcumv20.Tokens.Operand.Operand;
import com.example.calcumv20.Tokens.Parenthesis.*;
import com.example.calcumv20.Tokens.Token;
import com.example.calcumv20.Tokens.UnaryOperation.*;

import java.util.ArrayList;

public class Tokenizer {
    private final StringBuffer multiCharBuffer;
    private final ArrayList<Token> tokens;

    public Tokenizer() {
        multiCharBuffer = new StringBuffer();
        tokens = new ArrayList<>();
    }

    public ArrayList<Token> tokenize(String arithmeticExpression) {
        int i = 0;
        int end = arithmeticExpression.length();
        char currentChar;
        while (i < end) {
            currentChar = arithmeticExpression.charAt(i);
            if(isNumber(currentChar)) {
                do {
                    multiCharBuffer.append(arithmeticExpression.charAt(i));
                    i++;
                } while(i < end && isNumber(arithmeticExpression.charAt(i)));
                tokens.add(new Operand(Float.parseFloat(getBuffer())));
                clearBuffer();
            } else if(isLetter(currentChar)) {
                do {
                    multiCharBuffer.append(arithmeticExpression.charAt(i));
                    i++;
                } while(i < end && isLetter(arithmeticExpression.charAt(i)));
                switch (getBuffer()) {
                    case "sin" : tokens.add(new Sine()); break;
                    case "cos" : tokens.add(new Cosine()); break;
                    case "tan" : tokens.add(new Tangent()); break;
                    case "log" : tokens.add(new Logarithm()); break;
                }
                clearBuffer();
            } else if(isParenthesis(currentChar)) {
                switch(currentChar) {
                    case '(' : tokens.add(new OpenParenthesis()); break;
                    case ')' : tokens.add(new CloseParenthesis()); break;
                }
                i++;
            } else if(isOperation(currentChar)) {
                switch(currentChar) {
                    case '+' : tokens.add(new Addition()); break;
                    case '-' : tokens.add(new Subtraction()); break;
                    case '×' : tokens.add(new Multiplication()); break;
                    case '÷' : tokens.add(new Division()); break;
                    case '^' : tokens.add(new Exponention()); break;
                    case '\u221A' : tokens.add(new SquareRoot()); break;
                }
                i++;
            }
        }
        return tokens;
    }

    private boolean isNumber(char ch) {
        return Character.isDigit(ch) || ch == '.';
    }
    private boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }
    private boolean isParenthesis(char ch) {
        return Character.toString(ch).matches("[()]");
    }
    private boolean isOperation(char ch) {
        return Character.toString(ch).matches("[+\\-×÷^\u221A]");
    }
    private String getBuffer() {
        return multiCharBuffer.toString();
    }
    private void clearBuffer() {
        multiCharBuffer.delete(0, multiCharBuffer.length());
    }
}
