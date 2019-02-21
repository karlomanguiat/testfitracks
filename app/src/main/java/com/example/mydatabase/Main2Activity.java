package com.example.mydatabase;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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

//THIS WINDOW ACTIVITY ONLY GETS THE CALORIE OF FOOD AND DISPLAYS THEM
public class Main2Activity extends Activity {
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
        setContentView(R.layout.activity_main2);
        listItem = new ArrayList<>();

        food = new ArrayList<>();
        foodOthers = new ArrayList<>();

        simpleList = (ListView)findViewById(R.id.simpleListView);
        getJson();
        //private ArrayList<String>

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String text =  simpleList.getItemAtPosition(i).toString();
                Toast.makeText(Main2Activity.this,text,Toast.LENGTH_SHORT).show();
                g.setFoodchoice(text);
                Intent intent = new Intent(Main2Activity.this, AddFoodForm.class);
                startActivity(intent);

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
            //Toast.makeText(Main2Activity.this, "ARRAY CREATED", Toast.LENGTH_LONG).show();
            listItem.add("Food List");
            food.add("Food List");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                //Toast.makeText(MainActivity.this, "LOOP TIME", Toast.LENGTH_LONG).show();
                // if (obj.getString("foodname").equals("Sinigang")) {
                listItem.add(obj.getString("foodname")+ ": " + obj.getString("count"));
                food.add(obj.getString("foodname"));

                //}
            }
            //Toast.makeText(Main2Activity.this, numberlist.toString(), Toast.LENGTH_LONG).show();

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
