package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String expression;
    Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonDec,
                buttonSeven, buttonEight, buttonNine, buttonZero, buttonClear, buttonEquals,
                buttonAdd, buttonSub, buttonMult, buttonDiv, buttonLPara, buttonRPara, buttonExpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CalcModel calc = new CalcModel();

        expression = "";

        buttonOne = (Button)findViewById(R.id.button_1);
        buttonTwo = (Button)findViewById(R.id.button_2);
        buttonThree = (Button)findViewById(R.id.button_3);
        buttonFour = (Button)findViewById(R.id.button_4);
        buttonFive = (Button)findViewById(R.id.button_5);
        buttonSix = (Button)findViewById(R.id.button_6);
        buttonSeven = (Button)findViewById(R.id.button_7);
        buttonEight = (Button)findViewById(R.id.button_8);
        buttonNine = (Button)findViewById(R.id.button_9);
        buttonZero = (Button)findViewById(R.id.button_0);
        buttonAdd = (Button)findViewById(R.id.button_add);
        buttonMult = (Button)findViewById(R.id.button_multiply);
        buttonSub = (Button)findViewById(R.id.button_subtract);
        buttonDiv = (Button)findViewById(R.id.button_divide);
        buttonClear = (Button)findViewById(R.id.button_clear);
        buttonEquals = (Button)findViewById(R.id.button_equals);
        buttonLPara = (Button)findViewById(R.id.button_leftPara);
        buttonRPara = (Button)findViewById(R.id.button_rightPara);
        buttonExpo = (Button)findViewById(R.id.button_expo);
        buttonDec = (Button)findViewById(R.id.button_dec);


        buttonOne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expression += "1";
                        updateDisplay();
                    }
                }
        );
        buttonTwo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expression += "2";
                        updateDisplay();
                    }
                }
        );
        buttonThree.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expression += "3";
                        updateDisplay();
                    }
                }
        );
        buttonFour.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expression += "4";
                        updateDisplay();
                    }
                }
        );
        buttonFive.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expression += "5";
                        updateDisplay();
                    }
                }
        );
        buttonSix.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expression += "6";
                        updateDisplay();
                    }
                }
        );
        buttonSeven.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expression += "7";
                        updateDisplay();
                    }
                }
        );
        buttonEight.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expression += "8";
                        updateDisplay();
                    }
                }
        );
        buttonNine.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expression += "9";
                        updateDisplay();
                    }
                }
        );
        buttonZero.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expression += "0";
                        updateDisplay();
                    }
                }
        );
        buttonMult.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp = expression + "*";
                        if(calc.isValid(temp)){
                            if(expression.equals("")){
                                expression = "0*";
                            } else {
                                expression += "*";
                            }
                            updateDisplay();
                        }
                    }
                }
        );
        buttonAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp = expression + "+";
                        if(calc.isValid(temp)) {
                            if(expression.equals("")){
                                expression = "0+";
                            } else {
                                expression += "+";
                            }
                            updateDisplay();
                        }
                    }
                }
        );
        buttonSub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp = expression + "-";
                        if(calc.isValid(temp)){
                            if(expression.equals("")){
                                expression = "0-";
                            } else if (expression.charAt(expression.length()-1) == '('){
                                expression += "0-";
                            }
                            else {
                                expression += "-";
                            }
                            updateDisplay();
                        }
                    }
                }
        );
        buttonDiv.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp = expression + "/";
                        if(calc.isValid(temp)){
                            if(expression.equals("")){
                                expression = "0/";
                            } else {
                                expression += "/";
                            }
                            updateDisplay();
                        }
                    }
                }
        );
        buttonClear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expression = "";
                        updateDisplay();
                    }
                }
        );
        buttonLPara.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp = expression + "(";
                        if(calc.isValid(temp)){
                            expression += "(";
                            updateDisplay();
                        }
                    }
                }
        );
        buttonRPara.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp = expression + ")";
                        if(calc.isValid(temp)){
                            expression += ")";
                            updateDisplay();
                        }
                    }
                }
        );
        buttonExpo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp = expression + "^";
                        if(calc.isValid(temp)){
                            if(expression.equals("")){
                                expression = "0^";
                            } else {
                                expression += "^";
                            }
                            updateDisplay();
                        }
                    }
                }
        );
        buttonDec.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp = expression + ".";
                        if(calc.isValid(temp)){
                            if (expression.equals("")){
                                expression = "0.";
                            } else {
                                expression += ".";
                            }
                            updateDisplay();
                        }
                    }
                }
        );
        buttonEquals.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        double result = 0;
                        try {
                            result = calc.evaluate(expression);
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        updateResult(result);
                        expression = "";
                    }
                }
        );
    }
    public void updateDisplay(){
        TextView temp = (TextView)findViewById(R.id.display);
        temp.setText(expression);
    }
    public void updateResult(double result){
        TextView temp = (TextView)findViewById(R.id.display);
        temp.setText(Double.toString(result));
    }
}
