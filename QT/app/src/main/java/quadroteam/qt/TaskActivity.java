package quadroteam.qt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Random;


public class TaskActivity extends AppCompatActivity {

    SharedPreferences sPref;
    static private String SAVED_VALUE = "saved_value";

    static private String SAVED_UNLIM_1 = "saved_unlim_1";
    static private String SAVED_UNLIM_2 = "saved_unlim_2";
    static private String SAVED_UNLIM_3 = "saved_unlim_3";
    static private String SAVED_UNLIM_4 = "saved_unlim_4";
    static private String SAVED_UNLIM_5 = "saved_unlim_5";
    static private String SAVED_UNLIM_6 = "saved_unlim_6";
    static private String SAVED_UNLIM_7 = "saved_unlim_7";
    static private String SAVED_UNLIM_8 = "saved_unlim_8";

    static private String SAVED_LVL_1 = "saved_value1";
    static private String SAVED_LVL_2 = "saved_value2";
    static private String SAVED_LVL_3 = "saved_value3";
    static private String SAVED_LVL_4 = "saved_value4";
    static private String SAVED_LVL_5 = "saved_value5";
    static private String SAVED_LVL_6 = "saved_value6";
    static private String SAVED_LVL_7 = "saved_value7";
    static private String SAVED_LVL_8 = "saved_value8";

    static private String TRIES_LVL_1 = "saved_value9";
    static private String TRIES_LVL_2 = "saved_value10";
    static private String TRIES_LVL_3 = "saved_value11";
    static private String TRIES_LVL_4 = "saved_value12";
    static private String TRIES_LVL_5 = "saved_value14";
    static private String TRIES_LVL_6 = "saved_value15";
    static private String TRIES_LVL_7 = "saved_value16";
    static private String TRIES_LVL_8 = "saved_value17";

    int localScore,amountOfTries;
    int maxUnlimValue = 0,unlimValue = 0;
    int  base, number,levelVariable;
    boolean f,flag = true,hardcore = false, nextUnlim = true;
    String temp = "",searched;
    TextView exercise, score;
    EditText answer;
    ImageButton answerButton;
    Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        exercise = (TextView)findViewById(R.id.textExercise);
        answer = (EditText)findViewById(R.id.textAnswer);  answer.setBackgroundColor(Color.TRANSPARENT);
        answerButton = (ImageButton)findViewById(R.id.check);
        score=(TextView)findViewById(R.id.point);

        h=new Handler();

        hardcore = getIntent().getBooleanExtra("Hardcore",false);
        levelVariable = getIntent().getIntExtra("lvl", 1);

        sPref = getPreferences(MODE_PRIVATE);

