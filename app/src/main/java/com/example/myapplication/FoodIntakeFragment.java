package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class FoodIntakeFragment extends Fragment {
    DatabaseHelper myDb;
    ArrayList<String> food;
    ArrayList<String> foodOthers;
    ArrayAdapter adapter;
    ListView foodList;
    Button myButton;
    Intent intent;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.foodintakefragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.delete_food:
                // do stuff
                return true;
            case R.id.add_food:
                // do stuff
                return true;
        }

        return false;
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View foodView = inflater.inflate(R.layout.activity_food_intake_fragment, container, false);
        myButton = (Button) foodView.findViewById(R.id.foodaddbutton);

        myButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /* DO SOMETHING UPON THE CLICK */
                        Intent intent = new Intent(getActivity(), AddFoodForm.class);
                        startActivity(intent);
                    }
                }
        );

        myDb = new DatabaseHelper(getContext());
        food = new ArrayList<>();
        foodOthers = new ArrayList<>();
        foodList = (ListView) foodView.findViewById(R.id.foodListView);
        // myDb.insertFoodData("Crispy Pata","25");

        final Cursor res = myDb.getFoodData();
        if (res.getCount() == 0) {
            showMessage("Error", "No Data Found!");

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
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,food);
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

        return foodView;
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}

