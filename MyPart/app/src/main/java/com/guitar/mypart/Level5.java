package com.guitar.mypart;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by TEACHER on 18.01.2016.
 */
public class Level5 {}

/*
    boolean flag;


    static void level5Start(){

        base = (int) (Math.random() * 10);
        number = (int) (Math.random() * 1000);

        if (number > 120){
            number = number / 17;
        }
        if (number % 2 == 0){
            flag = true;
        }
        if (number % 2 !=0){
            flag = false;
        }

        if(base >= 0 && base <= 4){
            base = 2;
        }
        if (base >=5 && base <= 7){
            base = 8;
        }
        if (base >= 8 && base <=10){
            base = 16;
        }

        if(base == 2) {
            if (flag = true) {
                textView.setText(Integer.toBinaryString(base) + "(2) " + " в (8)");
                searched = Integer.toOctalString(number);
            } else {
                textView.setText(Integer.toBinaryString(base) + "(2) " + " в (16)");
                textView.setText(Integer.toBinaryString(base) + "(2) " + " в (16)");
                searched = Integer.toHexString(number);
            }
        }

        if (base == 8) {
            if (flag = true) {
                textView.setText(Integer.toBinaryString(base) + "(8) " + " в (2)");
                searched = Integer.toBinaryString(number);
            } else {
                textView.setText(Integer.toBinaryString(base) + "(8) " + " в (16)");
                textView.setText(Integer.toBinaryString(base) + "(2) " + " в (16)");
                searched = Integer.toHexString(number);
            }
        }
        if (base == 16) {
            if (flag = true) {
                textView.setText(Integer.toBinaryString(base) + "(2) " + " в (8)");
                searched = Integer.toOctalString(number);
            } else {
                textView.setText(Integer.toBinaryString(base) + "(16) " + " в (2)");
                searched = Integer.toBinaryString(number);
            }
        }

    }

    public void checkAnswer(Button button1, EditText editText) {
        if (button1.isPressed()) {
            int answerCheck = Integer.parseInt(editText.getText().toString());
            if (answerCheck == number) {
                editText.setBackgroundColor(Color.GREEN);
            } else {
                editText.setBackgroundColor(Color.RED);
            }
        }
    }
    public void next(Button button1,EditText editText)   {
        if (button1.isPressed()){
            editText.setBackgroundColor(Color.TRANSPARENT);
            editText.setText("");
           level5Strat();
    }
    }



            }*/
