package quadroteam.qt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.logging.Level;

public class LevelActivity extends AppCompatActivity {

   //variables
    int a;
    int starsAmount,levelVariable;
    Boolean hardcore = false;
    SharedPreferences sPref;
    Intent i;
    ListView list;

    private static String SAVED_STARS_1 = "1";
    private static String SAVED_STARS_2 = "2";
    private static String SAVED_STARS_3 = "3";
    private static String SAVED_STARS_4 = "4";
    private static String SAVED_STARS_5 = "5";
    private static String SAVED_STARS_6 = "6";
    private static String SAVED_STARS_7 = "7";
    private static String SAVED_STARS_8 = "8";
    private static String SAVED_STARS_9 = "9";
    private static String SAVED_STARS_10 = "10";
    private static String SAVED_STARS_11 = "11";

    Integer [] imageID = {

            R.drawable.lvl1bt,
            R.drawable.lvl2bt,
            R.drawable.lvl3bt,
            R.drawable.lvl4bt,
            R.drawable.lvl5bt,
            R.drawable.lvl6bt,
            R.drawable.lvl7bt,
            R.drawable.lvl8bt,
            R.drawable.lvl9bt,
            R.drawable.lvl10bt,
            R.drawable.hanoy

    };

    Integer IDs[] = new Integer[imageID.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        hardcore = getIntent().getBooleanExtra("Hardcore",false);

        //Stars
        starsAmount = getIntent().getIntExtra("Stars", 1);
        levelVariable = getIntent().getIntExtra("levelSTARS",0);
        int copy_amount = starsAmount;

        getStars(levelVariable);

          if (copy_amount!=0 && copy_amount > starsAmount ){
              starsAmount = copy_amount;
              setStars(levelVariable);
          }

        /**
           sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_STARS_1, Integer.toString(0));
        ed.apply();
        **/

        createArray();

        //List,Adapter,OnItemListener

        i = new Intent(getApplicationContext(),TaskActivity.class);
        CustomAdapter customAdapter = new CustomAdapter(this,imageID,IDs);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(customAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //If stars != 0 then choice
                if (IDs[position] != 0) {
                    i.putExtra("Hardcore", hardcore);
                    i.putExtra("lvl?", position+1);
                    startActivity(i);
                } else {
                // normal mod only
             startLVL(position + 1);
            }
           }
        });

    }


    public void startLVL(int key) {
        Intent i = new Intent(this, TheoryActivity.class);
        a = key;
        i.putExtra("lvl?", a);
        startActivity(i);

    }

    //Saves
    private void setStars (int levelVariable){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        switch (levelVariable){
            case 1: ed.putString(SAVED_STARS_1, Integer.toString(starsAmount));

                break;
            case 2: ed.putString(SAVED_STARS_2, Integer.toString(starsAmount));

                break;
            case 3: ed.putString(SAVED_STARS_3, Integer.toString(starsAmount));


                break;
            case 4: ed.putString(SAVED_STARS_4, Integer.toString(starsAmount));

                break;
            case 5: ed.putString(SAVED_STARS_5, Integer.toString(starsAmount));

                break;
            case 6: ed.putString(SAVED_STARS_6, Integer.toString(starsAmount));

                break;
            case 7: ed.putString(SAVED_STARS_7, Integer.toString(starsAmount));

                break;
            case 8: ed.putString(SAVED_STARS_8, Integer.toString(starsAmount));

                break;
            case 9: ed.putString(SAVED_STARS_9, Integer.toString(starsAmount));

                break;
            case 10: ed.putString(SAVED_STARS_10, Integer.toString(starsAmount));

                break;
            case 11: ed.putString(SAVED_STARS_11, Integer.toString(starsAmount));

                break;

        }
        ed.commit();
    }

    //Getter
    private void getStars (int levelVariable){
        sPref = getPreferences(MODE_PRIVATE);
        switch (levelVariable){
            case 1: starsAmount = Integer.parseInt(sPref.getString(SAVED_STARS_1,"0"));

                break;
            case 2: starsAmount = Integer.parseInt(sPref.getString(SAVED_STARS_2,"0"));

                break;
            case 3: starsAmount = Integer.parseInt(sPref.getString(SAVED_STARS_3,"0"));

                break;
            case 4: starsAmount = Integer.parseInt(sPref.getString(SAVED_STARS_4,"0"));

                break;
            case 5: starsAmount = Integer.parseInt(sPref.getString(SAVED_STARS_5,"0"));

                break;
            case 6: starsAmount = Integer.parseInt(sPref.getString(SAVED_STARS_6,"0"));
                break;

            case 7: starsAmount = Integer.parseInt(sPref.getString(SAVED_STARS_7,"0"));

                break;
            case 8: starsAmount = Integer.parseInt(sPref.getString(SAVED_STARS_8,"0"));

                break;
            case 9: starsAmount = Integer.parseInt(sPref.getString(SAVED_STARS_9,"0"));

                break;
            case 10: starsAmount = Integer.parseInt(sPref.getString(SAVED_STARS_10,"0"));

                break;
            case 11: starsAmount = Integer.parseInt(sPref.getString(SAVED_STARS_11,"0"));

                break;

        }
    }

    public Integer[] createArray(){

        for (int i = 0; i < IDs.length; i++){
            getStars(i+1);
            if (hardcore && starsAmount != 0) {
               IDs[i] = starsAmount;
            }else {
                IDs[i] = starsAmount;
            }
       }

        return IDs;
    }

    @Override
    public void onBackPressed () {
        //TODO Auto-generated method stub
        quitMethod();
    }

    private void quitMethod () {

        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                LevelActivity.this);
        quitDialog.setTitle("Вернуться в Главное меню?");

        quitDialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Intent level = new Intent(getApplicationContext(),MainMenuActivity.class);
                startActivity(level);

                finish();
            }
        });

        quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });

        quitDialog.show();

    }

}
