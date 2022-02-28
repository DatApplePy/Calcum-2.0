package com.example.calcumv20;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calcumv20.Util.OnButtonPass;

public class SecondaryFunctions extends Fragment {

    private OnButtonPass buttonPasser;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPasser = (OnButtonPass) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_secondary_functions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.BtnSine).setOnClickListener(v -> passButtonToHost(R.id.BtnSine));
        view.findViewById(R.id.BtnCosine).setOnClickListener(v -> passButtonToHost(R.id.BtnCosine));
        view.findViewById(R.id.BtnTangent).setOnClickListener(v -> passButtonToHost(R.id.BtnTangent));
        view.findViewById(R.id.BtnExponential).setOnClickListener(v -> passButtonToHost(R.id.BtnExponential));
        view.findViewById(R.id.BtnSqrt).setOnClickListener(v -> passButtonToHost(R.id.BtnSqrt));
        view.findViewById(R.id.BtnLogarithm).setOnClickListener(v -> passButtonToHost(R.id.BtnLogarithm));
        view.findViewById(R.id.BtnConstantPi).setOnClickListener(v -> passButtonToHost(R.id.BtnConstantPi));
        view.findViewById(R.id.BtnConstantEuler).setOnClickListener(v -> passButtonToHost(R.id.BtnConstantEuler));
        view.findViewById(R.id.BtnBackToMain).setOnClickListener(v -> passButtonToHost(R.id.BtnBackToMain));
    }

    private void passButtonToHost(int id) {
        buttonPasser.passButtonId(id);
    }
}