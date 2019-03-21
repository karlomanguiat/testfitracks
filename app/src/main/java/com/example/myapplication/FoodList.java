/*
This is a course requirement for CS 191 / 192 Software Engineering Courses of the Department of Computer Science,
College of Engineering, University of the Philippines, Diliman under the guidance of Ma. Rowena C. Solamo
for the 1st and 2nd Semester of the academic year <2018-2019>.

This code is created by Trina B. Aguilana, Glenn Karlo D. Manguiat, and Ian N. Villanueva.

Code History:

Glenn Karlo D. Manguiat
        03/16/19    Creation
        03/17/19    Update
Ian N. Villanueva
        03/20/19    Update

File Creation Date: 02/17/19
Client Group: CS 192
Purpose of the Software: <FiTracks> is a web application which tracks the daily, weekly, or monthly calorie spent in food and water intake for a fitter and healthier scholars of the University of the Philippines.
*/

package com.example.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FoodList extends Activity {
    Global g = Global.getInstance();
    DatabaseHelper myDb;
    String[] myList = new String[10];
    ArrayList<String> listItem;
    ArrayList<String> food;
    ArrayList<String> foodOthers;
    ArrayAdapter adapter;
    ListView simpleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodlist);
        listItem = new ArrayList<>();

        food = new ArrayList<>();
        foodOthers = new ArrayList<>();

        simpleList = (ListView)findViewById(R.id.simpleListView);
        getJson();

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String text =  simpleList.getItemAtPosition(i).toString();
                Toast.makeText(FoodList.this,text,Toast.LENGTH_SHORT).show();
                g.setFoodchoice(text);
                //Intent intent = new Intent(FoodList.this, AddFoodForm.class);
                //startActivity(intent);
                finish();

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


    public void getJson() {
        String json;
        try {
            InputStream is = getAssets().open("foodindex.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();


            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            //Toast.makeText(FoodList.this, "ARRAY CREATED", Toast.LENGTH_LONG).show();
            listItem.add("Food List");
            food.add("Food List");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                listItem.add(obj.getString("foodname")+ ": " + obj.getString("count"));
                food.add(obj.getString("foodname"));
            }

            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,food);
            simpleList.setAdapter(adapter);
        }
        catch(IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
