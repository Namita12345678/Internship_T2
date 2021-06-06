package com.example.internshipproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {

    String username, password;
    Button submit_button;
    TextInputEditText Name, phone_no;
    AutoCompleteTextView select_age_range, select_profession;

    RadioGroup radioGroup;
    String selected_radio_text;
    String age_range, profession;
    Jin j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        j = (Jin) getIntent().getSerializableExtra(Jin.EXTRA);


        submit_button = findViewById(R.id.submit_button);
        Name = findViewById(R.id.edt_name);
        radioGroup = findViewById(R.id.radioGroup);
        phone_no = findViewById(R.id.phone_no);
        select_age_range = findViewById(R.id.select_age_range);
        select_profession = findViewById(R.id.select_profession);

        Integer selected_id = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selected_id);
        selected_radio_text = radioButton.getText().toString();

        String Age_array[] = getResources().getStringArray(R.array.age_range);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(Register.this, R.layout.activity_age_range, R.id.select_age_range, Age_array);
        ////age_range.setAdapter(adapter);

        //age_range.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           // @Override
            //public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //select_age_range = age_range.getBytes( int).toString();
                // Toast.makeText(SecondActivity.this, ""+selected_state, Toast.LENGTH_SHORT).show();
           // }
        //});


        //String Profession_array[] = getResources().getStringArray(R.array.profession);

        //ArrayAdapter<String> myadapter = new ArrayAdapter<String>(Register.this, R.layout.activity_profession, R.id.select_profession, Age_array);
       // profession.setAdapter(adapter);

       // profession.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           // @Override
           // public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             //   select_profession = profession.getText().toString();
            }
       // });

       // submit_button.setOnClickListener(new View.OnClickListener() {

            //@Override
            //public void onClick(View view) {

                //if (Name.getText().toString().length() == 0) {
                   // Name.setError("Name can't be empty");
               //// } else if (age_range.getText().toString().isEmpty()) {
                  //  select_age_range.setError("Choose the Range First");
                ////} else if (profession.getText().toString().isEmpty()) {
                   // select_profession.setError("Choose the Profession listed below");
               //// } else (phone_no.getText().toString().isEmpty()) {
                    //phone_no.setError("Phone number cannot be empty");
                   // {

                       // j.setPhone_number(phone_no.getText().toString());
                        //j.setGender(selected_radio_text);
                        //j.setName(Name.getText().toString());
//                        j.setAge(profession.getText().toString());


                        //Intent intent = new Intent(Register.this, Final.class);
                       // intent.putExtra(Jin.EXTRA, j);
                       // startActivity(intent);


                    }
               // }
           // }
        //});

   // }
//}

