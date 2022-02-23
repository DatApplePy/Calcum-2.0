package com.example.calcumv20.Util;

import com.example.calcumv20.Tokens.BinaryOperation.*;
import com.example.calcumv20.Tokens.Operand.Operand;
import com.example.calcumv20.Tokens.Parenthesis.*;
import com.example.calcumv20.Tokens.Token;
import com.example.calcumv20.Tokens.TokenType;
import com.example.calcumv20.Tokens.UnaryOperation.*;

import java.util.ArrayList;

public class Tokenizer {
    private final StringBuffer multiCharBuffer;
    private final ArrayList<Token> tokens;

    public Tokenizer() {
        multiCharBuffer = new StringBuffer();
        tokens = new ArrayList<>();
    }

    public ArrayList<Token> tokenize(String infixExpression)
            throws NumberFormatException {
        int end = infixExpression.length();
        char currentChar;
        for (int i = 0; i < end;) {
            currentChar = infixExpression.charAt(i);
            // numbers
            if (isNumber(currentChar)) {
                do {
                    multiCharBuffer.append(infixExpression.charAt(i));
                    i++;
                } while (i < end && isNumber(infixExpression.charAt(i)));
                tokens.add(new Operand(Double.parseDouble(getBuffer())));
                clearBuffer();
            }
            // functions (sin, cos, etc...)
            else if (isLetter(currentChar)) {
                do {
                    multiCharBuffer.append(infixExpression.charAt(i));
                    i++;
                } while (i < end && isLetter(infixExpression.charAt(i)));
                ImpliedMultiplication();
                switch (getBuffer()) {
                    case "sin" : tokens.add(new Sine()); break;
                    case "cos" : tokens.add(new Cosine()); break;
                    case "tan" : tokens.add(new Tangent()); break;
                    case "log" : tokens.add(new Logarithm()); break;
                }
                clearBuffer();
            }
            // parentheses
            else if (isParenthesis(currentChar)) {
                switch (currentChar) {
                    case '(' : {
                        ImpliedMultiplication();
                        tokens.add(new OpenParenthesis());
                        break;
                    }
                    case ')' : tokens.add(new CloseParenthesis()); break;
                }
                i++;
            }
            // operations (+, -, etc...)
            else if (isOperation(currentChar)) {
                switch (currentChar) {
                    case '+': tokens.add(new Addition()); break;
                    case '-': {
                        if (tokens.isEmpty() || (!lastToken().getType().equals(TokenType.CLOSE) &&
                                !lastToken().getType().equals(TokenType.OPERAND))) {
                            tokens.add(new Negation());
                        } else {
                            tokens.add(new Subtraction());
                        }
                        break;
                    }
                    case '×': tokens.add(new Multiplication()); break;
                    case '÷': tokens.add(new Division()); break;
                    case '^': tokens.add(new Exponention()); break;
                    case '\u221A': {
                        ImpliedMultiplication();
                        tokens.add(new SquareRoot());
                        break;
                    }
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

    private Token lastToken() {
        return tokens.get(tokens.size()-1);
    }

    private void ImpliedMultiplication() {
        if(!tokens.isEmpty() && (lastToken().getType().equals(TokenType.OPERAND) ||
                lastToken().getType().equals(TokenType.CLOSE))) {
            tokens.add(new Multiplication());
        }
    }
}
