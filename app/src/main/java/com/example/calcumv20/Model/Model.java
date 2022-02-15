package com.example.calcumv20.Model;

import com.example.calcumv20.Util.Observable;
import com.example.calcumv20.Util.Observer;

import java.util.ArrayList;

public class Model implements Observable {

    private ArrayList<Observer> observerList;
    private StringBuilder data;

    public Model() {
        observerList = new ArrayList<>();
        data = new StringBuilder();
    }

    public void receiveData(String data) {
        this.data.append(data);
        notifyObservers();
    }

    public String getData() {
        return data.toString();
    }

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

//TODO: better name for methods
//TODO: Business logic
