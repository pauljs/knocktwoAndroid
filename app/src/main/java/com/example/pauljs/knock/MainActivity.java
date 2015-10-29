package com.example.pauljs.knock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private ArrayList<String> list;
    private ListView listView;
    private ListAdapter adapter;
    private Button view_results_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Parse initialize

        final Questions questions = getJSONList("sample_question.json");

        // Set Alarm Notification daily
//        setAlarm();

        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<String>();
        list.add(questions.getFirstQuestion().getQuestion());
        String[] array = new String[] {};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list.toArray(array));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DataSheetActivity.class);
                intent.putExtra("questions", questions);
                startActivity(intent);
            }
        });
        view_results_button = (Button) findViewById(R.id.view_results_button);
        view_results_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CombinedChartActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = this.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private Questions getJSONList(String filename) {
        Questions formList = new Questions();
        try {
            JSONArray m_jArry = new JSONArray(loadJSONFromAsset(filename));
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                HashMap<String, String> m_li = new HashMap<>();
                Iterator<String> iterKeys = jo_inside.keys();
                while(iterKeys.hasNext()) {
                    String key = iterKeys.next();
                    m_li.put(key, jo_inside.get(key).toString());
                }
                formList.add(new Question(m_li));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return formList;
    }

//    private void setAlarm() {
//        if(!Alarm.isOn()) {
//            Alarm alarm = new Alarm();
//            alarm.save();
//            Calendar calendar = Calendar.getInstance();
//            Log.i("DATE EMERGENCY", calendar.toString());
//            calendar.set(Calendar.HOUR_OF_DAY, 14);
//            calendar.set(Calendar.MINUTE, 55);
//            Intent intent1 = new Intent(MainActivity.this, AlaramReceiver.class);
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent1, 0);
//            AlarmManager am = (AlarmManager) MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
//            am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
//        }
//    }
}
