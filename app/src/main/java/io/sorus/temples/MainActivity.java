package io.sorus.temples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openStaticTable (View view) {
        Intent intent = new Intent(this, StaticTempleTableActivity.class);
        startActivity(intent);
    }

    public void openLayoutWithMenu (View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void openIntentExtra (View view) {
        Intent intent = new Intent(this, IntentWithExtraActivity.class);

        TextView textView = (TextView) findViewById(R.id.txt_intent_extra);
        String message = textView.getText().toString();
        intent.putExtra("message", message);

        startActivity(intent);
    }

    public void openAddRecord (View view) {
        Intent intent = new Intent(this, AddDbRecordActivity.class);
        startActivity(intent);
    }

    public void openSimpleListview (View view) {
        Intent intent = new Intent(this, SimpleListviewActivity.class);
        startActivity(intent);
    }

    public void openListviewCustomAdapter (View view) {
        Intent intent = new Intent(this, ListViewCustomAdapterActivity.class);
        startActivity(intent);
    }

    public void openListviewCursorAdapter (View view) {
        Intent intent = new Intent(this, ListviewCursorActivity.class);
        startActivity(intent);
    }

    public void openLogin (View view) {
        Intent intent = new Intent(this, FirebaseLoginActivity.class);
        startActivity(intent);
    }

    public void openCamera (View view) {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }
}
