package quadroteam.qt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.renderscript.Short4;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class LevelActivity extends AppCompatActivity implements  Dialog.Communicator {
    int a;
    int starsAmount,levelVariable;
    Boolean resultCommunicator  = false;
    SharedPreferences sPref;
    Dialog dialog;
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

    Integer [] imageID = {

            R.drawable.lvl1bt,
            R.drawable.lvl2bt,
            R.drawable.lvl3bt,
            R.drawable.lvl4bt,
            R.drawable.lvl5bt,
            R.drawable.lvl6bt,
            R.drawable.lvl7bt,
            R.drawable.lvl8bt

    };

    Integer IDs[] = new Integer[imageID.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
       setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        starsAmount = getIntent().getIntExtra("Stars", 0);
        levelVariable = getIntent().getIntExtra("levelSTARS",0);
        int copy_amount = starsAmount;

        getStars(levelVariable);

          if (copy_amount!=0 && copy_amount > starsAmount ){
              starsAmount = copy_amount;
              setStars(levelVariable);
          }
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_STARS_1, Integer.toString(2));

        createArray();
        dialog = new Dialog();
        i = new Intent(getApplicationContext(),TaskActivity.class);
        CustomAdapter customAdapter = new CustomAdapter(this,imageID,IDs);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(customAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (IDs[position] != 0) {
                    dialog.show(getFragmentManager(), "dialog");
                      if (resultCommunicator){
                          i.putExtra("Hardcore",true);
                      }else i.putExtra("Hardcore",false);

                } else {
                    startLVL(position + 1);
                }
            }
        });

    }



    public void startLVL(int key) {
        Intent i = new Intent(this, TheoryActivity.class);
        switch (key) {
            case 1:
                a = 1;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case 2:
                a = 2;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case 3:
                a = 3;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case 4:
                a = 4;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case 5:
                a = 5;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case 6:
                a = 6;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case 7:
                a = 7;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case 8:
                a = 8;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
        }
    }

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

        }
        ed.commit();
    }

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
        }
    }

    public Integer[] createArray(){

        for (int i = 0; i < IDs.length; i++){
            getStars(i+1);
            IDs[i] = starsAmount;
        }

        return IDs;
    }


    @Override
    public void onDialogMessage(Boolean hardocre) {
        resultCommunicator = hardocre;
    }
}
