package com.example.calcumv20.Model;

import android.util.Log;

import com.example.calcumv20.Util.Observable;
import com.example.calcumv20.Util.Observer;

import java.util.ArrayList;

//TODO: business logic
//TODO: rebuild data structure
public class Model implements Observable {

    private final ArrayList<Observer> observerList;
    private final StringBuffer data;

    public Model() {
        observerList = new ArrayList<>();
        data = new StringBuffer();
    }

    public void putData(String data) {
        this.data.append(data);
        notifyObservers();
    }

    public String getData() {
        return data.toString();
    }

    public void deleteLastChar() {
        if(data.length() > 0) {
            data.deleteCharAt(data.length() - 1);
            notifyObservers();
        } else {
            Log.d("IndexOutOfBound","StringBuffer is empty");
        }
    }

    public void evaluate() {
        //TODO: implement this
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


