package com.example.internshipproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Search_filter extends AppCompatActivity {
    Button submit_button;
    AutoCompleteTextView select_age_range,select_profession;
    RadioGroup radioGroup;
    String selected_radio_text;
    String age_range, profession;
    Spinner mySpinner;
    Jin j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_filter);

        j = (Jin) getIntent().getSerializableExtra(Jin.EXTRA);

        j = new Jin();
        submit_button = findViewById(R.id.submit_button);
        select_age_range = findViewById(R.id.select_age_range);
        select_profession = findViewById(R.id.select_profession);
        radioGroup = findViewById(R.id.radioGroup);


        Integer selected_id = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selected_id);
        selected_radio_text = radioButton.getText().toString();

        String Age_array[] = getResources().getStringArray(R.array.age_range);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_filter.this,R.layout.age_range,R.id.age_tv,Age_array);
        select_age_range.setAdapter(adapter);
       select_age_range.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                age_range = select_age_range.getText().toString();
                //Toast.makeText(Search_filter.this, ""+selected_state, Toast.LENGTH_SHORT).show();
            }
        });


        String Profession_array[] = getResources().getStringArray(R.array.profession);

        ArrayAdapter<String> professionadapter = new ArrayAdapter<String>(Search_filter.this, R.layout.age_range, R.id.age_tv, Profession_array);
        select_profession.setAdapter(professionadapter);

        select_profession.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                profession = select_profession.getText().toString();
            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {




                    // j.setPhone_number(phone_no.getText().toString());
                   // j.setGender(selected_radio_text);
                    //j.setName(Name.getText().toString());
                    //j.setAge(select_age_range.getText().toString());
                    //j.setAge(select_profession.getText().toString());

                    Intent intent = new Intent(Search_filter.this, Final.class);
                    //intent.putExtra(Jin.EXTRA, j);
                    startActivity(intent);


            }
        });
    }
}

