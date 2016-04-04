package quadroteam.qt;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class LibActivity extends AppCompatActivity {

    int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void startThe(View v) {
        Intent i = new Intent(this, LibOfTheory.class);
        switch (v.getId()) {
            case R.id.lvl1:
                a = 1;
                i.putExtra("lib", a);
                startActivity(i);
                break;
            case R.id.lvl2:
                a = 2;
                i.putExtra("lib", a);
                startActivity(i);
                break;
            case R.id.lvl3:
                a = 3;
                i.putExtra("lib", a);
                startActivity(i);
                break;
            case R.id.lvl4:
                a = 4;
                i.putExtra("lib", a);
                startActivity(i);
                break;
            case R.id.lvl5:
                a = 5;
                i.putExtra("lib", a);
                startActivity(i);
                break;
            case R.id.lvl6:
                a = 6;
                i.putExtra("lib", a);
                startActivity(i);
                break;
            case R.id.lvl7:
                a = 7;
                i.putExtra("lib", a);
                startActivity(i);
                break;
            case R.id.lvl8:
                a = 8;
                i.putExtra("lib", a);
                startActivity(i);
                break;
        }
    }
}
