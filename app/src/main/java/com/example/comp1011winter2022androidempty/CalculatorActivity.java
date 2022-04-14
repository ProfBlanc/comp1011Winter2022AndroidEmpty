package com.example.comp1011winter2022androidempty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends BaseMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Intent intent = getIntent();
        String message = intent.getStringExtra("custom_value");

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        ((TextView)findViewById(R.id.calculator_welcome)).setText(message);

    }


    public void onCalculate(View v){

        EditText num1 = findViewById(R.id.calculator_num1);
        EditText num2 = findViewById(R.id.calculator_num2);
        TextView welcome = findViewById(R.id.calculator_welcome);
        EditText result = findViewById(R.id.calculator_result);
        Spinner operator = findViewById(R.id.calculator_operator);

        String symbol = operator.getSelectedItem().toString();


        double value1 = Double.parseDouble(num1.getText().toString());
        double value2 = Double.parseDouble(num2.getText().toString());

        Toast.makeText(getApplicationContext(), symbol, Toast.LENGTH_LONG).show();

        double calc_result = value1 + value2;
        result.setText(String.valueOf(calc_result));

    }

}