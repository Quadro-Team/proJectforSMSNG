package quadroteam.qt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class LibActivity extends AppCompatActivity {

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
            R.drawable.lvl1bt,
            R.drawable.hanoy

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        CustomAdapter customAdapter = new CustomAdapter(this,imageID);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(customAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                startThe(position + 1);
            }
        });


    }


    public void startThe(int key) {
        Intent i = new Intent(this, LibOfTheory.class);
        i.putExtra("lvl?", key);
        startActivity(i);

    }

    @Override
    public void onBackPressed () {
        //TODO Auto-generated method stub
        quitMethod();
    }

    private void quitMethod () {

        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                LibActivity.this);
        quitDialog.setTitle("Вернуться в меню уровней?");

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


/**
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
 }  **/