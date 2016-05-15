package quadroteam.qt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class TheoryActivity extends AppCompatActivity {
    ImageView t;
    int s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);
         s = getIntent().getIntExtra("lvl?", 1);
        t = (ImageView)findViewById(R.id.imageView);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    switch (s) {
        case 1: t.setImageResource(R.drawable.the1);
            break;
        case 2: t.setImageResource(R.drawable.the2);
            break;
        case 3: t.setImageResource(R.drawable.the3);
            break;
        case 4: t.setImageResource(R.drawable.the4);
            break;
        case 5: t.setImageResource(R.drawable.the5);
            break;
        case 6: t.setImageResource(R.drawable.the6);
            break;
        case 7: t.setImageResource(R.drawable.the7);
            break;
        case 8: t.setImageResource(R.drawable.the8);
            break;
        case 9: t.setImageResource(R.drawable.the9);
            break;
        case 10: t.setImageResource(R.drawable.labelveronepone);
            break;
        case 11: t.setImageResource(R.drawable.the11);
            break;

        default: t.setImageResource(R.drawable.labelveronepone);
            break;
    }

}


    public void startLVLTasks(View v){
        Intent i = new Intent(this, TaskActivity.class);
        int m = getIntent().getIntExtra("lvl?", 1);
        i.putExtra("lvl", m);
        startActivity(i);
    }

    @Override
    public void onBackPressed () {
        //TODO Auto-generated method stub
        quitMethod();
    }

    private void quitMethod () {

        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                TheoryActivity.this);
        quitDialog.setTitle("Вернуться в меню уровней?");

        quitDialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Intent level = new Intent(getApplicationContext(),LevelActivity.class);
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
