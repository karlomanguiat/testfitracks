package com.example.mydatabase;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TemporaryScreen extends Activity {
    Button btnFood;
    Button btnWater;
    Button btnViewFood;
    Button btnViewWater;
    Button btnDelete;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporary_screen);
        myDb = new DatabaseHelper(this);

        btnFood = (Button) findViewById(R.id.btn1);
        btnWater = (Button) findViewById(R.id.btn2);
        btnViewFood = (Button) findViewById(R.id.btn3);
        btnViewWater = (Button) findViewById(R.id.btn4);
        btnDelete = (Button) findViewById(R.id.btn5);
        addFood();
        addWater();
        viewFood();
        viewWater();
        deleteAll();
    }

    public void addFood(){
        btnFood.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //start new screen
                        Intent intent = new Intent(TemporaryScreen.this, AddFoodForm.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void addWater(){
        btnWater.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //start new screen
                        Intent intent = new Intent(TemporaryScreen.this, AddWaterForm.class);
                        startActivity(intent);
                    }
                }
        );
    }
    public void viewFood() {
        btnViewFood.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TemporaryScreen.this, ViewFoodIntake.class);
                        startActivity(intent);

                    }
                }
        );
    }
    public void viewWater() {
        btnViewWater.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TemporaryScreen.this, ViewWaterIntake.class);
                        startActivity(intent);

                    }
                }
        );
    }
    public void deleteAll() {

        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDb.deleteAll();
                        Toast.makeText(TemporaryScreen.this, "All Intakes Deleted!", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
}
