package quadroteam.qt;

import android.content.Intent;
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


    switch (s) {
        case 1: t.setImageResource(R.drawable.theory1);
            break;
        case 2:
            break;
        case 3:
            break;
        case 4:
            break;
        case 5:
            break;
        case 6:
            break;
        case 7:
            break;
        case 8:
            break;
        case 9:
            break;
        case 10:
            break;
    }
}


    public void startLVLTasks(View v){
        Intent i = new Intent(this, TaskActivity.class);
        int m = getIntent().getIntExtra("lvl?", 1);
        i.putExtra("lvl", m);
        startActivity(i);
    }

}
