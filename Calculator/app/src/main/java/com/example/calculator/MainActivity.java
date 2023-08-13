package com.example.calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity{
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.Edit_Txt);
    }
    public void onClickClear(View v){
            result.setText("");
    }
    public void onClick(View v){
        Button b=(Button)v;
        if(v.equals(b)) {
            String text = b.getText().toString();
            String res = "";
            result.append(res + text);
        }
    }
    public void onClickRes(View v){
        Button b=(Button) v;
        try {
            if (v.equals(b)) {
                String data = result.getText().toString();
                if (data.contains("/")) {
                    String[] operands = data.split("/");
                    if (operands.length == 2) {
                        double operand1 = Double.parseDouble(operands[0]);
                        double operand2 = Double.parseDouble(operands[1]);
                        double temRes = operand1 / operand2;
                        result.setText(String.valueOf(temRes));
                    } else {
                        Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }

                } else if (data.contains("*")) {
                    String[] operands = data.split(Pattern.quote("*"));
                    if (operands.length == 2) {
                        double operand1 = Double.parseDouble(operands[0]);
                        double operand2 = Double.parseDouble(operands[1]);
                        double temRes = operand1 * operand2;
                        result.setText(String.valueOf(temRes));
                    } else {
                        Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (data.contains("-")) {
                    String[] operands = data.split(Pattern.quote("-"));
                    if (operands.length == 2) {
                        double operand1 = Double.parseDouble(operands[0]);
                        double operand2 = Double.parseDouble(operands[1]);
                        double temRes = operand1 - operand2;
                        result.setText(String.valueOf(temRes));
                    } else {
                        Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (data.contains("+")) {
                    String[] operands = data.split(Pattern.quote("+"));
                    if (operands.length == 2) {
                        double operand1 = Double.parseDouble(operands[0]);
                        double operand2 = Double.parseDouble(operands[1]);
                        double temRes = operand1 + operand2;
                        result.setText(String.valueOf(temRes));
                    } else {
                        Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        }
            catch(Exception e){
                e.printStackTrace();
            }
        }
}