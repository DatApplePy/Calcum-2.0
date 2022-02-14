package com.example.calcumv20;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFunctions extends Fragment {

    private OnButtonPass buttonPasser;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPasser = (OnButtonPass) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_functions, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}

//TODO: initialize buttons
//TODO: make buttons working
//of course properly :P