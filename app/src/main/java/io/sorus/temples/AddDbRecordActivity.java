package io.sorus.temples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddDbRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_db_record);
    }

    public void insert (View view) {
        TextView name = (TextView) findViewById(R.id.txt_temple_name);
        TextView address = (TextView) findViewById(R.id.txt_temple_address);
        TextView summary = (TextView) findViewById(R.id.txt_temple_summary);

        Temple temple = new Temple (
                name.getText().toString(),
                address.getText().toString(),
                summary.getText().toString());

        DBHelper helper = new DBHelper(getApplicationContext());
        boolean success = helper.insert (temple);
        String msg;
        if (success)
            msg = "Record added successfully.";
        else
            msg = "Record was not added... unspecified error occurred";
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
