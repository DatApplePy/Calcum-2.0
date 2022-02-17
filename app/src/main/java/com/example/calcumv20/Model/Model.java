package com.example.calcumv20.Model;

import android.util.Log;

import com.example.calcumv20.Util.Observable;
import com.example.calcumv20.Util.Observer;

import java.util.ArrayList;

//TODO: business logic
public class Model implements Observable {

    private final ArrayList<Observer> observerList;
    private final ArrayList<String> input; //edited by user actions
    private String output; //sent back to view and used for evaluation

    public Model() {
        observerList = new ArrayList<>();
        input = new ArrayList<>();
        output = "";
    }

    public void evaluate() {
        //TODO: implement this
    }

    //IO section
    public void addInput(String data) {
        this.input.add(data);
        convertArrayListToString();
        notifyObservers();
    }

    public void deleteLastChar() {
        if(!input.isEmpty()) {
            input.remove(input.size() - 1);
            convertArrayListToString();
            notifyObservers();
        }
        Log.d("DeleteFromInput", !input.isEmpty() ? "OK" : "Input is empty");
    }

    public String getOutput() {
        return output;
    }

    private void convertArrayListToString() {
        StringBuilder res = new StringBuilder();
        for(String item : input) {
            res.append(item);
        }
        output = res.toString();
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


