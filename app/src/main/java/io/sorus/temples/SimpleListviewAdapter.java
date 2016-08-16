package io.sorus.temples;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by sudhir on 8/15/16.
 */
public class SimpleListviewAdapter extends ArrayAdapter<String> {

    public SimpleListviewAdapter(Context ctx, int resource, List<String> objects) {
        super (ctx, resource, objects);
    }
}
