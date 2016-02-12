package quadroteam.qt;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainMenuActivity extends AppCompatActivity {
Button level,theory,developers;
LinearLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        level = (Button)findViewById(R.id.StG);
        theory = (Button)findViewById(R.id.lib);
        developers = (Button)findViewById(R.id.opt);
        l=(LinearLayout)findViewById(R.id.root);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) l.setBackgroundResource(R.drawable.backgroundland);
       /* level.setBackgroundColor(Color.TRANSPARENT);
        theory.setBackgroundColor(Color.TRANSPARENT);
        developers.setBackgroundColor(Color.TRANSPARENT)*/
    }


    public void startLVLlist(View v){
        Intent i = new Intent(this, LevelActivity.class);
        startActivity(i);
    }
}
