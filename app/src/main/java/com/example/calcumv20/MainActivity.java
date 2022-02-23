package com.example.calcumv20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.calcumv20.Model.Model;
import com.example.calcumv20.Util.Observer;
import com.example.calcumv20.Util.OnButtonPass;

public class MainActivity extends AppCompatActivity implements OnButtonPass, Observer {

    private TextView inputOutputFeedbackTextView;
    private Model model;
    private Fragment mainFunctions, secondaryFunctions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputOutputFeedbackTextView = findViewById(R.id.InputOutputView);
        model = new Model();
        model.addObserver(this);
        mainFunctions = new MainFunctions();
        secondaryFunctions = new SecondaryFunctions();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void passButtonId(int buttonId) {
        switch(buttonId) {
            case R.id.BtnNumber0: model.addInput("0"); break;
            case R.id.BtnNumber1: model.addInput("1"); break;
            case R.id.BtnNumber2: model.addInput("2"); break;
            case R.id.BtnNumber3: model.addInput("3"); break;
            case R.id.BtnNumber4: model.addInput("4"); break;
            case R.id.BtnNumber5: model.addInput("5"); break;
            case R.id.BtnNumber6: model.addInput("6"); break;
            case R.id.BtnNumber7: model.addInput("7"); break;
            case R.id.BtnNumber8: model.addInput("8"); break;
            case R.id.BtnNumber9: model.addInput("9"); break;
            case R.id.BtnDecimal: model.addInput("."); break;
            case R.id.BtnAddition: model.addInput("+"); break;
            case R.id.BtnSubtraction: model.addInput("-"); break;
            case R.id.BtnMultiplication: model.addInput("×"); break;
            case R.id.BtnDivision: model.addInput("÷"); break;
            case R.id.BtnEnter: model.solve(); break;
            case R.id.BtnOpen: model.addInput("("); break;
            case R.id.BtnClose: model.addInput(")"); break;
            case R.id.BtnClear: model.deleteLastChar(); break;
            case R.id.BtnSecondaryOperations: getSupportFragmentManager().beginTransaction().
                    replace(R.id.FragView, secondaryFunctions).commit(); break;

            //TODO: fine-tuning input goes to model
            case R.id.BtnSine: model.addInput("sin("); break;
            case R.id.BtnCosine: model.addInput("cos("); break;
            case R.id.BtnTangent: model.addInput("tan("); break;
            case R.id.BtnExponention: model.addInput("^"); break;
            case R.id.BtnSqrt: model.addInput("\u221A"); break;
            case R.id.BtnLogarithm: model.addInput("log("); break;
            case R.id.BtnBackToMain: getSupportFragmentManager().beginTransaction().
                    replace(R.id.FragView, mainFunctions).commit(); break;
        }
    }

    @Override
    public void update() {
        inputOutputFeedbackTextView.setText(model.getOutput());
    }
}