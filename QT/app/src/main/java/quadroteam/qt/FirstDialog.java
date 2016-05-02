package quadroteam.qt;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by fuck on 02.05.16.
 */
public class FirstDialog extends android.app.DialogFragment  implements View.OnClickListener{

    Communicator_First_Dialog communicator_First;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicator_First = (Communicator_First_Dialog) activity;
    }


    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {

        getDialog().setTitle("Прочти");

        View v  = inflater.inflate(R.layout.first_dialog,null);
        v.findViewById(R.id.allRight).setOnClickListener(this);
        TextView textView = (TextView) v.findViewById(R.id.bigText);
        textView.setText("adkfnsdjkvnadjkfvn");
        return v;
    }

    @Override
    //Поменять значение true --> false
    public void onClick (View v){

        communicator_First.onDialogResult(true);
        dismiss();

    }


    public void onDismiss (DialogInterface dialog){
        super.onDismiss(dialog);
    }
    public void onCancel (DialogInterface dialog){ super.onCancel(dialog); }


    interface Communicator_First_Dialog {

        void onDialogResult (boolean flag);

    }


}
