package com.example.calculator;

public class Calculator {

    //Variables
    private float number1;
    private float number2;
    //Constructor
    public Calculator(float number1, float number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
    //Setters
    public void setNumber1(float number1) {
        this.number1 = number1;
    }

    public void setNumber2(float number2) {
        this.number2 = number2;
    }

    //Sum method
    public String sum(){
        float result = Math.round((number1+number2)* 100.0f) / 100.0f;
        return String.valueOf(result);
    }
    //Subtraction method
    public String subtract(){
        float result = Math.round((number1-number2)* 100.0f) / 100.0f;
        return String.valueOf(result);
    }
    //Multiply method
    public String multiply(){
        float result = Math.round((number1*number2)* 100.0f) / 100.0f;
        return String.valueOf(result);
    }
    //Division method
    public String divide(){
        String result;
        if(number2 == 0){
            result = "error";
        }
        else{
            float value = Math.round((number1/number2)* 100.0f) / 100.0f;
            result = String.valueOf(value);
        }
        return result;
    }

}
