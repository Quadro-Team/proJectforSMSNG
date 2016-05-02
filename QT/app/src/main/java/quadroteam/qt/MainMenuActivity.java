package quadroteam.qt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity  {
    static private String DIALOG_APPEARANCE = "dialog_appearance";
    String flag_First = "true";
    SharedPreferences sPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        try {
            flag_First = sPref.getString(DIALOG_APPEARANCE,"true");
        }catch (Exception e){
            flag_First = "true";
        }

        if(flag_First.equals("true")) {
            onShow();
            sPref = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString(DIALOG_APPEARANCE,"false");
            ed.commit();
        }
      }



    public void startLVLlist(View v){
        Intent i = new Intent(this, LevelActivity.class);
        startActivity(i);
    }

    public void TheoryList(View v){
        Intent i = new Intent(this, LibActivity.class);
        startActivity(i);
    }

    public void Developers(View v){
        Intent i = new Intent(this, DevelopersActivity.class);
        startActivity(i);
    }

    public void onShow() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainMenuActivity.this);
        builder.setTitle("Важное сообщение!")
                .setMessage("Добро пожаловать в Дзету\n" +
                        "Мы научим вас работать с разными системами счисления (дальше будем называть их сс для краткости)\n" +
                        "Для начала выберете уровень, прочитайте теорию и начните выполнять задания. Вы неограниченны во времени и в попытках, " +
                        "нужно лишь набрать 10 правильных ответов, и уровень пройден. Конечно, чтобы вам было интереснее, за каждый уровень начисляются" +
                        " звезды. Чем меньшее число заданий вы решите, набрав 10 очков, тем больше звезды вы получите\n")
                .setCancelable(false)
                .setNegativeButton("Понял!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }



}
