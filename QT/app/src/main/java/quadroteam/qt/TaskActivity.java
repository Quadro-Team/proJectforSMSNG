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

import java.util.Random;

public class TaskActivity extends AppCompatActivity {

    SharedPreferences sPref;
    final String SAVED_VALUE = "saved_value";
    final String SAVED_LOCAL_VALUE = "saved_local_value";

    int localScore = 0;
    int  base, number,i;
    int lev = 1;
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
        answer = (EditText)findViewById(R.id.textAnswer);
        answerButton = (Button)findViewById(R.id.check);
        next = (Button)findViewById(R.id.next);

        localScore = Integer.parseInt(sPref.getString(SAVED_LOCAL_VALUE,"0"));

        switch(getIntent().getIntExtra("lvl", 1)){
            case 1: level1Exercise();
                break;
            case 2: level2Exercise();
                break;
            case 3: level3Exercise();
                break;
            case 4: level4Exercise();
                break;
            case 5: level5Exercise();
                break;
            case 6: level6Exercise();
                break;
            case 7: level7Exercise();
                break;
            case 8: level8Exercise();
                break;
            case 9: level9Exercise();
                break;
            case 10: level10Exercise();
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
        exercise.setText("Какое число будет следующим?\n"+Integer.toString(des*10+ed)+" ("+Integer.toString(base)+")");//вывод задания
        if (ed<base-1) searched=Integer.toString(des*10+ed+1);//если записано число нулевой разряд которого меньше чем, самая большая цифра системы счисления
        else if (des<base-1) searched=Integer.toString((des+1)*10) ;//если записано число с нулевым разрядом равным самомй большой цифре с.с., но 1й разряд меньше
        else searched="100";
    }

    //Level 3
    public void level3Exercise(){
        f = true;

        int base=rand.nextInt(9)+2;
        int number;
        if(base<4) number=rand.nextInt(16)+1;
        else if (base<6) number=rand.nextInt(48)+3;
        else if(base<8) number=rand.nextInt(112)+5;
        else number=rand.nextInt(240)+7;
        exercise.setText("Переведите из 10й с.с.\n"+Integer.toString(number)+" в("+Integer.toString(base)+")");
        searched=Integer.toString(InOtherSystem(base, number));
    }

    //Номер 4
    public void level4Exercise(){
        f = true;

        int base=rand.nextInt(5)+11;
        int number=rand.nextInt(100)+1;
        exercise.setText("Переведите из 10й с.с.\n"+Integer.toString(number)+" в("+Integer.toString(base)+")");
        searched=InOtherSystem11_16(base, number);
    }

    //Номер 5
    public void level5Exercise(){
        f = true;

        base=(int)(Math.random()*10);
        number=(int)(Math.random()*100);

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

        int numb1 = rand.nextInt(99)+1;
        int numb2 = rand.nextInt(49)+1;
        int base = rand.nextInt(15)+1;
        while (numb2>numb1){
            numb1 = rand.nextInt(99)+1;
            numb2 = rand.nextInt(49)+1;
            break;
        }

        int a = numb1;
        int b;
        String temp2 = "";

        while (a > 1) {
            if (a > base) {
                b = a % base;
                temp2 = b + temp;
                a = a / base;

            } else {
                b = a % base;
                temp2 = b + temp;
                break;
            }
        }
        a = numb2;
        String temp1 = "";

        while (a > 1) {
            if (a > base) {
                b = a % base;
                temp1 = b + temp;
                a = a / base;

            } else {
                b = a % base;
                temp1 = b + temp;
                break;
            }
        }
        int right = numb1*numb2;
        a = numb1;
        String temp3 = "";

        while (a > 1) {
            if (a > base) {
                b = a % base;
                temp3 = b + temp;
                a = a / base;

            } else {
                b = a % base;
                temp3 = b + temp;
                break;
            }
        }
        exercise.setText(temp1+"("+base+")*"+temp2+"("+base+")=");//вывод задания
        searched = temp3;//ответ

    }

    //Level 10
    public void level10Exercise(){
        f = true;

        int numb1 = rand.nextInt(99)+1;
        int numb2 = rand.nextInt(49)+1;
        int base = rand.nextInt(15)+1;
        while (numb2>numb1){
            numb1 = rand.nextInt(99)+1;
            numb2 = rand.nextInt(49)+1;
            break;
        }

        int a = numb1;
        int b;
        String temp2 = "";

        while (a > 1) {
            if (a > base) {
                b = a % base;
                temp2 = b + temp;
                a = a / base;

            } else {
                b = a % base;
                temp2 = b + temp;
                break;
            }
        }
        a = numb2;
        String temp1 = "";

        while (a > 1) {
            if (a > base) {
                b = a % base;
                temp1 = b + temp;
                a = a / base;

            } else {
                b = a % base;
                temp1 = b + temp;
                break;
            }
        }
        int right = numb1/numb2;
        a = numb1;
        String temp3 = "";

        while (a > 1) {
            if (a > base) {
                b = a % base;
                temp3 = b + temp;
                a = a / base;

            } else {
                b = a % base;
                temp3 = b + temp;
                break;
            }
        }
        exercise.setText(temp1+"("+base+")/"+temp2+"("+base+")=");//вывод задания
        searched = temp3;//ответ

    }

    //Проверка любого номера
    public void checkAnswer(View v) {
        String answerCheck = answer.getText().toString();
       if (f) {
           if (answerCheck.equals(searched)) {
               answer.setBackgroundColor(Color.rgb(154, 252, 85));
               localScore++;
               next.setText(localScore + " из 10 \n   Next");
               f = !f;
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
        if (localScore < 10) {
            i = getIntent().getIntExtra("lvl", 1);
        }else {
            Intent level = new Intent(this,LevelActivity.class);
            Intent intent = new Intent(this, LevelActivity.class);
            intent.putExtra("save", true);
            intent.putExtra("savenum", getIntent().getIntExtra("lvl", 1));
            next.setText("Next");
                int levelDoneVariable = getIntent().getIntExtra("lvl",1);
            sPref = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString(SAVED_LOCAL_VALUE,Integer.toString(localScore));
            ed.commit();
            ed.putString(SAVED_VALUE,Integer.toString(levelDoneVariable));
            ed.commit();
            startActivity(level);
        }
            switch (i) {
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

