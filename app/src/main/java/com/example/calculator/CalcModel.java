package com.example.calculator;

import java.util.Stack;

public class CalcModel {

    public double evaluate(String expression){
        char expArray[] = expression.toCharArray();

        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i = 0; i < expArray.length; i++){

            if(expArray[i] >= '0' && expArray[i] <= '9'){
                StringBuilder numberToAdd = new StringBuilder();
                while((i < expArray.length && expArray[i] >= '0' && expArray[i] <= '9')||(i < expArray.length && expArray[i] == '.')){
                    numberToAdd.append(expArray[i++]);
                }
                i--;
                numbers.push(Double.parseDouble(numberToAdd.toString()));
            }
            else if(expArray[i] == '('){
                operators.push(expArray[i]);
            }
            else if(expArray[i] == ')'){
                while(operators.peek() != '('){
                    numbers.push(doOperations(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.pop();
            }
            else if(expArray[i] == '+' || expArray[i] == '-' || expArray[i] == '/' || expArray[i] == '*' || expArray[i] == '^'){
                while (!operators.empty() && orderOfOperations(expArray[i], operators.peek())){
                    numbers.push(doOperations(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(expArray[i]);
            }
        }
        while (!operators.empty()){
            numbers.push(doOperations(operators.pop(), numbers.pop(), numbers.pop()));
        }
        return numbers.pop();
    }

    public double doOperations(char operator, double val2, double val1){
        switch (operator){
            case '+':
                return (val1 + val2);
            case '-':
                return (val1 - val2);
            case '*':
                return (val1 * val2);
            case '/':
                if(val2 == 0){
                    throw new ArithmeticException("Cannot divide by 0");
                }
                else {
                    return (val1 / val2);
                }
            case '^':
                return Math.pow(val1, val2);
        }
        return 0.0;
    }

    public boolean orderOfOperations(char val1, char val2){
        if(val2 == '(' || val2 == ')'){
            return false;
        }
        else if((val1 == '*' || val1 == '/') && (val2 == '+' || val2 == '-')){
            return false;
        }
        else if(val1 == '^' && (val2 == '*' || val2 =='/')){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isValid(String expression){
        char specials[] = {'+', '-', '/', '*', '.'};
        int leftCounter = 0;
        int rightCounter = 0;
        int decCounter = 0;
        for(int i = 0; i < expression.length(); i++){
            char current = expression.charAt(i);
            char next = ' ';
            char last = ' ';
            if(i > 1){
                last = expression.charAt(i-1);
            }
            if(i < expression.length() - 1){
                next = expression.charAt(i+1);
            }
            if(current == '('){
                leftCounter++;
            } else if(current == ')'){
                rightCounter++;
            }
            if(rightCounter > leftCounter || leftCounter - rightCounter >= 2){
                return false;
            }
            for(int j = 0; j < specials.length; j++){
                if(current == specials[j]){
                    for(int k = 0; k < specials.length; k++){
                        if(next == specials[k] || last == specials[k]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
