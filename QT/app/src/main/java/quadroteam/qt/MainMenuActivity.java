package quadroteam.qt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity implements FirstDialog.Communicator_First_Dialog {
    static String DIALOG_APPEARANCE = "saved";
    Boolean flag_First = true;
    SharedPreferences sPref;
    FirstDialog fDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

      //  flag_First = Boolean.parseBoolean(sPref.getString(DIALOG_APPEARANCE,"true"));
        onShow();

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

    public void onShow() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainMenuActivity.this);
        builder.setTitle("Важное сообщение!")
                .setMessage("Покормите кота!")
                .setCancelable(false)
                .setNegativeButton("ОК, иду на кухню",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onDialogResult(boolean flag) {

    }

  /*  //Убрать boolean перед релизом!
    @Override
    public void onDialogResult(boolean flag) {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        flag_First = flag;
        ed.putString(DIALOG_APPEARANCE,flag_First.toString());
        ed.apply();
    }*/
}
