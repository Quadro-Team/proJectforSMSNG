package quadroteam.qt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UnlimitedActivity extends AppCompatActivity {
    int record;
TextView view;
    SharedPreferences sPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlimited);

        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();

        record = getIntent().getIntExtra("Max",0);

        view = (TextView) findViewById(R.id.scores);

        int scores = getIntent().getIntExtra("Scores",0);

        view.setText("Очков "+ scores + "\nРекорд: " + record);

    }

    public void toLevelMenu (View v)
    {
        Intent i = new Intent(getApplicationContext(),LevelActivity.class);
        i.putExtra("Hardcore",true);
        startActivity(i);
    }

}
