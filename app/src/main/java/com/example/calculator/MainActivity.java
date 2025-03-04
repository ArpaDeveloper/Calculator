package com.example.calculator;

//Imports to interact with ui elements
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Reference the calculator script so that all methods can access it
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Lets initialize the calculator
        calculator = new Calculator(0,0);

        //References to UI

        //Input Fields
        TextInputEditText inputField1 = findViewById(R.id.textInputEditText1);
        TextInputEditText inputField2 = findViewById(R.id.textInputEditText2);
        //Buttons
        Button plusbutton = findViewById(R.id.PlusButton);
        Button minusbutton = findViewById(R.id.MinusButton);
        Button multiplybutton = findViewById(R.id.MultiplyButton);
        Button dividebutton = findViewById(R.id.DivideButton);
        //Result Field
        TextView result_field = findViewById(R.id.textView3);

        //Calculate when pressed
        plusbutton.setOnClickListener(v -> {
            updateNumbers(inputField1, inputField2);
            String result = calculator.sum();

            //Display result on text
            result_field.setText(result);
        });

        minusbutton.setOnClickListener(v -> {
            updateNumbers(inputField1, inputField2);
            String result = calculator.subtract();

            //Display result on text
            result_field.setText(result);
        });

        multiplybutton.setOnClickListener(v -> {
            updateNumbers(inputField1, inputField2);
            String result = calculator.multiply();

            //Display result on text
            result_field.setText(result);
        });

        dividebutton.setOnClickListener(v -> {
            updateNumbers(inputField1, inputField2);
            String result = calculator.divide();

            //Display result on text
            result_field.setText(result);
        });

    }
    //Handling user input
    void updateNumbers(TextInputEditText inputField1, TextInputEditText inputField2) {
        // Read the input fields and convert them to float
        float number1 = 0, number2 = 0;
        if (inputField1.getText() != null && !inputField1.getText().toString().isEmpty()) {
            number1 = Float.parseFloat(inputField1.getText().toString());
        }
        if (inputField2.getText() != null && !inputField2.getText().toString().isEmpty()) {
            number2 = Float.parseFloat(inputField2.getText().toString());
        }

        // Update calculator numbers
        calculator.setNumber1(number1);
        calculator.setNumber2(number2);
    }
}