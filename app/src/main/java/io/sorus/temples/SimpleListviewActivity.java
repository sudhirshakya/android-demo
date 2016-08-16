package io.sorus.temples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class SimpleListviewActivity extends AppCompatActivity {

    public final List<String> OS_LIST = Arrays.asList( "Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
            "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
            "Android", "iPhone", "WindowsMobile");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_listview);

        SimpleListviewAdapter adapter = new SimpleListviewAdapter(this, R.layout.simple_listview_element, OS_LIST);
        ListView listView = (ListView) findViewById(R.id.simple_listview);
        listView.setAdapter(adapter);
    }
}
