package com.guitar.mypart;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int  base, number,levelNumber;
    boolean flag;
    String temp = "",searched;
    String numberString = null;
    TextView exercise;
    EditText answer;
    Button answerButton,next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            exercise = (TextView)findViewById(R.id.textExercise);
            answer = (EditText)findViewById(R.id.textAnswer);
            answerButton = (Button)findViewById(R.id.check);
            next = (Button)findViewById(R.id.next);

        switch(levelNumber){
            case 1: level1Exercise();
            case 2: level2Exercise();
            case 3: level3Exercise();
            case 4: level4Exercise();
            case 5: level5Exercise();
            case 6: level6Exercise();
            case 7: //Уровень1;
            case 8: //Уровень1;
            case 9: //Уровень1;
            case 10: //Уровень1;
            case 11: //Уровень1;

        }
    }
    int InOtherSystem(int base, int number){ //перевод из десятичной в другие с.с.
        int result=0,place=1,residual;
        while(number>0){
            residual=number%base;
            result+=place*residual;
            place*=10;
            number=number/base;
        }
      return result;
    }
    String InOtherSystem11_16(int base, int number){
        String answer="";
        int residual;
        while (number>0){
            residual=number%base;
            if(residual>9) residual+=(int)'A';
            else residual+=(int)'0';
            answer+=(char)residual;
            number/=base;
        }
        return answer;
    }


    Random rand=new Random();
    //Level 1
public void level1Exercise(){
    int number=rand.nextInt(99)+1;//задание
    exercise.setText("В какой минимальной с.с. можно записать число так\n"+Integer.toString(number));//вывод задания
   searched=Integer.toString(Math.max(number%10,number/10)+1);//ответ
}
    //Level 2
    public void level2Exercise(){
        int base=rand.nextInt(8)+2;//основание системы счисления
        int des=rand.nextInt(base);//1 разряд
        int ed=rand.nextInt(base);//0 разряд
        exercise.setText("Какое число будет следующим?\n"+Integer.toString(des*10+ed)+" ("+Integer.toString(base)+")");//вывод задания
        if (ed<base-1) searched=Integer.toString(des*10+ed+1);//если записано число нулевой разряд которого меньше чем, самая большая цифра системы счисления
        else if (des<base-1) searched=Integer.toString((des+1)*10) ;//если записано число с нулевым разрядом равным самомй большой цифре с.с., но 1й разряд меньше
       else searched="100";
}
//Level 3
    public void level3Exercise(){
        int base=rand.nextInt(9)+2;
        int number;
        if(base<4) number=rand.nextInt(16)+1;
       else if (base<6) number=rand.nextInt(48)+3;
        else if(base<8) number=rand.nextInt(112)+5;
        else number=rand.nextInt(240)+7;
        exercise.setText("Переведите из 10й с.с.\n"+Integer.toString(number)+" в("+Integer.toString(base)+")");
        searched=Integer.toString(InOtherSystem(base,number));
    }

public void level4Exercise(){
int base=rand.nextInt(5)+11;
    int number=rand.nextInt(100)+1;
    exercise.setText("Переведите из 10й с.с.\n"+Integer.toString(number)+" в("+Integer.toString(base)+")");
    searched=InOtherSystem11_16(base,number);
}


    //Номер 5
    public void level5Exercise(){

        base  = (int) (Math.random() * 10);
        number = (int) (Math.random() * 1000);

        if (number > 120){
            number = number / 13;
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
                exercise.setText(Integer.toBinaryString(base) + "(2) " + " в (8)");
                searched = Integer.toOctalString(number);
            } else {
                exercise.setText(Integer.toBinaryString(base) + "(2) " + " в (16)");
                searched = Integer.toHexString(number);

            }
        }

        if (base == 8) {
            if (flag = true) {
                exercise.setText(Integer.toBinaryString(base) + "(8) " + " в (2)");
                searched = Integer.toBinaryString(number);
            } else {
                exercise.setText(Integer.toBinaryString(base) + "(8) " + " в (16)");
                searched = Integer.toHexString(number);
            }
        }
        if (base == 16) {
            if (flag = true) {
                exercise.setText(Integer.toBinaryString(base) + "(2) " + " в (8)");
                searched = Integer.toOctalString(number);
            } else {
                exercise.setText(Integer.toBinaryString(base) + "(16) " + " в (2)");
                searched = Integer.toBinaryString(number);
            }
        }

    }

    //Номер 6
    public void level6Exercise(){

        base=(int)(Math.random()*10);
        number=(int)(Math.random()*1000);

        if(base==1||base==10){
        base=2;
        }
        if(base==0){
        base=16;
        }
        if(number>300){
        number=number/4;
        }


        if(base==2){
        numberString=Integer.toBinaryString(number);
        exercise.setText("Переведите "+numberString+"("+base+")");
        }
        if(base==16){
        numberString=Integer.toHexString(number);
        exercise.setText("Переведите "+numberString+"("+base+")");
        }
        if(base==8){
        numberString=Integer.toOctalString(number);
        exercise.setText("Переведите "+numberString+"("+base+")");
        }

        if(base!=8&&base!=2&&base!=16){
            int a=number;
            int b;
            while(a>1){
                if(a>base){
                    b=a%base;
                    temp=b+temp;
                    a=a/base;
                }else{
                     b=a%base;
                     temp=b+temp;
                     break;
                }

            }
            exercise.setText("Переведите "+temp+"("+base+")");
            searched = Integer.toString(number);
            }
        }


    //Проверка любого номера
    public void checkAnswer(View v) {
        String answerCheck = answer.getText().toString();
        if (answerCheck.equals(searched)) { //строки == не сравнивают
            answer.setBackgroundColor(Color.GREEN);
        } else {
            answer.setBackgroundColor(Color.RED);
        }
    }


    //Кнопка Next
    public void nextExercise(int i){
        answer.setBackgroundColor(Color.TRANSPARENT);
        answer.setText("");
        levelChosen(i);
    }

    //Выбор уровня для метода nextExercise(int b)
    public void levelChosen(int b){
        switch (b){
            case 1:level1Exercise(); break;
            case 2: level2Exercise();break;
            case 3:level3Exercise(); break;
            case 4:level4Exercise();break;
            case 5:level5Exercise();break;
            case 6:level6Exercise();break;
        }
    }

















   /*  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
