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

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result= findViewById(R.id.result);
        Spinner dieType = findViewById(R.id.dieType);
        Button firstRoll = findViewById(R.id.firstRoll);
        Button secondRoll = findViewById(R.id.secondRoll);
        EditText customdie= findViewById(R.id.customDie);
        Button addDie = findViewById(R.id.addDie);
        List<Integer> list;

        firstRoll.setOnClickListener(this);
        secondRoll.setOnClickListener(this);
        addDie.setOnClickListener(this);

        list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        ArrayAdapter<Integer> adp=new ArrayAdapter<Integer>(this,
                android.R.layout.simple_dropdown_item_1line, list);
        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dieType.setAdapter(adp);
        dieType.setSelection((list.size()-1));

        dieType.setOnItemSelectedListener(new OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
            // TODO Auto-generated method stub
                dieType.setSelection(arg2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
            }
        });
    }

    @Override
    public void onClick(View v) {


    }
}