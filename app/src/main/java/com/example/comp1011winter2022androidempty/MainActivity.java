package com.example.comp1011winter2022androidempty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToCalculator(View view){

        Intent intent = new Intent(this, CalculatorActivity.class);
        intent.putExtra("custom_value", "You came from Main Method");
        startActivity(intent);

    }
}