package io.sorus.temples;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListviewCursorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_listview);

        DBHelper helper = new DBHelper(getApplicationContext());
        Cursor cursor = helper.listAll();
        ListviewCursorAdapter adapter = new ListviewCursorAdapter(this, cursor);

        ListView layout = (ListView) findViewById(R.id.simple_listview);
        layout.setAdapter(adapter);
    }
}
