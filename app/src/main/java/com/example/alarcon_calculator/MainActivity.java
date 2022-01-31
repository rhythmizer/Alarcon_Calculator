package com.example.alarcon_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    String oldNumber="";
    String Op = "+";
    boolean isNewOp = true;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editText);
    }

    public void NumberEvent(View view) {
        if(isNewOp)
            ed1.setText("");
        isNewOp = false;
        String number = ed1.getText().toString();
        switch (view.getId()) {
            case R.id.buPlusMinus:
                number = "-"+number;
                break;
            case R.id.buZero:
                number += "0";
                break;
            case R.id.buPoint:
                number += ".";
                break;
            case R.id.buEight:
                number += "8";
                break;
            case R.id.buNine:
                number += "9";
                break;
            case R.id.buFour:
                number += "4";
                break;
            case R.id.buFive:
                number += "5";
                break;
            case R.id.buSix:
                number += "6";
                break;
            case R.id.buThree:
                number += "3";
                break;
            case R.id.buTwo:
                number += "2";
                break;
            case R.id.buOne:
                number += "1";
                break;
            case R.id.buSeven:
                number += "7";
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = ed1.getText().toString();
        switch (view.getId()){
            case R.id.buDivide: Op= "/"; break;
            case R.id.buMultiply: Op= "*"; break;
            case R.id.buMinus: Op= "-"; break;
            case R.id.buPlus: Op= "+"; break;
        }
    }

    public void equalEvent(View view) {
        String newNumber = ed1.getText().toString();
        double result = 0.0;
        switch (Op){
            case"/":
                result=Double.parseDouble(oldNumber)/ Double.parseDouble(newNumber);
                break;
            case"*":
                result=Double.parseDouble(oldNumber)* Double.parseDouble(newNumber);
                break;
            case"-":
                result=Double.parseDouble(oldNumber)- Double.parseDouble(newNumber);
                break;
            case"+":
                result=Double.parseDouble(oldNumber)+ Double.parseDouble(newNumber);
                break;
        }
        ed1.setText(result+"");
    }

    public void acEvent(View view) {
        ed1.setText("0");
        isNewOp = true;
    }

    public void percentEvent(View view) {
        double no = Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(no+"");
        isNewOp = true;
    }
}




















