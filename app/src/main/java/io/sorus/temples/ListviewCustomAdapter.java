package io.sorus.temples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sudhir on 8/15/16.
 */
public class ListviewCustomAdapter extends ArrayAdapter<String> {

    private Context ctx;

    private List<String> objects;


    public ListviewCustomAdapter(Context ctx, List<String> objects) {
        super (ctx, -1, objects);

        this.ctx = ctx;
        this.objects = objects;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.custom_listview_element, parent, false);

        TextView idView = (TextView) rowView.findViewById(R.id.txt_listview_index);
        idView.setText("" + position);

        TextView nameView = (TextView) rowView.findViewById(R.id.txt_listview_name);
        nameView.setText(objects.get(position));

        return rowView;
    }

}
