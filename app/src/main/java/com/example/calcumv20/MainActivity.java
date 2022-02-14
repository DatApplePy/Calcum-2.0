package com.example.calcumv20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnButtonPass{

    private TextView inputOutputFeedbackTextView;

    private Fragment mainFunctions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputOutputFeedbackTextView = findViewById(R.id.InputOutputView);

        mainFunctions = new MainFunctions();
        getSupportFragmentManager().beginTransaction().replace(R.id.FragView, mainFunctions).commit();
    }

    @Override
    public void passButton(int buttonId) {
//TODO: implement me!
    }
}