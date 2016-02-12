package quadroteam.qt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Map;
import java.util.Set;

public class LevelActivity extends AppCompatActivity {
        int a,key;SharedPreferences sPref;
        static String SAVED_VALUE = "saved_value";
   Button lvl1;
    Button lvl2;
    Button lvl3;
    Button lvl4;
    Button lvl5;
    Button lvl6;
    Button lvl7;
    Button lvl8;
    Button lvl9;
    Button lvl10;
    Boolean f = true;
    int savenum;
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        savenum = getIntent().getIntExtra("lvl", 1);
        lvl1 = (Button)findViewById(R.id.lvl1);
        lvl2 = (Button)findViewById(R.id.lvl2);
        lvl3 = (Button)findViewById(R.id.lvl3);
        lvl4 = (Button)findViewById(R.id.lvl4);
        lvl5 = (Button)findViewById(R.id.lvl5);
        lvl6 = (Button)findViewById(R.id.lvl6);
        lvl7 = (Button)findViewById(R.id.lvl7);
        lvl8 = (Button)findViewById(R.id.lvl8);
        lvl9 = (Button)findViewById(R.id.lvl9);
        lvl10 = (Button)findViewById(R.id.lvl10);
        l=(LinearLayout)findViewById(R.id.root);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) l.setBackgroundResource(R.drawable.backgroundland);

        sPref = getPreferences(MODE_PRIVATE);
        // key = Integer.parseInt(sPref.getString(SAVED_VALUE,String.valueOf(0))); ///Законченные уровни <---
        key = 10;
        switch (key){
            case 10: lvl10.setClickable(true);
            case 9:  lvl9.setClickable(true);
            case 8:  lvl8.setClickable(true);
            case 7:  lvl7.setClickable(true);
            case 6:  lvl6.setClickable(true);
            case 5:  lvl5.setClickable(true);
            case 4:  lvl4.setClickable(true);
            case 3:  lvl3.setClickable(true);
            case 2:  lvl2.setClickable(true);
            case 1:  lvl1.setClickable(true);

        }

    }

    public void startLVL(View v) {
        Intent i = new Intent(this, TheoryActivity.class);
        switch (v.getId()) {
            case R.id.lvl1:
                a = 1;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case R.id.lvl2:
                a = 2;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case R.id.lvl3:
                a = 3;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case R.id.lvl4:
                a = 4;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case R.id.lvl5:
                a = 5;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case R.id.lvl6:
                a = 6;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case R.id.lvl7:
                a = 7;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case R.id.lvl8:
                a = 8;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case R.id.lvl9:
                a = 9;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
            case R.id.lvl10:
                a = 10;
                i.putExtra("lvl?", a);
                startActivity(i);
                break;
        }
    }
}
