package com.example.calcumv20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView inputOutputFeedbackTextView;
    private Button BtnNumber0;
    private Button BtnNumber1;
    private Button BtnNumber2;
    private Button BtnNumber3;
    private Button BtnNumber4;
    private Button BtnNumber5;
    private Button BtnNumber6;
    private Button BtnNumber7;
    private Button BtnNumber8;
    private Button BtnNumber9;
    private Button BtnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputOutputFeedbackTextView = findViewById(R.id.InputOutputView);
        BtnNumber0 = findViewById(R.id.BtnNumber0);
        BtnNumber1 = findViewById(R.id.BtnNumber1);
        BtnNumber2 = findViewById(R.id.BtnNumber2);
        BtnNumber3 = findViewById(R.id.BtnNumber3);
        BtnNumber4 = findViewById(R.id.BtnNumber4);
        BtnNumber5 = findViewById(R.id.BtnNumber5);
        BtnNumber6 = findViewById(R.id.BtnNumber6);
        BtnNumber7 = findViewById(R.id.BtnNumber7);
        BtnNumber8 = findViewById(R.id.BtnNumber8);
        BtnNumber9 = findViewById(R.id.BtnNumber9);
        BtnClear = findViewById(R.id.BtnClear);
    }

    @Override
    protected void onStart() {
        super.onStart();
        BtnNumber0.setOnClickListener(view -> inputOutputFeedbackTextView.append("0"));
        BtnNumber1.setOnClickListener(view -> inputOutputFeedbackTextView.append("1"));
        BtnNumber2.setOnClickListener(view -> inputOutputFeedbackTextView.append("2"));
        BtnNumber3.setOnClickListener(view -> inputOutputFeedbackTextView.append("3"));
        BtnNumber4.setOnClickListener(view -> inputOutputFeedbackTextView.append("4"));
        BtnNumber5.setOnClickListener(view -> inputOutputFeedbackTextView.append("5"));
        BtnNumber6.setOnClickListener(view -> inputOutputFeedbackTextView.append("6"));
        BtnNumber7.setOnClickListener(view -> inputOutputFeedbackTextView.append("7"));
        BtnNumber8.setOnClickListener(view -> inputOutputFeedbackTextView.append("8"));
        BtnNumber9.setOnClickListener(view -> inputOutputFeedbackTextView.append("9"));
        BtnClear.setOnClickListener(view -> {
            String currentViewValue = inputOutputFeedbackTextView.getText().toString();
            inputOutputFeedbackTextView.setText(currentViewValue.substring(0, currentViewValue.length()-1));
        });
    }
}