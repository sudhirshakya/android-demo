package io.sorus.temples;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by sudhir on 8/16/16.
 */
public class ListviewCursorAdapter extends CursorAdapter {

    public ListviewCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.listview_element, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textName = (TextView) view.findViewById(R.id.text_temple_name);
        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        textName.setText(name);

        TextView textSummary = (TextView) view.findViewById(R.id.text_temple_summary);
        String summary = cursor.getString(cursor.getColumnIndexOrThrow("summary"));
        textSummary.setText(summary);

    }
}
