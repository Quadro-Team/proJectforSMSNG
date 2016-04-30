package quadroteam.qt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UnlimitedActivity extends AppCompatActivity {
TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlimited);

        view = (TextView) findViewById(R.id.scores);

        int scores = getIntent().getIntExtra("Scores",0);

        view.setText(scores + "");
    }

    public void toLevelMenu (View v)
    {
        Intent i = new Intent(getApplicationContext(),LevelActivity.class);
        startActivity(i);
    }

}
