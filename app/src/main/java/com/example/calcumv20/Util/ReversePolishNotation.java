package com.example.calcumv20.Util;

import com.example.calcumv20.Tokens.*;
import com.example.calcumv20.Tokens.BinaryOperation.BinaryOperation;

import java.util.ArrayList;
import java.util.Stack;

public class ReversePolishNotation {
    private final Stack<Token> operations;
    private final ArrayList<Token> postfixExpression;

    public ReversePolishNotation() {
        operations = new Stack<>();
        postfixExpression = new ArrayList<>();
    }

    public ArrayList<Token> convertInfixToPostfix(ArrayList<Token> tokenizedInfixExpression) {
        tokenizedInfixExpression.forEach((t) -> {
            switch (t.getType()) {
                case OPERAND: postfixExpression.add(t); break;
                case BINARY_OPERATION: {
                    while (!operations.empty() && !operations.peek().getType().equals(TokenType.OPEN) &&
                            (operations.peek().getType().equals(TokenType.UNARY_OPERATION) ||
                                    ((BinaryOperation)operations.peek()).priority() >= ((BinaryOperation)t).priority())) {
                        postfixExpression.add(operations.pop());
                    }
                    operations.push(t);
                    break;
                }
                case UNARY_OPERATION:
                case OPEN: operations.push(t); break;
                case CLOSE: {
                    while (!operations.empty() && !operations.peek().getType().equals(TokenType.OPEN)) {
                        postfixExpression.add(operations.pop());
                    }
                    operations.pop();
                    if(!operations.empty() && operations.peek().getType().equals(TokenType.UNARY_OPERATION)) {
                        postfixExpression.add(operations.pop());
                    }
                    break;
                }
            }
        });
        while (!operations.empty()) {
            postfixExpression.add(operations.pop());
        }
        return postfixExpression;
    }
}
