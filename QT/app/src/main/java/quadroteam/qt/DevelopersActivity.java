package quadroteam.qt;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DevelopersActivity extends AppCompatActivity {
    ImageView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        t = (ImageView) findViewById(R.id.imageView2);
        t.setImageResource(R.drawable.developers);
    }
}
