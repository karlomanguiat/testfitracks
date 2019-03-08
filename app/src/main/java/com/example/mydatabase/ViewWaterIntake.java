package com.example.mydatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewWaterIntake extends Activity {
    DatabaseHelper myDb;
    ArrayList<String> water;
    ArrayList<String> waterOthers;
    ArrayAdapter adapter;
    ListView waterList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_water_intake);

        myDb = new DatabaseHelper(this);
        water = new ArrayList<>();
        waterOthers = new ArrayList<>();
        waterList = (ListView)findViewById(R.id.waterListView);
        final Cursor res = myDb.getWaterData();
        if (res.getCount() == 0) {
            showMessage("Error", "No Data Found!");
            return;
        }
        final StringBuffer test = new StringBuffer();
        while(res.moveToNext()){
            waterOthers.add(res.getString(1));
            waterOthers.add("ID: " + res.getString(0));
            water.add(res.getString(1) + " cups");
            //waterOthers.add("Number of Cups: " + res.getString(1));
            waterOthers.add("Date Consumed: " + res.getString(2));
            waterOthers.add("Time Consumed: " + res.getString(3));
        };
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,water);
        waterList.setAdapter(adapter);

        waterList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String text =  waterList.getItemAtPosition(i).toString();
                int x = 0;
                while(x < waterOthers.size()){
                    if(text.equals(waterOthers.get(x)+ " cups")){
                        showMessage("Data", waterOthers.get(x)+ " cups" + "\n" + waterOthers.get(x+1) +"\n" + waterOthers.get(x+2) + "\n" + waterOthers.get(x+3));
                    };
                    x = x+1;
                };
            }
        });
    }
    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
