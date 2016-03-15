package quadroteam.qt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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


    int localScore;
    int  base, number,levelVariable;
    boolean f,flag,flagOfSwitch = true;
    String temp = "",searched;
    TextView exercise, score;
    EditText answer;
    ImageButton answerButton,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        exercise = (TextView)findViewById(R.id.textExercise);
        answer = (EditText)findViewById(R.id.textAnswer);  answer.setBackgroundColor(Color.TRANSPARENT);
        answerButton = (ImageButton)findViewById(R.id.check);
        next = (ImageButton)findViewById(R.id.next);
        score=(TextView)findViewById(R.id.point);


        levelVariable = getIntent().getIntExtra("lvl", 1);

        sPref = getPreferences(MODE_PRIVATE);

        getLocalScore(levelVariable);

       /* if (localScore != 0){
            next.setText(localScore + " из 10 \n  Next");
        }
        */
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
            //case 9: getLocalScore(levelVariable);
            //        level9Exercise();
            //    break;
            //case 10:getLocalScore(levelVariable);
            //level10Exercise();
            //    break;

        }
    }

        //Method
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
          //  case 9: ed.putString(SAVED_LVL_9,Integer.toString(localScore));

          //      break;
          // case 10:ed.putString(SAVED_LVL_10, Integer.toString(localScore));
          // break;
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
            //case 9: localScore = Integer.parseInt(sPref.getString(SAVED_LVL_9,"0"));
            //    break;
            //case 10: localScore = Integer.parseInt(sPref.getString(SAVED_LVL_10,"0"));
             //   break;
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

    Random rand=new Random();

    //Levels

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
                searched = Integer.toHexString(number);
            }
        }

        if (base == 8) {
                exercise.setText(Integer.toOctalString(number) + "(8) " + " в (2)");
                searched = Integer.toBinaryString(number);
        }

        if (base == 16) {
                exercise.setText(Integer.toHexString(number) + "(16) " + " в (2)");
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
            searched=InOtherSystem11_16(base,Num1+Num2);
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
            exercise.setText(Num1_1+"("+base+")-"+Num2_1+"("+base+")=");  //вывод задания
            searched=InOtherSystem11_16(base,Num1-Num2);
        }



    }


    //Проверка любого номера
    public void checkAnswer(View v) {
        String answerCheck = answer.getText().toString().toUpperCase();
        if (!answerCheck.isEmpty()) {
            if (f) {
               // flagOfSwitch = false;
                if (answerCheck.equals(searched)) { //сравнение строки searched, в которой содержится правильный ответ со строкой answerCheck (отвте пользователя)
                    answer.setBackgroundColor(Color.rgb(154, 252, 85)); //поле ввода изменяет цвет в случае правильного ответа
                    localScore++; //увеличение счета на балл
                     score.setText(localScore + "/10"); //вывод текущего счета
                    f = !f;
                    setLocalScore(levelVariable);
                } else {
                    answer.setBackgroundColor(Color.rgb(211, 39, 63)); //поле ввода изменяет свой цвет в случае неправильнго ответа
                    answer.setTextColor(Color.rgb(255, 255, 231));
                    //Toast.makeText(TaskActivity.this, searched.toUpperCase(), Toast.LENGTH_LONG).show();
                    f = !f;
                }
            }
        }
    }

  //  = answer.getText().toString().toUpperCase();


    //Кнопка Next
    public void nextExercise(View v){
        base = 0;
        number = 0;
        answer.setBackgroundColor(Color.TRANSPARENT);
        answer.setTextColor(Color.rgb(45, 30, 59));
        answer.setText("");

        if (localScore >= 10) {
            sPref = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString(SAVED_VALUE,Integer.toString(levelVariable));
            ed.apply();

            localScore = 0;
              setLocalScore(levelVariable);
            Intent level = new Intent(this,LevelActivity.class);
              startActivity(level);
        }
        if (localScore < 10) {
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
                //case 9:
                  //  level9Exercise();
                   // break;
                //case 10:
                //    level10Exercise();
                 //   break;

                }
            }
        }
    }



//Level 9
   /* public void level9Exercise(){
        f = true;
        int n1 = rand.nextInt(49)+1;
        int n2 = rand.nextInt(24)+1;
        int key = n1*n2;
        int base = rand.nextInt(15)+1;
        while (base == 10){
            base = rand.nextInt(15)+1;
        }
        if (base < 10){
            exercise.setText(Integer.toString(InOtherSystem(base,n1))+"("+base+")*"+Integer.toString(InOtherSystem(base,n2))+"("+base+")=");  //вывод задания

            searched = Integer.toString(InOtherSystem(base,key));
        }
        else {
            exercise.setText(InOtherSystem11_16(base,n1)+"("+base+")/"+InOtherSystem11_16(base,n2)+"("+base+")=");  //вывод задания

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
            exercise.setText(Integer.toString(InOtherSystem(base,n1))+"("+base+")/"+Integer.toString(InOtherSystem(base,n2))+"("+base+")=");  //вывод задания

            searched = Integer.toString(InOtherSystem(base,key));
        }
        else {
            exercise.setText(InOtherSystem11_16(base,n1)+"("+base+")/"+InOtherSystem11_16(base,n2)+"("+base+")=");  //вывод задания

            searched = InOtherSystem11_16(base,key);

        }

    } */