        getLocalScore(levelVariable);getTries(levelVariable);
        score.setGravity(Gravity.CENTER);
        if (!hardcore) {
            score.setText("Попыток:" + amountOfTries + "" +
                    "\nОчков:" + localScore + "/10");
        }
        if (hardcore){
            score.setText("Рекорд: "  + maxUnlimValue + " Очки: 0");
        }
        // setAllZero();
        switch(levelVariable){
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

        }


    }

    //Methods

    private void setAllZero (){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();

        ed.putString(SAVED_LVL_1, "0");
        ed.putString(SAVED_LVL_2, "0");
        ed.putString(SAVED_LVL_3, "0");
        ed.putString(SAVED_LVL_4, "0");
        ed.putString(SAVED_LVL_5, "0");
        ed.putString(SAVED_LVL_6, "0");
        ed.putString(SAVED_LVL_8, "0");
        ed.putString(SAVED_LVL_7, "0");

        ed.putString(TRIES_LVL_1,"0");
        ed.putString(TRIES_LVL_2,"0");
        ed.putString(TRIES_LVL_3,"0");
        ed.putString(TRIES_LVL_4,"0");
        ed.putString(TRIES_LVL_5,"0");
        ed.putString(TRIES_LVL_6,"0");
        ed.putString(TRIES_LVL_7,"0");
        ed.putString(TRIES_LVL_8,"0");

        ed.apply();
    }

    private void setLocalScore (int levelVariable){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        switch (levelVariable){
            case 1: ed.putString(SAVED_LVL_1, Integer.toString(localScore));

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
        }

    }

    private void setTries (int levelVariable){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        switch (levelVariable){
            case 1: ed.putString(TRIES_LVL_1, Integer.toString(amountOfTries));

                break;
            case 2: ed.putString(TRIES_LVL_2, Integer.toString(amountOfTries));

                break;
            case 3: ed.putString(TRIES_LVL_3, Integer.toString(amountOfTries));


                break;
            case 4: ed.putString(TRIES_LVL_4, Integer.toString(amountOfTries));

                break;
            case 5: ed.putString(TRIES_LVL_5, Integer.toString(amountOfTries));

                break;
            case 6: ed.putString(TRIES_LVL_6, Integer.toString(amountOfTries));

                break;
            case 7: ed.putString(TRIES_LVL_7, Integer.toString(amountOfTries));

                break;
            case 8: ed.putString(TRIES_LVL_8, Integer.toString(amountOfTries));

                break;

        }
        ed.commit();
    }

    private void getTries (int levelVariable){
        sPref = getPreferences(MODE_PRIVATE);
        switch (levelVariable){
            case 1: amountOfTries = Integer.parseInt(sPref.getString(TRIES_LVL_1,"0"));
                break;
            case 2: amountOfTries = Integer.parseInt(sPref.getString(TRIES_LVL_2,"0"));
                break;
            case 3: amountOfTries = Integer.parseInt(sPref.getString(TRIES_LVL_3,"0"));
                break;
            case 4: amountOfTries = Integer.parseInt(sPref.getString(TRIES_LVL_4,"0"));
                break;
            case 5: amountOfTries = Integer.parseInt(sPref.getString(TRIES_LVL_5,"0"));
                break;
            case 6: amountOfTries = Integer.parseInt(sPref.getString(TRIES_LVL_6,"0"));
                break;
            case 7: amountOfTries = Integer.parseInt(sPref.getString(TRIES_LVL_7,"0"));
                break;
            case 8: amountOfTries = Integer.parseInt(sPref.getString(TRIES_LVL_8,"0"));
                break;
        }
    }

    private void setMaxUnlimPoints (int levelVariable){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        switch (levelVariable){
            case 1: ed.putString(SAVED_UNLIM_1, Integer.toString(maxUnlimValue));

                break;
            case 2: ed.putString(SAVED_UNLIM_2, Integer.toString(maxUnlimValue));

                break;
            case 3: ed.putString(SAVED_UNLIM_3, Integer.toString(maxUnlimValue));

                break;
            case 4: ed.putString(SAVED_UNLIM_4, Integer.toString(maxUnlimValue));

                break;
            case 5: ed.putString(SAVED_UNLIM_5, Integer.toString(maxUnlimValue));

                break;
            case 6: ed.putString(SAVED_UNLIM_6, Integer.toString(maxUnlimValue));

                break;
            case 7: ed.putString(SAVED_UNLIM_7, Integer.toString(maxUnlimValue));

                break;
            case 8: ed.putString(SAVED_UNLIM_8, Integer.toString(maxUnlimValue));

                break;

        }
        ed.apply();
    }

    private void getMaxUnlimPoints (int levelVariable){
        sPref = getPreferences(MODE_PRIVATE);
        switch (levelVariable){
            case 1: maxUnlimValue = Integer.parseInt(sPref.getString(SAVED_UNLIM_1,"0"));
                break;
            case 2: maxUnlimValue = Integer.parseInt(sPref.getString(SAVED_UNLIM_2,"0"));
                break;
            case 3: maxUnlimValue = Integer.parseInt(sPref.getString(SAVED_UNLIM_3,"0"));
                break;
            case 4: maxUnlimValue = Integer.parseInt(sPref.getString(SAVED_UNLIM_4,"0"));
                break;
            case 5: maxUnlimValue = Integer.parseInt(sPref.getString(SAVED_UNLIM_5,"0"));
                break;
            case 6: maxUnlimValue = Integer.parseInt(sPref.getString(SAVED_UNLIM_6,"0"));
                break;
            case 7: maxUnlimValue = Integer.parseInt(sPref.getString(SAVED_UNLIM_7,"0"));
                break;
            case 8: maxUnlimValue = Integer.parseInt(sPref.getString(SAVED_UNLIM_8,"0"));
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
            if(residual>9) residual+=(int)'A'-10;
            else residual+=(int)'0';
            answer+=(char)residual;
            number/=base;
        }
        String result = "";
        for (int i = answer.length() - 1; i >= 0; i--)
        {
            result = result + answer.substring(i, i+1);
        }

        return result;
    }

    Random rand = new Random();

    //Levels

    //Level 1
    public void level1Exercise(){
        f = true;
        int number=rand.nextInt(99)+1;//задание
        exercise.setText("В какой минимальной с.с. можно записать число так:\n"+Integer.toString(number));//вывод задания
        searched=Integer.toString(Math.max(number%10,number/10)+1);//ответ
    }

    //Level 2
    public void level2Exercise(){
        f = true;
        int base=rand.nextInt(8)+2;//основание системы счисления
        int des=rand.nextInt(base-1)+1;//1 разряд
        int ed=rand.nextInt(base-1)+1;//0 разряд
        exercise.setText("Какое число будет следующим?\n"+String.valueOf(des * 10 + ed)+" ("+String.valueOf(Integer.toString(base))+")");//вывод задания
        if (ed<base-1) searched=Integer.toString(des*10+ed+1);//если записано число нулевой разряд которого меньше чем, самая большая цифра системы счисления
        else if (des<base-1) searched=Integer.toString((des+1)*10) ;//если записано число с нулевым разрядом равным самомй большой цифре с.с., но 1й разряд меньше
        else searched="100";
    }

    //Level 3
    public void level3Exercise(){
        f = true;
        int base=rand.nextInt(8)+2;//генерация основания системы счисления в диапазоне от 2 до 9 включительно
        int number;
        if(base<4) number=rand.nextInt(16)+1; //правила генерации числа для сгенерированной системы счисления
        else if (base<6) number=rand.nextInt(48)+3;
        else if(base<8) number=rand.nextInt(112)+5;
        else number=rand.nextInt(240)+7;
        exercise.setText("Переведите из 10й с.с.\n"+String.valueOf(number)+" в ("+String.valueOf(base)+")"); //вывод задания
        searched = Integer.toString(InOtherSystem(base, number)); //запись правильного ответа в строку searched
    }

    //Номер 4
    public void level4Exercise(){
        f = true;
        int base=rand.nextInt(6)+11; //генерация основания системы счисления
        int number=rand.nextInt(100)+1; //генерация числа
        exercise.setText("Переведите из 10й с.с.\n"+Integer.toString(number)+" в ("+Integer.toString(base)+")"); //вывод задания
        searched=InOtherSystem11_16(base, number);//запись правильного ответа в строку searched
    }

    //Номер 5
    public void level5Exercise(){
        f = true;
        temp = "";
        number = -2;
        base = -1;
        while( base > number) {
            base = (int) (Math.random() * 10 + 1);
            number = (int) (Math.random() * 100 + 1);
        }
        if(base == 1 || base >= 10){
            base = rand.nextInt(5) + 11;
            temp = InOtherSystem11_16(base,number);
        }else{
            temp = String.valueOf(InOtherSystem(base,number));
        }
        exercise.setText("Переведите "+temp+"("+base+")\n в 10-ю");
        searched = Integer.toString(number);
    }

    //Номер 6
    public void level6Exercise(){
        f = true;

        base  = (int) (Math.random() * 10);
        number = (int) (Math.random() * 100);

        if(base >= 0 && base <= 6){
            base = 2;
        }
        if (base >=7 && base <= 8){
            base = 8;
        }
        if (base >= 9 && base <=10){
            base = 16;
        }

        if (number > 80){
            number-=10;
        }

        if(base == 2) {
            flag = number % 2 == 0;

            if (flag) {
                exercise.setText(Integer.toBinaryString(number) + "(2) " + " в (8)");
                searched = Integer.toOctalString(number);
            } else {
                exercise.setText(Integer.toBinaryString(number) + "(2) " + " в (16)");
                searched = Integer.toHexString(number).toUpperCase();
            }
        }

        if (base == 8) {
            exercise.setText(Integer.toOctalString(number) + "(8) " + " в (2)");
            searched = Integer.toBinaryString(number);
        }

        if (base == 16) {
            exercise.setText(Integer.toHexString(number).toUpperCase() + "(16) " + " в (2)");
            searched = Integer.toBinaryString(number);
        }
    }

    //Level 7
    public void level7Exercise(){
        f = true;

        int base = rand.nextInt(15)+2;
        int Num1 = 0;
        int Num2 = 0;
        if (localScore < 3){
            Num1 = rand.nextInt(99)+1;
            Num2 = rand.nextInt(99)+1;
        }
        if ((localScore > 3)&&(localScore <6))
        {
            Num1 = rand.nextInt(499)+1;
            Num2 = rand.nextInt(499)+1;
        }
        if (localScore > 6){
            Num1 = rand.nextInt(999)+1;
            Num2 = rand.nextInt(999)+1;
        }
        if (base<10){ //задание
            int Num1_1 = InOtherSystem(base,Num1);
            int Num2_1 = InOtherSystem(base,Num2);
            exercise.setText(Integer.toString(Num1_1)+"("+base+")+"+Integer.toString(Num2_1)+"("+base+")=");  //вывод задания
            searched = Integer.toString(InOtherSystem(base,Num1+Num2));  //ответ
        }
        else {
            String Num1_1=InOtherSystem11_16(base,Num1);
            String Num2_1=InOtherSystem11_16(base,Num2);
            exercise.setText(Num1_1+"("+base+")+"+Num2_1+"("+base+")=");  //вывод задания
            searched=InOtherSystem11_16(base, Num1 + Num2);
        }
    }

    //Level 8
    public void level8Exercise(){
        f = true;

        int base = rand.nextInt(15)+2;
        int Num1 = 0;
        int Num2 = 0;
        do {
            if (localScore < 3){
                Num1 = rand.nextInt(99)+1;
                Num2 = rand.nextInt(99)+1;
            }
            if ((localScore > 3)&&(localScore <6))
            {
                Num1 = rand.nextInt(499)+1;
                Num2 = rand.nextInt(499)+1;
            }
            if (localScore > 6){
                Num1 = rand.nextInt(999)+1;
                Num2 = rand.nextInt(999)+1;
            }
        } while (Num1<Num2);
        if (base<10){ //задание
            int Num1_1 = InOtherSystem(base,Num1);
            int Num2_1 = InOtherSystem(base,Num2);
            exercise.setText(Integer.toString(Num1_1)+"("+base+")-"+Integer.toString(Num2_1)+"("+base+")=");  //вывод задания
            searched = Integer.toString(InOtherSystem(base,Num1-Num2));  //ответ
        }
        else {
            String Num1_1=InOtherSystem11_16(base,Num1);
            String Num2_1=InOtherSystem11_16(base,Num2);
            exercise.setText(Num1_1 +"("+base+")-"+Num2_1+"("+base+")=");  //вывод задания
            searched=InOtherSystem11_16(base,Num1-Num2);
        }
    }


