package quadroteam.qt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

/**
 * Created by Guitar on 04.04.2016.
 */
public class CustomAdapter extends ArrayAdapter<Integer> {

    private Integer [] imageID;

    public CustomAdapter(Context context, Integer [] imageID) {
        super(context, R.layout.custom_row,imageID);
        this.imageID = imageID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        ImageView imageView = (ImageView) customView.findViewById(R.id.image);
        imageView.setImageResource(imageID[position]);

        return customView;
    }




}
