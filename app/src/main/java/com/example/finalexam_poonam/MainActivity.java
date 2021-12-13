package com.example.finalexam_poonam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int selectedDie;
    TextView result;
    int selectedValue;
    EditText customDie;
    List<Integer> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding view using id's
        result= findViewById(R.id.result);
        Spinner dieType = findViewById(R.id.dieType);
        Button firstRoll = findViewById(R.id.firstRoll);
        Button secondRoll = findViewById(R.id.secondRoll);
        customDie= findViewById(R.id.customDie);
        Button addDie = findViewById(R.id.addDie);

        //setting listener to the buttons
        firstRoll.setOnClickListener(this);
        secondRoll.setOnClickListener(this);
        addDie.setOnClickListener(this);

        //intializing integer type list and adding values to it
        list=new ArrayList<Integer>();
        list.add(2);
        list.add(4);

        //adding list to the arrayAdapter
        ArrayAdapter<Integer> adp=new ArrayAdapter<Integer>(this,
                android.R.layout.simple_dropdown_item_1line, list);
        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dieType.setAdapter(adp); //set adapter to the spinner




        //set listener to the spinner and calling methods of it
        dieType.setOnItemSelectedListener(new OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
                // TODO Auto-generated method stub
                SharedPreferences prefs;
                prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor prefEditor = prefs.edit();
                prefEditor.putString("savedValue",dieType.getSelectedItem().toString());
                prefEditor.commit();

                String savedValue=PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext())
                        .getString("savedValue","");


                dieType.setSelection(arg2); //by default selection of element in spinner
                selectedDie=  list.get(arg2); //getting the selected element of the spinner
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //on click of first roll button
            case R.id.firstRoll:
                //Log.d("abc", String.valueOf(selectedDie));
                selectedValue = (int)(Math.random() * selectedDie) + 1; //generating random value for the selected die
                result.setText("Result of first roll: "+ String.valueOf(selectedValue)); //setting the random value to textview
                break;

                //on click of second roll button
            case R.id.secondRoll:
                //Log.d("abc", String.valueOf(selectedDie));
                selectedValue= (int)(Math.random() * selectedDie) + 1;
                result.setText("Result of first roll: "+ String.valueOf(selectedValue)+ " " + "Result of second roll: "+ String.valueOf(selectedValue));
                break;

                //on click of add die button
            case R.id.addDie:
                int getDie= Integer.valueOf(String.valueOf(customDie.getText())); //get text from the edittext
                list.add(getDie); //adding that text to the list
        }
    }
}