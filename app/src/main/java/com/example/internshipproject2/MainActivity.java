package com.example.internshipproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.ClosedSubscriberGroupInfo;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {


    Button login_button;
    TextInputEditText username, password;

    Jin j;
    String login_url,result;

    ProgressDialog dialog;
    String customer_username,customer_password;
    List<Login_Getter_Setter> model;

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        login_button = findViewById(R.id.login_button);
        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);

        model = new ArrayList<>();

        j = new Jin();
        login_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//                if (username.getText().toString().length() == 0) {
//                    username.setError("Username can't be empty");
//                } else if (password.getText().toString().isEmpty()) {
//                    password.setError("Password can't be empty");
//                } else {
//
//                    //j.setUsername(username.getText().toString());
//                    //j.setPassword(password.getText().toString());
//
//                    Toast.makeText(MainActivity.this, username.getText(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(MainActivity.this, password.getText(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
//
//                    Intent intent = new Intent(MainActivity.this, Search_filter.class);
//                    intent.putExtra(Jin.EXTRA, j);
//                    startActivity(intent);
//
//                }

                if (username.getText().toString().length()==0 ) {
                    username.setError("Username can't be empty");
                }else if(password.getText().length()==0){
                    password.setError("Password can't be empty");
                }else{
                    login_url = "https://screechy-buzzers.000webhostapp.com/login.php?username="+username.getText().toString();
                    Log.v("Login",""+login_url);

                    dialog = new ProgressDialog(MainActivity.this);
                    dialog.setMessage("Checking your credentials.");
                    dialog.show();

                    executorService.execute(new Runnable() {
                        @Override
                        public void run() {

                            try
                            {
                                Json o = new Json();
                                result = o.insert(login_url);
                                model = new ArrayList<>();

                                JSONObject jsonObject = new JSONObject(result);
                                JSONArray jsonArray = jsonObject.getJSONArray("res");

                                Log.v("Login_DATA",""+result);

                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject jsonObject11 = jsonArray.getJSONObject(i);
                                    Login_Getter_Setter p = new Login_Getter_Setter();

                                    p.setUsername(jsonObject11.getString("username"));
                                    p.setPassword(jsonObject11.getString("password"));

                                    model.add(p);

                                    customer_username = p.getUsername();
                                    customer_password = p.getPassword();

                                    Log.v("username","id: "+username +" pass: "+password);
                                    Log.v("customer_username","id: "+customer_username +" pass: "+customer_password);

                                }
                            }
                            catch ( JSONException e)
                            {
                                e.printStackTrace();
                                //  Toast.makeText(Login.this, "Please check your Internet Connection and Retry", Toast.LENGTH_LONG).show();
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //write your UI part here....
                                    if (username.getText().toString().equals(customer_username) && password.getText().toString().equals(customer_password))
                                    {
                                        Toast.makeText(MainActivity.this, " Login Sucessful!!", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                        Intent intent = new Intent(MainActivity.this, Search_filter.class);
                                        startActivity(intent);
                                        finish();

                                    }
                                    else{
                                        dialog.dismiss();
                                        Toast.makeText(MainActivity.this, " Email or Password is Incorrect!! ", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                        }
                    });



                }

            }
        });
    }
}
