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
    private Fragment mainFunctions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputOutputFeedbackTextView = findViewById(R.id.InputOutputView);
        model = new Model();
        model.addObserver(this);
        mainFunctions = new MainFunctions();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void passButtonId(int buttonId) {
        switch(buttonId) {
            case R.id.BtnNumber0: model.receiveData("0"); break;
            case R.id.BtnNumber1: model.receiveData("1"); break;
            case R.id.BtnNumber2: model.receiveData("2"); break;
            case R.id.BtnNumber3: model.receiveData("3"); break;
            case R.id.BtnNumber4: model.receiveData("4"); break;
            case R.id.BtnNumber5: model.receiveData("5"); break;
            case R.id.BtnNumber6: model.receiveData("6"); break;
            case R.id.BtnNumber7: model.receiveData("7"); break;
            case R.id.BtnNumber8: model.receiveData("8"); break;
            case R.id.BtnNumber9: model.receiveData("9"); break;
        }
    }

    @Override
    public void update() {
        inputOutputFeedbackTextView.setText(model.getData());
    }
}