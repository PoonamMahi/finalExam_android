package com.example.finalexam_poonam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        result= findViewById(R.id.result);
        Spinner dieType = findViewById(R.id.dieType);
        Button firstRoll = findViewById(R.id.firstRoll);
        Button secondRoll = findViewById(R.id.secondRoll);
        customDie= findViewById(R.id.customDie);
        Button addDie = findViewById(R.id.addDie);


        firstRoll.setOnClickListener(this);
        secondRoll.setOnClickListener(this);
        addDie.setOnClickListener(this);

        list=new ArrayList<Integer>();
        list.add(2);
        list.add(4);


        ArrayAdapter<Integer> adp=new ArrayAdapter<Integer>(this,
                android.R.layout.simple_dropdown_item_1line, list);
        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dieType.setAdapter(adp);

        dieType.setOnItemSelectedListener(new OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
                // TODO Auto-generated method stub
                dieType.setSelection(arg2);
                selectedDie=  list.get(arg2);
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
            case R.id.firstRoll:
                //Log.d("abc", String.valueOf(selectedDie));
                selectedValue = (int)(Math.random() * selectedDie) + 1;
                result.setText("Result of first roll: "+ String.valueOf(selectedValue));
                break;

            case R.id.secondRoll:
                //Log.d("abc", String.valueOf(selectedDie));
                selectedValue= (int)(Math.random() * selectedDie) + 1;
                result.setText("Result of first roll: "+ String.valueOf(selectedValue)+ " " + "Result of second roll: "+ String.valueOf(selectedValue));
                break;

            case R.id.addDie:
                int getDie= Integer.valueOf(String.valueOf(customDie.getText()));
                list.add(getDie);
        }
    }
}