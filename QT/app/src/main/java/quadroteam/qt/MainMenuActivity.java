package quadroteam.qt;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainMenuActivity extends AppCompatActivity {
Button level,theory,developers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        level = (Button)findViewById(R.id.StG);
        theory = (Button)findViewById(R.id.lib);
        developers = (Button)findViewById(R.id.opt);
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
}
