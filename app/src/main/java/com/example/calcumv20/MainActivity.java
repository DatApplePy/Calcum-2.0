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
            case R.id.BtnNumber0: model.putData("0"); break;
            case R.id.BtnNumber1: model.putData("1"); break;
            case R.id.BtnNumber2: model.putData("2"); break;
            case R.id.BtnNumber3: model.putData("3"); break;
            case R.id.BtnNumber4: model.putData("4"); break;
            case R.id.BtnNumber5: model.putData("5"); break;
            case R.id.BtnNumber6: model.putData("6"); break;
            case R.id.BtnNumber7: model.putData("7"); break;
            case R.id.BtnNumber8: model.putData("8"); break;
            case R.id.BtnNumber9: model.putData("9"); break;
            case R.id.BtnDecimal: model.putData("."); break;
            case R.id.BtnAddition: model.putData("+"); break;
            case R.id.BtnSubtraction: model.putData("-"); break;
            case R.id.BtnMultiplication: model.putData("×"); break;
            case R.id.BtnDivision: model.putData("÷"); break;
            case R.id.BtnEnter: model.evaluate(); break;
            case R.id.BtnOpen: model.putData("("); break;
            case R.id.BtnClose: model.putData(")"); break;
            case R.id.BtnClear: model.deleteLastChar(); break;
            case R.id.BtnSecondaryOperations: getSupportFragmentManager().beginTransaction().replace(R.id.FragView, secondaryFunctions).commit(); break;

            //TODO: fine-tuning input goes to model
            case R.id.BtnSine: model.putData("sin("); break;
            case R.id.BtnCosine: model.putData("cos("); break;
            case R.id.BtnTangent: model.putData("tan("); break;
            case R.id.BtnPower: model.putData("^"); break;
            case R.id.BtnSqrt: model.putData("\u221A"); break;
            case R.id.BtnLogarithm: model.putData("log("); break;
            case R.id.BtnBackToMain: getSupportFragmentManager().beginTransaction().replace(R.id.FragView, mainFunctions).commit(); break;
        }
    }

    @Override
    public void update() {
        inputOutputFeedbackTextView.setText(model.getData());
    }
}