package com.example.rentalz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private MaterialAutoCompleteTextView auto_txt_bedrooms;
    ArrayList<String> bedrooms_arrList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        Spinner spinner = findViewById(R.id.spinner_property);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.property,
                android.R.layout.simple_spinner_item);

        ;
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,bedrooms_arrList);
        auto_txt_bedrooms.setAdapter(adapter);
        auto_txt_bedrooms.setThreshold(1);
    }

    private void mapping() {
        auto_txt_bedrooms = findViewById(R.id.ac_txt_bedroom);
        bedrooms_arrList = new ArrayList<>();
        for(int i = 1; i <= 30 ; i++){
            bedrooms_arrList.add(i +"");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int postion, long l) {
        String text = parent.getItemAtPosition(postion).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
