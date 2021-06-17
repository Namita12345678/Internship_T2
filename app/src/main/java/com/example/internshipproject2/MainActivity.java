package com.example.internshipproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.ClosedSubscriberGroupInfo;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {


    Button login_button;
    TextInputEditText username, password;

    Jin j;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        login_button = findViewById(R.id.login_button);
        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);

        j = new Jin();
        login_button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if (username.getText().toString().length() == 0) {
                    username.setError("Username can't be empty");
                } else if (password.getText().toString().isEmpty()) {
                    password.setError("Password can't be empty");
                } else {

                    //j.setUsername(username.getText().toString());
                    //j.setPassword(password.getText().toString());

                    Toast.makeText(MainActivity.this, username.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, password.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, Search_filter.class);
                    intent.putExtra(Jin.EXTRA, j);
                    startActivity(intent);

                }


            }
        });
    }
}
