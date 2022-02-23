package com.example.calcumv20.Util;

import com.example.calcumv20.Tokens.BinaryOperation.BinaryOperation;
import com.example.calcumv20.Tokens.Operand.Operand;
import com.example.calcumv20.Tokens.Token;
import com.example.calcumv20.Tokens.UnaryOperation.UnaryOperation;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Locale;
import java.util.Stack;

public class Evaluator {
    private final Stack<Token> stack;
    private double leftOperand;
    private double rightOperand;
    private double result;

    public Evaluator() {
        stack = new Stack<>();
    }

    public String evaluate(ArrayList<Token> postfixExpression)
            throws EmptyStackException, ArithmeticException {
        postfixExpression.forEach((t) -> {
            switch (t.getType()) {
                case OPERAND: stack.push(t); break;
                case BINARY_OPERATION: {
                    rightOperand = ((Operand)stack.pop()).getValue();
                    leftOperand = ((Operand)stack.pop()).getValue();
                    result = ((BinaryOperation)t).evaluate(leftOperand, rightOperand);
                    stack.push(new Operand(result));
                    break;
                }
                case UNARY_OPERATION: {
                    leftOperand = ((Operand)stack.pop()).getValue();
                    result = ((UnaryOperation)t).evaluate(leftOperand);
                    stack.push(new Operand(result));
                    break;
                }
            }
        });

        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(10);

        return df.format(((Operand)stack.pop()).getValue());
    }
}
