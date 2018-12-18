package com.eikmeng.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView displayResult;
    private ImageView displayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        displayResult = findViewById(R.id.textViewResult);
        displayImage = findViewById(R.id.imageViewResult);

        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.BMI__RESULT)){
            String result = String.valueOf(intent.getDoubleExtra(MainActivity.BMI__RESULT, 0));
            double BMI = Double.parseDouble(result);
            if(BMI < 18.5){
                displayResult.setVisibility(View.VISIBLE);
                displayImage.setImageResource(R.drawable.under);
                displayResult.setText("Under Weight");
            } else if(BMI > 18.5 && BMI < 25){
                displayResult.setVisibility(View.VISIBLE);
                displayImage.setImageResource(R.drawable.normal);
                displayResult.setText("Normal");
            } else if(BMI > 25 ){
                displayResult.setVisibility(View.VISIBLE);
                displayImage.setImageResource(R.drawable.over);
                displayResult.setText("Over Weight");
            }
        }
    }
}
