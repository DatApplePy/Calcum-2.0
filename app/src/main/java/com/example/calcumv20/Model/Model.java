package com.example.calcumv20.Model;

import com.example.calcumv20.Tokens.Token;
import com.example.calcumv20.Util.Evaluator;
import com.example.calcumv20.Util.IncorrectStackContentException;
import com.example.calcumv20.Util.Observable;
import com.example.calcumv20.Util.Observer;
import com.example.calcumv20.Util.ReversePolishNotation;
import com.example.calcumv20.Util.Tokenizer;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Model implements Observable {

    private final ArrayList<Observer> observerList;
    private ArrayList<String> expression;

    public Model() {
        observerList = new ArrayList<>();
        expression = new ArrayList<>();
    }

    public void solve() {
        Tokenizer tokenizer = new Tokenizer();
        ReversePolishNotation rpn = new ReversePolishNotation();
        Evaluator evaluator = new Evaluator();
        String result;
        try {
            ArrayList<Token> res = tokenizer.tokenize(convertArrayListToString(expression));
            res = rpn.convertInfixToPostfix(res);
            result = evaluator.evaluate(res);
            expression = convertStringToArrayList(result);
        } catch (NumberFormatException | ClassCastException |
                EmptyStackException | IncorrectStackContentException e) {
            e.printStackTrace();
            expression.clear();
            expression.add("Syntax error");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            expression.clear();
            expression.add("Math error");
        }
        notifyObservers();
    }

    //IO section
    public void addInput(String data) {
        this.expression.add(data);
        notifyObservers();
    }

    public void deleteLastChar() {
        if(!expression.isEmpty()) {
            expression.remove(expression.size() - 1);
            notifyObservers();
        }
    }

    public void clear() {
        expression.clear();
        notifyObservers();
    }

    public String getOutput() {
        return convertArrayListToString(expression);
    }

    /**
     * Converts ArrayList contains Strings to a contiguous String to
     * send it to the output or pass to the tokenizer.
     */
    private String convertArrayListToString(ArrayList<String> expression) {
        StringBuilder res = new StringBuilder();
        for(String item : expression) {
            res.append(item);
        }
        return res.toString();
    }

    /**
     * Takes the characters of the input String one by one and puts them in an ArrayList
     * as Strings to make it editable for additional advanced calculations.
     */
    private ArrayList<String> convertStringToArrayList(String str) {
        ArrayList<String> res = new ArrayList<>();
        for(Character ch : str.toCharArray()) {
            res.add(ch.toString());
        }
        return res;
    }

    //Observer section
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}


