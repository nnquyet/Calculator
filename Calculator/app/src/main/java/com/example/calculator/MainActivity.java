package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mainscreen, secondscreen;
    private String input, answer;
    private boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainscreen = (TextView) findViewById(R.id.man_hinh_chinh);
        secondscreen = (TextView) findViewById(R.id.man_hinh_phu);

    }
    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data) {
            case "C":
                input = "";
                break;
            case "D":
                if (input.length() > 0) {
                    String newText = input.substring(0, input.length() - 1);
                    input = newText;
                }
                break;
            case "%":
                String number[] = input.split("\\%");
                try {
                    double phantram = Double.parseDouble(number[0]) / 100;
                    input = Math.ceil(phantram * 10000) / 10000 + "";
                }catch (Exception e) {

                }
                break;
            case "=":
                Solve();
                check = true;
                break;
            case "+":
                if (input.split("\\+").length == 2 || input.split("\\-").length == 2 || input.split("\\*").length == 2 ||input.split("\\/").length == 2) {
                    Solve();
                }
                input += data;
                break;
            case "-":
                if (input.split("\\+").length == 2 || input.split("\\-").length == 2 || input.split("\\*").length == 2 ||input.split("\\/").length == 2) {
                    Solve();
                }
                input += data;
                break;
            case "*":
                if (input.split("\\+").length == 2 || input.split("\\-").length == 2 || input.split("\\*").length == 2 ||input.split("\\/").length == 2) {
                    Solve();
                }
                input += data;
                break;
            case "/":
                if (input.split("\\+").length == 2 || input.split("\\-").length == 2 || input.split("\\*").length == 2 ||input.split("\\/").length == 2) {
                    Solve();
                }
                input += data;
                break;
            default:
                if (check) {
                    input = "";
                }
                if (input == null) {
                    input = "";
                }
                input += data;
                check = false;
        }
        mainscreen.setText(input);

    }

    public void Solve() {
        if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                answer = sum + "";
            }catch (Exception e) {

            }
        }

        if (input.split("\\-").length == 2) {
            String number[] = input.split("\\-");
            try {
                double sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                answer = Math.ceil(sub * 10000) / 10000 + "";
            }catch (Exception e) {

            }
        }

        if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                answer = mul + "";
            }catch (Exception e) {

            }
        }

        if (input.split("\\/").length == 2) {
            String number[] = input.split("\\/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                answer = Math.ceil(div * 10000) / 10000 + "";
            }catch (Exception e) {

            }
        }

        String n[] = answer.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                answer = n[0];
            }
        }

        secondscreen.setText(input);
        input = answer;

    }
}