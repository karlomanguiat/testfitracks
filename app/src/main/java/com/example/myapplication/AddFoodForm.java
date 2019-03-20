package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

public class AddFoodForm extends AppCompatActivity {
    Global g = Global.getInstance();
    DatabaseHelper myDb;
    EditText editServing, editDate, editTime;
    Button btnAddFood, btnSubmit;

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

        submitFood();
        //getFood();

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
                        Intent intent = new Intent(AddFoodForm.this, FoodList.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