//Level 9
   public void level9Exercise(){
        f = true;
        int n1 = rand.nextInt(29)+1;
        int n2 = rand.nextInt(24)+1;
        int key = n1*n2;
        int base = rand.nextInt(14)+2;
        while (base == 10){
            base = rand.nextInt(14)+2;
        }
        if (base < 10){
            exercise.setText(Integer.toString(InOtherSystem(base,n1))+"("+base+")*"+Integer.toString(InOtherSystem(base,n2))+"("+base+")=");  //вывод задания

            searched = Integer.toString(InOtherSystem(base,key));
        }
        else {
            exercise.setText(InOtherSystem11_16(base,n1)+"("+base+")*"+InOtherSystem11_16(base,n2)+"("+base+")=");  //вывод задания

            searched = InOtherSystem11_16(base,key);

        }

    }

    //Level 10
    public void level10Exercise(){
        f = true;
        int numb1 = rand.nextInt(99)+2;
        int n1 = rand.nextInt(29)+2;
        int key = rand.nextInt(24)+2;
        int n2 = n1*key;
        int base = rand.nextInt(14)+2;
        while (base == 10){
            base = rand.nextInt(14)+2;
        }
        if (base < 10){
            exercise.setText(Integer.toString(InOtherSystem(base,n2))+"("+base+")/"+Integer.toString(InOtherSystem(base,n1))+"("+base+")=");  //вывод задания

            searched = Integer.toString(InOtherSystem(base,key));
        }
        else {
            exercise.setText(InOtherSystem11_16(base,n2)+"("+base+")/"+InOtherSystem11_16(base,n1)+"("+base+")=");  //вывод задания

            searched = InOtherSystem11_16(base,key);

        }

    }

    public void tower() //Ханойские башни
    {
        f = true;
        if (localScore<3){
            int n=rand.nextInt(8)+3;
            exercise.setText("Сколько нужно действий для перекладывания "+n+" колец");
            n=(int)Math.pow(2,n)-1;
            searched=""+n;
        }
        else {
            int n=rand.nextInt(126)+3;
            exercise.setText("Какое кольцо будет переложенно на "+n+" ходе");
            n=InOtherSystem(2,n);
            int countn=1;
            while(n%10!=1)
            {
                n/=10;
                countn++;
            }
            searched=""+countn;
        }
    }

    Runnable check=new Runnable() {
        @Override
        public void run() {
            String answerCheck = answer.getText().toString().toUpperCase();
            amountOfTries++;
            if (hardcore) {
                if (answerCheck.isEmpty()) {
                    nextUnlim = false;
                }
            }
            //Проверка на пустоту
            if (!answerCheck.isEmpty()) {
                if (f) {
                    answerButton.setClickable(false);

                    if (answerCheck.equals(searched)) { //сравнение строки searched, в которой содержится правильный ответ со строкой answerCheck (ответ пользователя)
                        answer.setBackgroundColor(Color.rgb(154, 252, 85)); //поле ввода изменяет цвет в случае правильного ответа
                        f = !f;
                        if (!hardcore) {
                            //Нормальная работа при выключенном хардеор-режиме
                            localScore++; //увеличение счета на балл
                            amountOfTries++;
                            setLocalScore(levelVariable);
                            setTries(levelVariable);
                        } else {
                            //Увеличение только при включенном хардкор-режиме
                            unlimValue++;
                        }
                    } else {
                        answer.setBackgroundColor(Color.rgb(211, 39, 63)); //поле ввода изменяет свой цвет в случае неправильного ответа
                        answer.setTextColor(Color.rgb(255, 255, 231));
                        answer.setText("Неправильно");
                        f=!f;
                        if (!hardcore) {
                            amountOfTries++;
                            setTries(levelVariable);
                            if (hardcore) {
                                nextUnlim = false;
                            }
                        }


                    }

                }
            }
            if (!hardcore) {
                score.setText("Попыток:" + amountOfTries +
                        "\nОчков:" + localScore + "/10"); //вывод текущего счета
            } else {
                score.setText("Рекорд: " + maxUnlimValue + "  Очки: " + amountOfTries);
            }
        }
    };
    Runnable task=new Runnable() {
        @Override
        public void run() {
            nextExercise();
        }
    };

    //Проверка любого номера
    public void checkAnswer(View v) {
        h.post(check);
        h.postDelayed(task, 1000);

    }


    //Counter
    public void nextExercise() {
        base = 0;
        number = 0;
        answer.setBackgroundColor(Color.TRANSPARENT);
        answer.setTextColor(Color.rgb(45, 30, 59));
        answer.setText("");
        answerButton.setClickable(true);

        if (!hardcore) {
            if (localScore >= 10) {
                sPref = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.putString(SAVED_VALUE, Integer.toString(levelVariable));
                ed.apply();
                localScore = 0;
                setLocalScore(levelVariable);
                amountOfTries = 0;
                setTries(levelVariable);
                Intent level = new Intent(getApplicationContext(), LevelActivity.class);
                startActivity(level);
            }
            if (localScore < 10) {
                nextTask(levelVariable);
            }
        } else {
            if (nextUnlim) {
                setMaxUnlimPoints(levelVariable);
                nextTask(levelVariable);
            } else {
                setMaxUnlimPoints(levelVariable);
                Intent i = new Intent(this, UnlimitedActivity.class);
                getMaxUnlimPoints(levelVariable);
                i.putExtra("Scores", maxUnlimValue);
                startActivity(i);
            }
        }
    }
        public void nextTask (int levelVariable){
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

            }
        }
}


