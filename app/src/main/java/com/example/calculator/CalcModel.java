package com.example.calculator;

public class CalcModel {
    public boolean isValid(String expression){
        char specials[] = {'+', '-', '*', '/', '(', ')', '^', '.'};
        int leftCounter = 0;
        int rightCounter = 0;
        int decCounter = 0;
        for(int i = 0; i < expression.length(); i++){
            char temp = expression.charAt(i);
            char nextTemp = ' ';
            if(i < expression.length() - 1){
                nextTemp = expression.charAt(i+1);
            }
            char lastTemp = ' ';
            if(i >= 1) {
                lastTemp = expression.charAt(i - 1);
            }
            if(temp == '('){
                leftCounter++;
            } else if (temp == ')'){
                rightCounter++;
            }
            if(rightCounter > leftCounter){
                return false;
            }
            for(int j = 0; j < specials.length; j++){
                if(temp == specials[j]){
                    if(temp == '.'){
                        if(decCounter > 0){
                            return false;
                        }
                        decCounter++;
                    } else {
                        decCounter = 0;
                        for (int k = 0; k < specials.length; k++) {
                            if (nextTemp == specials[k]) {
                                return false;
                            } else if (lastTemp == specials[k]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
