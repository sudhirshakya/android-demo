package io.sorus.temples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class IntentWithExtraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_with_extra);

        Bundle extras = getIntent().getExtras();
        String message = extras.getString("message");

        TextView textView = (TextView) findViewById(R.id.txt_intent_message);
        textView.setText(message);
    }
}
