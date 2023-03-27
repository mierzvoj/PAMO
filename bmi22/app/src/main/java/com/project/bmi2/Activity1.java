package com.project.bmi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

//Wojciech Mierzejewski s21617
//BMI calculator Android App
//Uses JAVA + xml layout view
public class Activity1 extends AppCompatActivity {


    //all nesessary variables deifinition
    private double weight = 0.0;
    private double height = 0.15;
    //TextViews definitions
    private TextView heightTextView;
    private TextView weightTextView;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //looking up TextViews in layout
        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalTextView.setText(String.format(0 + ""));
// setting TextWatchers for both weight and height fields
        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);
        EditText heightEditText =
                (EditText) findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);


    }

    //method calculate, calculating BMI, setting totalTextView as result
    private void calculate() {


        double total = weight / (height * height);


        totalTextView.setText(String.format(total + ""));
    }

    // listeners object for TextViews weight and height text-changed events
    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        // called when the user modifies weight or height field, or both
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                weight = Double.parseDouble(s.toString()) / 100.0;
                weightTextView.setText(String.format(weight + ""));
            } catch (NumberFormatException e) {
                weightTextView.setText("");
                weight = 0.0;
            }
//recalculate on change
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };
    private final TextWatcher heightEditTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                height = Double.parseDouble(s.toString()) / 100.0;
                heightTextView.setText(String.format(height + ""));
            } catch (NumberFormatException e) {
                heightTextView.setText("");
                height = 0.0;
            }
//recalculate on change
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };
}