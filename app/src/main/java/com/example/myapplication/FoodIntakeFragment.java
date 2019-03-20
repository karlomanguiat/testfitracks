package com.example.myapplication;

<<<<<<< HEAD
import android.content.Intent;
=======
import android.content.DialogInterface;
>>>>>>> c5b0c8f9b5ba958c2559b11620ff95f019478d3a
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;

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
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.makeText;


public class FoodIntakeFragment extends Fragment {
    DatabaseHelper myDb;
    ArrayList<String> food;
    ArrayList<String> foodOthers;
    ArrayAdapter<String> adapter;
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
//                SparseBooleanArray checkedItemPositions = foodList.getCheckedItemPositions();
//                int count = this.foodList.getAdapter().getCount();
//                for (int i = 0; i < count; i++) {
//                    if (checkedItemPositions.get(i)) {
//                        adapter.remove(foodOthers.get(i));
//                    }
//                }
//                checkedItemPositions.clear();
//                adapter.notifyDataSetChanged();
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

        foodList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            private AdapterView<?> adapterView;
            private View view;
            private int i;
            private long l;

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String text =  foodList.getItemAtPosition(i).toString();

                adapter.remove(adapter.getItem(i));
                adapter.notifyDataSetChanged();

                return true;
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
    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Delete")
                .setMessage("Do you want to Delete")
                .setIcon(R.drawable.delete)

                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {

                        dialog.dismiss();
                    }

                })



                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();
        return myQuittingDialogBox;

    }
}

