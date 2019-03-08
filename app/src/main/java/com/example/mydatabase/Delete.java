package com.example.mydatabase;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends Activity {
    Button btnFood;
    Button btnWater;

    EditText editfood,editwater;

    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        myDb = new DatabaseHelper(this);
        btnFood = (Button) findViewById(R.id.food1);
        btnWater = (Button) findViewById(R.id.water2);

        editfood = (EditText) findViewById(R.id.editText_food);
        editwater = (EditText) findViewById(R.id.editText_water);

        deleteFood();
        deleteWater();

    }
    public void deleteFood() {

        btnFood.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteFoodIntake(editfood.getText().toString());
                        if(deletedRows > 0){
                            Toast.makeText(Delete.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(Delete.this, "Data Not Deleted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
    public void deleteWater() {

        btnWater.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteWaterIntake(editwater.getText().toString());
                        if(deletedRows > 0){
                            Toast.makeText(Delete.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(Delete.this, "Nothing to Delete!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

}
