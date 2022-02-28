package com.example.calcumv20.Util;

import com.example.calcumv20.Tokens.Operand.Operand;
import com.example.calcumv20.Tokens.*;

import java.util.ArrayList;

public class Tokenizer {
    private final StringBuffer multiCharBuffer;
    private final ArrayList<Token> tokens;
    private final OperationContainer container;

    public Tokenizer() {
        multiCharBuffer = new StringBuffer();
        tokens = new ArrayList<>();
        container = new OperationContainer();
    }

    public ArrayList<Token> tokenize(String infixExpression) {
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
            // constants
            else if (isConstant(currentChar)) {
                impliedMultiplication();
                switch (currentChar) {
                    case 'π': tokens.add(new Operand(Math.PI)); break;
                    case 'e': tokens.add(new Operand(Math.E)); break;
                }
                i++;
            }
            // functions (sin, cos, etc...)
            else if (isLetter(currentChar)) {
                do {
                    multiCharBuffer.append(infixExpression.charAt(i));
                    i++;
                } while (i < end && isLetter(infixExpression.charAt(i)));
                impliedMultiplication();
                tokens.add(container.getToken(getBuffer()));
                clearBuffer();
            }
            // parentheses
            else if (isParenthesis(currentChar)) {
                if (currentChar == '(') {
                    impliedMultiplication();
                }
                tokens.add(container.getToken(currentChar));
                i++;
            }
            // operations (+, -, etc...)
            else if (isOperation(currentChar)) {
                switch (currentChar) {
                    case '-': {
                        if (tokens.isEmpty() || (!lastToken().getType().equals(TokenType.CLOSE) &&
                                !lastToken().getType().equals(TokenType.OPERAND))) {
                            tokens.add(container.getToken("neg"));
                        } else {
                            tokens.add(container.getToken(currentChar));
                        }
                        break;
                    }
                    case '√': {
                        impliedMultiplication();
                        tokens.add(container.getToken(currentChar));
                        break;
                    }
                    default: tokens.add(container.getToken(currentChar)); break;
                }
                i++;
            }
        }
        return tokens;
    }

    private boolean isNumber(char ch) {
        return Character.isDigit(ch) || ch == '.';
    }

    private boolean isConstant(char ch) { return Character.toString(ch).matches("[πe]"); }

    private boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

    private boolean isParenthesis(char ch) {
        return Character.toString(ch).matches("[()]");
    }

    private boolean isOperation(char ch) {
        return Character.toString(ch).matches("[+\\-×÷^√]");
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

    private void impliedMultiplication() {
        if(!tokens.isEmpty() && (lastToken().getType().equals(TokenType.OPERAND) ||
                lastToken().getType().equals(TokenType.CLOSE))) {
            tokens.add(container.getToken('×'));
        }
    }
}
