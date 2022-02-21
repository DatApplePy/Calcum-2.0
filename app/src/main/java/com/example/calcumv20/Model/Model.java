package com.example.calcumv20.Model;

import com.example.calcumv20.Util.Observable;
import com.example.calcumv20.Util.Observer;

import java.util.ArrayList;

//TODO: business logic
public class Model implements Observable {

    private final ArrayList<Observer> observerList;
    private final ArrayList<String> expression;

    public Model() {
        observerList = new ArrayList<>();
        expression = new ArrayList<>();
    }

    public void evaluate() {
        //TODO: implement this
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

    public String getOutput() {
        return convertArrayListToString();
    }

    private String convertArrayListToString() {
        StringBuilder res = new StringBuilder();
        for(String item : expression) {
            res.append(item);
        }
        return res.toString();
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


