package quadroteam.qt;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Congratulations extends AppCompatActivity {

    TextView scores;
    ImageView stars;
    int  starsAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congratulations_activity);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        scores = (TextView)findViewById(R.id.scores);
        stars = (ImageView)findViewById(R.id.stars);

        int amount = getIntent().getIntExtra("Tries",1);
        double result  = 10.0/ amount;

        if (result < 0.4){
            stars.setImageResource(R.drawable.one);
            starsAmount = 1;
        }
        if (result >= 0.4 && result < 0.75){
            stars.setImageResource(R.drawable.two);
            starsAmount = 2;
        }
        if (result >= 0.75){
            stars.setImageResource(R.drawable.three);
            starsAmount = 3;
        }
        int result1 = (int)(result * 100);
        scores.setText("Очков:10   Попыток: " + amount + "\nПравильность:" + result1 + "%");

    }

    public void toMainMenu(View v){
        int levelVariable = getIntent().getIntExtra("levelSTAR",0);
        Intent i = new Intent(this, LevelActivity.class);
        i.putExtra("Stars",starsAmount);
        i.putExtra("levelSTARS",levelVariable);
        startActivity(i);

    }

}
