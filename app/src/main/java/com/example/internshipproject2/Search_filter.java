package com.example.internshipproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class Search_filter extends AppCompatActivity {
    Button submit_button;


    AutoCompleteTextView select_age_range, select_profession;
    TextInputLayout textInputLayout_age, textInputLayout_Profession;
    RadioGroup radioGroup, radioGroup_1;
    boolean b_age = false, b_gender = false, b_profession = false;
    String selected_radio_text, selected_radio_text_1;
    TextView gender;
    RadioButton male_radio_button, female_radio_button;
    String age_range, profession;
    Jin j;
    String url;

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
        male_radio_button = findViewById(R.id.male_radio_button);
        female_radio_button = findViewById(R.id.female_radio_button);
        gender = findViewById(R.id.gender);
        radioGroup_1 = findViewById(R.id.radioGroup_1);
        textInputLayout_age = findViewById(R.id.textInputLayout_age);
        textInputLayout_Profession = findViewById(R.id.textInputLayout_Profession);


        textInputLayout_age.setVisibility(View.VISIBLE);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.age_radio_button) {
                    textInputLayout_age.setVisibility(View.VISIBLE);
                    textInputLayout_Profession.setVisibility(View.GONE);
                    male_radio_button.setVisibility(View.GONE);
                    female_radio_button.setVisibility(View.GONE);
                    radioGroup_1.setVisibility(View.GONE);
                    gender.setVisibility(View.GONE);
                    b_age = true;
                    b_gender = false;
                    b_profession = false;


                } else if (checkedId == R.id.gender_radio_button) {
                    radioGroup_1.setVisibility(View.VISIBLE);
                    male_radio_button.setVisibility(View.VISIBLE);
                    female_radio_button.setVisibility(View.VISIBLE);
                    gender.setVisibility(View.VISIBLE);
                    textInputLayout_age.setVisibility(View.GONE);
                    textInputLayout_Profession.setVisibility(View.GONE);
                    b_age = false;
                    b_gender = true;
                    b_profession = false;


                } else if (checkedId == R.id.prof_radio_button) {

                    textInputLayout_Profession.setVisibility(View.VISIBLE);
                    gender.setVisibility(View.GONE);
                    male_radio_button.setVisibility(View.GONE);
                    female_radio_button.setVisibility(View.GONE);
                    textInputLayout_age.setVisibility(View.INVISIBLE);
                    radioGroup_1.setVisibility(View.GONE);
                    b_age = false;
                    b_gender = false;
                    b_profession = true;


                }
            }
        });


        Integer selected_id = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selected_id);
        selected_radio_text = radioButton.getText().toString();


        Integer selected_id_1 = radioGroup_1.getCheckedRadioButtonId();
        RadioButton radioButton1 = (RadioButton) findViewById(selected_id_1);
        selected_radio_text_1 = radioButton1.getText().toString();


        String Age_array[] = getResources().getStringArray(R.array.age_range);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_filter.this, R.layout.age_range, R.id.age_tv, Age_array);
        select_age_range.setAdapter(adapter);
        select_age_range.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                age_range = select_age_range.getText().toString();

                String[] age = age_range.split("-", 2);
                url = "https://screechy-buzzers.000webhostapp.com/age.php?age1="+age[0]+"&age2="+age[1];
                Toast.makeText(Search_filter.this, "age1="+age[0]+"&age2="+age[1], Toast.LENGTH_SHORT).show();

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

                if (b_age) {

//                    Toast.makeText(Search_filter.this, "Age", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Search_filter.this, select_age_range.getText(), Toast.LENGTH_SHORT).show();

//                    String str = select_age_range.getText().toString();
//                    String[] age = str.split("-", 2);
//                    url = "https://screechy-buzzers.000webhostapp.com/age.php?age1="+age[0]+"&age2="+age[1];
//                    Toast.makeText(Search_filter.this, "age1="+age[0]+"&age2="+age[1], Toast.LENGTH_SHORT).show();

                    //url = "https://screechy-buzzers.000webhostapp.com/age.php?age1=0&age2=18";

                    Log.d("url2",""+url);

                } else if (b_gender) {
                    if (male_radio_button.isChecked()) {
//                        Toast.makeText(getApplicationContext(), "Gender", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(getApplicationContext(), "Male", Toast.LENGTH_SHORT).show();
                        url = "https://screechy-buzzers.000webhostapp.com/gender.php?gender=Male";

                    }
                    if (female_radio_button.isChecked()) {

//                        Toast.makeText(getApplicationContext(), "Gender", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(getApplicationContext(), "Female", Toast.LENGTH_SHORT).show();
                        url = "https://screechy-buzzers.000webhostapp.com/gender.php?gender=Female";


                    }
                } else if (b_profession) {
//                    Toast.makeText(Search_filter.this, "Profession", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Search_filter.this, select_profession.getText().toString(), Toast.LENGTH_SHORT).show();
                    url = "https://screechy-buzzers.000webhostapp.com/profession.php?profession=" + select_profession.getText();



                }

                Intent intent = new Intent(Search_filter.this, Final.class);
                intent.putExtra("URL", url);
                startActivity(intent);

            }

        });

    }

}


