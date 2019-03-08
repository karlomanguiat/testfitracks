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

public class ViewFoodIntake extends Activity {
    DatabaseHelper myDb;
    ArrayList<String> food;
    ArrayList<String> foodOthers;
    ArrayAdapter adapter;
    ListView foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_intake);
        myDb = new DatabaseHelper(this);
        food = new ArrayList<>();
        foodOthers = new ArrayList<>();
        foodList = (ListView)findViewById(R.id.foodListView);
        final Cursor res = myDb.getFoodData();
        if (res.getCount() == 0) {
            showMessage("Error", "No Data Found!");
            return;
        }
        final StringBuffer test = new StringBuffer();
        while(res.moveToNext()){
            foodOthers.add(res.getString(1));
            foodOthers.add("ID: " + res.getString(0));
            food.add(res.getString(1));
            foodOthers.add("Serving: " + res.getString(2));
            foodOthers.add("Date Consumed: " + res.getString(3));
            foodOthers.add("Time Consumed: " + res.getString(4));
        };
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,food);
        foodList.setAdapter(adapter);

        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String text =  foodList.getItemAtPosition(i).toString();
                int x = 0;
                while(x < foodOthers.size()){
                  if(text.equals(foodOthers.get(x))){
                      showMessage("Data", foodOthers.get(x)+ "\n" + foodOthers.get(x+1) +"\n" + foodOthers.get(x+2) + "\n" + foodOthers.get(x+3) + "\n" + foodOthers.get(x+4));
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


