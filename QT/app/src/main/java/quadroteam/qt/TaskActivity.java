package quadroteam.qt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class TaskActivity extends AppCompatActivity {

    SharedPreferences sPref;
    static String SAVED_VALUE = "saved_value";
    static private String SAVED_LVL_1 = "saved_value";
    static private String SAVED_LVL_2 = "saved_value";
    static private String SAVED_LVL_3 = "saved_value";
    static private String SAVED_LVL_4 = "saved_value";
    static private String SAVED_LVL_5 = "saved_value";
    static private String SAVED_LVL_6 = "saved_value";
    static private String SAVED_LVL_7 = "saved_value";
    static private String SAVED_LVL_8 = "saved_value";
    static private String SAVED_LVL_9 = "saved_value";
    static private String SAVED_LVL_10 = "saved_value";



    int localScore;
    int  base, number,levelVariable;
    boolean f,flag;
    String temp = "",searched;
    String numberString = null;
    TextView exercise;
    EditText answer;
    Button answerButton,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        exercise = (TextView)findViewById(R.id.textExercise);
        answer = (EditText)findViewById(R.id.textAnswer);  answer.setBackgroundColor(Color.TRANSPARENT);
        answerButton = (Button)findViewById(R.id.check);
        next = (Button)findViewById(R.id.next);


        levelVariable = getIntent().getIntExtra("lvl", 1);

        sPref = getPreferences(MODE_PRIVATE);

        getLocalScore(levelVariable);

        if (localScore != 0){
            next.setText(localScore + " из 10 \n  Next");
        }
        switch(levelVariable){
            case 1: getLocalScore(levelVariable);
                    level1Exercise();
                break;
            case 2: getLocalScore(levelVariable);
                    level2Exercise();
                break;
            case 3: getLocalScore(levelVariable);
                    level3Exercise();
                break;
            case 4: getLocalScore(levelVariable);
                    level4Exercise();
                break;
            case 5: getLocalScore(levelVariable);
                    level5Exercise();
                break;
            case 6: getLocalScore(levelVariable);
                    level6Exercise();
                break;
            case 7: getLocalScore(levelVariable);
                    level7Exercise();
                break;
            case 8: getLocalScore(levelVariable);
                    level8Exercise();
                break;
            case 9: getLocalScore(levelVariable);
                    level9Exercise();
                break;
            case 10:getLocalScore(levelVariable);
                    level10Exercise();
                break;

        }
    }


    private void setLocalScore (int levelVariable){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        switch (levelVariable){
            case 1:
                ed.putString(SAVED_LVL_1, Integer.toString(localScore));
                break;
            case 2: ed.putString(SAVED_LVL_2, Integer.toString(localScore));

                break;
            case 3: ed.putString(SAVED_LVL_3, Integer.toString(localScore));

                break;
            case 4: ed.putString(SAVED_LVL_4, Integer.toString(localScore));

                break;
            case 5: ed.putString(SAVED_LVL_5, Integer.toString(localScore));

                break;
            case 6: ed.putString(SAVED_LVL_6, Integer.toString(localScore));

                break;
            case 7: ed.putString(SAVED_LVL_7, Integer.toString(localScore));

                break;
            case 8: ed.putString(SAVED_LVL_8, Integer.toString(localScore));

                break;
            case 9: ed.putString(SAVED_LVL_9,Integer.toString(localScore));

                break;
            case 10:ed.putString(SAVED_LVL_10, Integer.toString(localScore));

                break;
        }
            ed.apply();
    }

    private void getLocalScore (int levelVariable){
        sPref = getPreferences(MODE_PRIVATE);
        switch (levelVariable){
            case 1: localScore = Integer.parseInt(sPref.getString(SAVED_LVL_1,"0"));
                break;
            case 2: localScore = Integer.parseInt(sPref.getString(SAVED_LVL_2,"0"));
                break;
            case 3: localScore = Integer.parseInt(sPref.getString(SAVED_LVL_3,"0"));
                break;
            case 4: localScore = Integer.parseInt(sPref.getString(SAVED_LVL_4,"0"));
                break;
            case 5: localScore = Integer.parseInt(sPref.getString(SAVED_LVL_5,"0"));
                break;
            case 6: localScore = Integer.parseInt(sPref.getString(SAVED_LVL_6,"0"));
                break;
            case 7: localScore = Integer.parseInt(sPref.getString(SAVED_LVL_7,"0"));
                break;
            case 8: localScore = Integer.parseInt(sPref.getString(SAVED_LVL_8,"0"));
                break;
            case 9: localScore = Integer.parseInt(sPref.getString(SAVED_LVL_9,"0"));
                break;
            case 10: localScore = Integer.parseInt(sPref.getString(SAVED_LVL_10,"0"));
                break;
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

    String InOtherSystem11_16(int base, int number){//перевод из 10 в больше 10
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
        f = true;
        int number=rand.nextInt(99)+1;//задание
        exercise.setText("В какой минимальной с.с. можно записать число так\n"+Integer.toString(number));//вывод задания
        searched=Integer.toString(Math.max(number%10,number/10)+1);//ответ
    }

    //Level 2
    public void level2Exercise(){
        f = true;
        int base=rand.nextInt(8)+2;//основание системы счисления
        int des=rand.nextInt(base);//1 разряд
        int ed=rand.nextInt(base);//0 разряд
        exercise.setText("Какое число будет следующим?\n"+String.valueOf(des * 10 + ed)+" ("+String.valueOf(Integer.toString(base))+")");//вывод задания
        if (ed<base-1) searched=Integer.toString(des*10+ed+1);//если записано число нулевой разряд которого меньше чем, самая большая цифра системы счисления
        else if (des<base-1) searched=Integer.toString((des+1)*10) ;//если записано число с нулевым разрядом равным самомй большой цифре с.с., но 1й разряд меньше
        else searched="100";
    }

    //Level 3
    public void level3Exercise(){
        f = true;

        int base=rand.nextInt(8)+2;
        int number;
        if(base<4) number=rand.nextInt(16)+1;
        else if (base<6) number=rand.nextInt(48)+3;
        else if(base<8) number=rand.nextInt(112)+5;
        else number=rand.nextInt(240)+7;
        exercise.setText("Переведите из 10й с.с.\n"+String.valueOf(number)+" в ("+String.valueOf(base)+")");
        searched = Integer.toString(InOtherSystem(base, number));
    }

    //Номер 4
    public void level4Exercise(){
        f = true;

        int base=rand.nextInt(6)+11;
        int number=rand.nextInt(100)+1;
        exercise.setText("Переведите из 10й с.с.\n"+Integer.toString(number)+" в ("+Integer.toString(base)+")");
        searched=InOtherSystem11_16(base, number);
    }

    //Номер 5
    public void level5Exercise(){
        f = true;
        while( base > number) {
            base = (int) (Math.random() * 10);
            number = (int) (Math.random() * 100);
        }
        if(base==1||base==10){
            base=2;
        }
        if(base==0){
            base=16;
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

    //Номер 6
    public void level6Exercise(){
        f = true;

        base  = (int) (Math.random() * 10);
        number = (int) (Math.random() * 100);



        if(base >= 0 && base <= 4){
            base = 2;
        }
        if (base >=5 && base <= 7){
            base = 8;
        }
        if (base >= 8 && base <=10){
            base = 16;
        }

        if (number > 30){
            number = number - number/2;
        }
        if (number % 2 == 0){
            flag = true;
        }
        if (number % 2 !=0){
            flag = false;
        }

        if(base == 2) {
            if (flag) {
                exercise.setText(Integer.toBinaryString(base) + "(2) " + " в (8)");
                searched = Integer.toOctalString(number);
            } else {
                exercise.setText(Integer.toBinaryString(base) + "(2) " + " в (16)");
                searched = Integer.toHexString(number);

            }
        }

        if (base == 8) {
            if (flag) {
                exercise.setText(Integer.toBinaryString(base) + "(8) " + " в (2)");
                searched = Integer.toBinaryString(number);
            } else {
                exercise.setText(Integer.toBinaryString(base) + "(8) " + " в (16)");
                searched = Integer.toHexString(number);
            }
        }
        if (base == 16) {
            if (flag) {
                exercise.setText(Integer.toBinaryString(base) + "(2) " + " в (8)");
                searched = Integer.toOctalString(number);
            } else {
                exercise.setText(Integer.toBinaryString(base) + "(16) " + " в (2)");
                searched = Integer.toBinaryString(number);
            }
        }

    }

    //Level 7
    public void level7Exercise(){
        f = true;

        int base = rand.nextInt(16);
        int Num1 = 0;
        int Num2 = 0;
        if (localScore < 3){
            Num1 = rand.nextInt(100);
            Num2 = rand.nextInt(100);
        }
        if ((localScore > 3)&&(localScore <6))
        {
            Num1 = rand.nextInt(500);
            Num2 = rand.nextInt(500);
        }
        if (localScore > 6){
            Num1 = rand.nextInt(1000);
            Num2 = rand.nextInt(1000);
        }
        int Num1_1 = InOtherSystem(base, Num1);
        int Num2_1 = InOtherSystem(base,Num2);                  //задание

        exercise.setText(Integer.toString(Num1_1)+"("+base+")+"+Integer.toString(Num2_1)+"("+base+")=");  //вывод задания

        searched = Integer.toString(InOtherSystem(base,Num1+Num2));  //ответ
    }

    //Level 8
    public void level8Exercise(){
        f = true;

        int base = rand.nextInt(15)+1;
        int Num1 = 0;
        int Num2 = 0;
        do {
            if (localScore < 3){
                Num1 = rand.nextInt(100);
                Num2 = rand.nextInt(100);
            }
            if ((localScore > 3)&&(localScore <6))
            {
                Num1 = rand.nextInt(500);
                Num2 = rand.nextInt(500);
            }
            if (localScore > 6){
                Num1 = rand.nextInt(1000);
                Num2 = rand.nextInt(1000);
            }
        } while (Num1>Num2);
        int Num1_1 = InOtherSystem(base,Num1);
        int Num2_1 = InOtherSystem(base,Num2);               //задание

        exercise.setText(Integer.toString(Num1_1)+"("+base+")-"+Integer.toString(Num2_1)+"("+base+")=");  //вывод задания

        searched = Integer.toString(InOtherSystem(base,Num1-Num2));  //ответ
    }

 //Level 9
    public void level9Exercise(){
        f = true;
        int n1 = rand.nextInt(49)+1;
        int n2 = rand.nextInt(24)+1;
        int key = n1*n2;
        int base = rand.nextInt(15)+1;
        while (base == 10){
            base = rand.nextInt(15)+1;
        }
        if (base < 10){
            exercise.setText(Integer.toString(InOtherSystem(base,n1))+"("+base+")/"+Integer.toString(InOtherSystem(base,n1))+"("+base+")=");  //вывод задания

            searched = Integer.toString(InOtherSystem(base,key));
        }
        else {
            exercise.setText(InOtherSystem11_16(base,n1)+"("+base+")/"+InOtherSystem11_16(base,n1)+"("+base+")=");  //вывод задания

            searched = InOtherSystem11_16(base,key);

        }

    }

    //Level 10
    public void level10Exercise(){
        f = true;

        int numb1 = rand.nextInt(99)+1;
        int n1 = rand.nextInt(49)+1;
        int key = rand.nextInt(24)+1;
        int n2 = n1*key;
        int base = rand.nextInt(15)+1;
        while (base == 10){
            base = rand.nextInt(15)+1;
        }
        if (base < 10){
            exercise.setText(Integer.toString(InOtherSystem(base,n1))+"("+base+")/"+Integer.toString(InOtherSystem(base,n1))+"("+base+")=");  //вывод задания

            searched = Integer.toString(InOtherSystem(base,key));
        }
        else {
            exercise.setText(InOtherSystem11_16(base,n1)+"("+base+")/"+InOtherSystem11_16(base,n1)+"("+base+")=");  //вывод задания

            searched = InOtherSystem11_16(base,key);

        }

    }
    //Проверка любого номера
    public void checkAnswer(View v) {
        String answerCheck = answer.getText().toString();
       if (f) {
           if (answerCheck.equals(searched)) {
               answer.setBackgroundColor(Color.rgb(154, 252, 85));
               localScore++;
               next.setText(localScore + " из 10 \n  Next");
               f = !f;
               setLocalScore(levelVariable);
           } else {
               answer.setBackgroundColor(Color.rgb(255, 112, 112));
               f =!f;
           }
       }
    }

    //Кнопка Next
    public void nextExercise(View v){
        answer.setBackgroundColor(Color.TRANSPARENT);
        answer.setText("");

        if (localScore > 10) {
            sPref = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString(SAVED_VALUE,Integer.toString(levelVariable));
            ed.apply();

            localScore = 0;
              setLocalScore(levelVariable);
            Intent level = new Intent(this,LevelActivity.class);
              startActivity(level);
        }
            switch (levelVariable) {
                case 1:
                    level1Exercise();
                    break;
                case 2:
                    level2Exercise();
                    break;
                case 3:
                    level3Exercise();
                    break;
                case 4:
                    level4Exercise();
                    break;
                case 5:
                    level5Exercise();
                    break;
                case 6:
                    level6Exercise();
                    break;
                case 7:
                    level7Exercise();
                    break;
                case 8:
                    level8Exercise();
                    break;
                case 9:
                    level9Exercise();
                    break;
                case 10:
                    level10Exercise();
                    break;

            }


        }
    }
