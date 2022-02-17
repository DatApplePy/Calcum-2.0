package com.example.calcumv20;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        view.findViewById(R.id.BtnNumber0).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber0));
        view.findViewById(R.id.BtnNumber1).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber1));
        view.findViewById(R.id.BtnNumber2).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber2));
        view.findViewById(R.id.BtnNumber3).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber3));
        view.findViewById(R.id.BtnNumber4).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber4));
        view.findViewById(R.id.BtnNumber5).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber5));
        view.findViewById(R.id.BtnNumber6).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber6));
        view.findViewById(R.id.BtnNumber7).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber7));
        view.findViewById(R.id.BtnNumber8).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber8));
        view.findViewById(R.id.BtnNumber9).setOnClickListener(v -> passButtonToHost(R.id.BtnNumber9));
        view.findViewById(R.id.BtnDecimal).setOnClickListener(v -> passButtonToHost(R.id.BtnDecimal));
        view.findViewById(R.id.BtnAddition).setOnClickListener(v -> passButtonToHost(R.id.BtnAddition));
        view.findViewById(R.id.BtnSubtraction).setOnClickListener(v -> passButtonToHost(R.id.BtnSubtraction));
        view.findViewById(R.id.BtnMultiplication).setOnClickListener(v -> passButtonToHost(R.id.BtnMultiplication));
        view.findViewById(R.id.BtnDivision).setOnClickListener(v -> passButtonToHost(R.id.BtnDivision));
        view.findViewById(R.id.BtnEnter).setOnClickListener(v -> passButtonToHost(R.id.BtnEnter));
        view.findViewById(R.id.BtnOpen).setOnClickListener(v -> passButtonToHost(R.id.BtnOpen));
        view.findViewById(R.id.BtnClose).setOnClickListener(v -> passButtonToHost(R.id.BtnClose));
        view.findViewById(R.id.BtnClear).setOnClickListener(v -> passButtonToHost(R.id.BtnClear));
        view.findViewById(R.id.BtnSecondaryOperations).setOnClickListener(v -> passButtonToHost(R.id.BtnSecondaryOperations));
    }

    private void passButtonToHost(int id) {
        buttonPasser.passButtonId(id);
    }
}