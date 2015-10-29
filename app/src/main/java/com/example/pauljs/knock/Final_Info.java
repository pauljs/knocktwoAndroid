package com.example.pauljs.knock;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pauljs on 10/29/2015.
 */
public class Final_Info extends Activity {
    private ArrayList<String> list;
    private ListView listView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_info);
        listView = (ListView) findViewById(R.id.listView2);
        list = new ArrayList<String>();
        List<Hour> hours = Hour.getSortedHours();
        for(int i = 0; i < hours.size(); i++) {
            list.add(hours.get(i).getFormattedString());
        }
        String[] array = new String[] {};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list.toArray(array));
        listView.setAdapter(adapter);
    }
}
