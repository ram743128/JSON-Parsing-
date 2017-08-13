package com.ram.jsonparsingtask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=(ListView)findViewById(R.id.listview);
        HttpRequest bj =new HttpRequest(MainActivity.this,mListView);//here we are creating object for HttpRequest
        bj.execute("https://api.androidhive.info/contacts/");//executing here



    }
}
