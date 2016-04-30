package quadroteam.qt;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class LibActivity extends AppCompatActivity {

    int a;

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
}
