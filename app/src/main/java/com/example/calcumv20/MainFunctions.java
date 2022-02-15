package com.example.calcumv20;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.calcumv20.Util.OnButtonPass;

public class MainFunctions extends Fragment {

    private OnButtonPass buttonPasser;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPasser = (OnButtonPass) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_functions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((Button)view.findViewById(R.id.BtnNumber0)).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber0));
        ((Button)view.findViewById(R.id.BtnNumber1)).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber1));
        ((Button)view.findViewById(R.id.BtnNumber2)).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber2));
        ((Button)view.findViewById(R.id.BtnNumber3)).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber3));
        ((Button)view.findViewById(R.id.BtnNumber4)).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber4));
        ((Button)view.findViewById(R.id.BtnNumber5)).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber5));
        ((Button)view.findViewById(R.id.BtnNumber6)).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber6));
        ((Button)view.findViewById(R.id.BtnNumber7)).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber7));
        ((Button)view.findViewById(R.id.BtnNumber8)).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber8));
        ((Button)view.findViewById(R.id.BtnNumber9)).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber9));
        ((Button)view.findViewById(R.id.BtnDecimal)).setOnClickListener(v -> passButtonToHost(R.id.BtnDecimal));
        ((Button)view.findViewById(R.id.BtnAddition)).setOnClickListener(v -> passButtonToHost(R.id.BtnAddition));
        ((Button)view.findViewById(R.id.BtnSubtraction)).setOnClickListener(v -> passButtonToHost(R.id.BtnSubtraction));
        ((Button)view.findViewById(R.id.BtnMultiplication)).setOnClickListener(v -> passButtonToHost(R.id.BtnMultiplication));
        ((Button)view.findViewById(R.id.BtnDivision)).setOnClickListener(v -> passButtonToHost(R.id.BtnDivision));
        ((Button)view.findViewById(R.id.BtnEnter)).setOnClickListener(v -> passButtonToHost(R.id.BtnEnter));
        ((Button)view.findViewById(R.id.BtnOpen)).setOnClickListener(v -> passButtonToHost(R.id.BtnOpen));
        ((Button)view.findViewById(R.id.BtnClose)).setOnClickListener(v -> passButtonToHost(R.id.BtnClose));
        ((Button)view.findViewById(R.id.BtnClear)).setOnClickListener(v -> passButtonToHost(R.id.BtnClear));
        ((Button)view.findViewById(R.id.BtnSecondaryOperations)).setOnClickListener(v -> passButtonToHost(R.id.BtnSecondaryOperations));
    }

    private void passButtonToHost(int id) {
        buttonPasser.passButtonId(id);
    }
}