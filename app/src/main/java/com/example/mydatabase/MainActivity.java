package com.example.mydatabase;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Define stuffs
    DatabaseHelper myDb;
   // EditText editName, editSurname, editMarks;
    //Button btnAddData;
    //Button btnViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init database
        myDb = new DatabaseHelper(this);

        //get important variables from xml files
       // editName = (EditText) findViewById(R.id.editText_name);
       // editSurname = (EditText) findViewById(R.id.editText_surname);
        //editMarks = (EditText) findViewById(R.id.editText_marks);
        //btnAddData = (Button) findViewById(R.id.button_add);
       // btnViewData = (Button) findViewById(R.id.button_view);
        //init button functions
       // AddData();
        //viewAll();

    }




  /*  public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),
                                editMarks.getText().toString());
                        if (isInserted = true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data NOT Inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }*/

   /* public void viewAll() {
        btnViewData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //start new screen
                        Intent intent = new Intent(MainActivity.this, AddFoodForm.class);
                        startActivity(intent);
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
