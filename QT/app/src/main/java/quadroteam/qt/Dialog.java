package quadroteam.qt;


import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fuck on 29.04.16.
 */
public class Dialog  extends android.app.DialogFragment implements View.OnClickListener {
    Communicator communicator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicator = (Communicator) activity;
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {

        getDialog().setTitle("Choose");

        View v  = inflater.inflate(R.layout.dialog,null);
        v.findViewById(R.id.limit).setOnClickListener(this);
        v.findViewById(R.id.unlimit).setOnClickListener(this);

        return v;
    }

    public void onDismiss (DialogInterface dialog){
        super.onDismiss(dialog);
    }
    public void onCancel (DialogInterface dialog){
        super.onCancel(dialog);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.unlimit) {
            communicator.onDialogMessage("Yes");
            dismiss();
        }else {
            communicator.onDialogMessage("No");
            dismiss();
        }
    }

    interface  Communicator
    {

        void onDialogMessage(String message);

    }

}
