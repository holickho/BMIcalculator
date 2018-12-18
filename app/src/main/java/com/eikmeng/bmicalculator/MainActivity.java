package com.eikmeng.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    public static final String BMI__RESULT = "com.eikmeng.BMIcalculator.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);

    }

    public void calculateBMI(View view){

        if(TextUtils.isEmpty(editTextHeight.getText())){
            editTextHeight.setError("Please enter your height.");
            return;
        }else if(TextUtils.isEmpty(editTextWeight.getText())){
            editTextWeight.setError("Please enter your weight.");
            return;
        }else{
            double BMI = 0;
            double currentWeight = Double.parseDouble(editTextWeight.getText().toString());
            double currentHeight = Double.parseDouble(editTextHeight.getText().toString());

            BMI = currentWeight / (currentHeight*currentHeight);

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(BMI__RESULT, BMI);
            startActivity(intent);
        }


    }
}
