package com.example.mydatabase;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFoodForm extends Activity {
    Global g = Global.getInstance();
    DatabaseHelper myDb;
    EditText editServing, editDate, editTime;
    Button btnAddFood;
    Button btnSubmit;
    Button btnViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_form);
        myDb = new DatabaseHelper(this);

        //get important variables from xml files
        editServing = (EditText) findViewById(R.id.editText_serving);
        editDate = (EditText) findViewById(R.id.editText_date);
        editTime = (EditText) findViewById(R.id.editText_time);
        btnAddFood = (Button) findViewById(R.id.btn_add);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        //btnViewData = (Button) findViewById(R.id.btn_view);
        submitFood();
        getFood();
       // viewAll();
    }
    public void submitFood() {
        btnSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertFoodData(g.getFoodchoice(),
                                editServing.getText().toString()
                               );
                        if (isInserted = true)
                            Toast.makeText(AddFoodForm.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddFoodForm.this, "Data NOT Inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    public void getFood() {
        btnAddFood.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //start new screen
                        Intent intent = new Intent(AddFoodForm.this, Main2Activity.class);
                        startActivity(intent);
                    }
                }
        );
    }
    /*public void viewAll() {
        btnViewData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AddFoodForm.this, ViewFoodIntake.class);
                        startActivity(intent);

                      /*  Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            showMessage("Error", "No Data Found!");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("ID :" + res.getString(0) + "\n");
                            buffer.append("Food Name :" + res.getString(1) + "\n");
                            buffer.append("Serving :" + res.getString(2) + "\n");
                            buffer.append("Date Consumed :" + res.getString(3) + "\n");
                            buffer.append("Time Consumed :" + res.getString(4) + "\n");
                        }
                        showMessage("Food Intake", buffer.toString());
                    }
                }
        );
    }*/

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }



}
