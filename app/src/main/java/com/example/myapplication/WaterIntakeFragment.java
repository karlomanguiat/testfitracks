package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class WaterIntakeFragment extends Fragment {

    DatabaseHelper myDb;
    public static ArrayList<String> water;
    public static ArrayList<String> waterOthers;
    public static ArrayAdapter<String> adapter;
    ListView waterList;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.waterintakefragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.delete_water:
                // do stuff
                return true;
        }

        return false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View waterView = inflater.inflate(R.layout.activity_water_intake_fragment, container, false);
        Button myButton = (Button) waterView.findViewById(R.id.wateraddbutton);

        myDb = new DatabaseHelper(getContext());
        water = new ArrayList<>();
        waterOthers = new ArrayList<>();
        waterList = (ListView)waterView.findViewById(R.id.waterListView);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,water);
        waterList.setAdapter(adapter);

        myButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /* DO SOMETHING UPON THE CLICK */
                        Intent intent = new Intent(getActivity(), AddWaterForm.class);
                        startActivity(intent);
                        //adapter.notifyDataSetChanged();
                        //waterList.setAdapter(adapter);
                    }
                }
        );



        final Cursor res = myDb.getWaterData();
        if (res.getCount() == 0) {
            showMessage("Error", "No Data Found!");
        }
        final StringBuffer test = new StringBuffer();
        while(res.moveToNext()){
            waterOthers.add(res.getString(1));
            waterOthers.add("ID: " + res.getString(0));
            water.add(res.getString(1) + " cups");
            //adapter.notifyDataSetChanged();

           // waterOthers.add("Number of Cups: " + res.getString(1));
            waterOthers.add("Date Consumed: " + res.getString(2));
            waterOthers.add("Time Consumed: " + res.getString(3));
        };



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
        return waterView;
       /* waterList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            private AdapterView<?> adapterView;
            private View view;
            private int i;
            private long l;

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text =  foodList.getItemAtPosition(i).toString();
                adapter.remove(adapter.getItem(i));
                adapter.notifyDataSetChanged();

                return true;
            }
        });*/

    }
    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}