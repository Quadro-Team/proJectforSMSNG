package quadroteam.qt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DevelopersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    @Override
    public void onBackPressed () {
        //TODO Auto-generated method stub
        quitMethod();
    }

    private void quitMethod () {
        Intent quit = new Intent(getApplicationContext(),MainMenuActivity.class);
        startActivity(quit);
    }
}
