package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddWaterForm extends Activity {
    DatabaseHelper myDb;
    EditText editCup, editDate, editTime;
    Button btnSubmit;
    Button btnViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_water_form);
        myDb = new DatabaseHelper(this);

        //get important variables from xml files
        editCup = (EditText) findViewById(R.id.editText_cup);
        editDate = (EditText) findViewById(R.id.editText_date);
        editTime = (EditText) findViewById(R.id.editText_time);
        btnSubmit = (Button) findViewById(R.id.button_submit);
        //btnViewData = (Button) findViewById(R.id.button_view);
        submitWater();
    }

    public void submitWater() {
        btnSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertWaterData(Integer.parseInt(editCup.getText().toString()));
                        if (isInserted = true)
                            Toast.makeText(AddWaterForm.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddWaterForm.this, "Data NOT Inserted", Toast.LENGTH_LONG).show();
                        //WaterIntakeFragment.adapter.add(editCup.getText().toString() + " cups");
                       // WaterIntakeFragment.adapter.notifyDataSetChanged();
                        WaterIntakeFragment.water.add(editCup.getText().toString() + " cups");
                        WaterIntakeFragment.adapter.notifyDataSetChanged();
                        final Cursor res = myDb.getNewWaterData();
                        while(res.moveToNext()){
                            WaterIntakeFragment.waterOthers.add(res.getString(1));
                            WaterIntakeFragment.waterOthers.add("ID: " + res.getString(0));
                            //waterOthers.add("Number of Cups: " + res.getString(1));
                            WaterIntakeFragment.waterOthers.add("Date Consumed: " + res.getString(2));
                            WaterIntakeFragment.waterOthers.add("Time Consumed: " + res.getString(3));
                        };
                        finish();
                    }
                }
        );
    }
}