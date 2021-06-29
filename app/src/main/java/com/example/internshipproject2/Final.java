package com.example.internshipproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Final extends AppCompatActivity {

    ListView list_view;
    List<UserModel> userModel;
    CustomAdapter adapter;
    String result;
    String url;
    ProgressDialog dialog;
    TextView no_items_in_list;

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        list_view = findViewById(R.id.list_view);
        no_items_in_list = findViewById(R.id.no_items_in_list);

        userModel = new ArrayList<>();
        Intent i = getIntent();
        url = i.getStringExtra("URL");
        Log.d("url", "URL: " + url);
        //retrieve();

        retrieve();

    }

    void retrieve() {

        dialog = new ProgressDialog(Final.this);
        dialog.setMessage("Fetching data from Server.");
        dialog.show();

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    Json o = new Json();
                    result = o.insert(url);

                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("res");

                    Log.v("Login_DATA", "" + result);

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObj = jsonArray.getJSONObject(i);
                        UserModel p = new UserModel();

                        p.setName(jsonObj.getString("name"));
                        p.setAge(jsonObj.getString("age"));
                        p.setGender(jsonObj.getString("gender"));
                        p.setEmail(jsonObj.getString("email"));
                        p.setProfession(jsonObj.getString("profession"));
                        p.setPhoneNumber(jsonObj.getString("phone_number"));
                        userModel.add(p);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if(userModel.size() == 0){
                            no_items_in_list.setVisibility(View.VISIBLE);
                        }else{
                            no_items_in_list.setVisibility(View.GONE);
                            adapter = new CustomAdapter();
                            list_view.setAdapter(adapter);
                        }

                        dialog.dismiss();

                    }
                });

            }

        });

    }

    class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return userModel.size();
        }

        @Override
        public Object getItem(int abc) {
            return 0;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.list_item,null);

            TextView name_tv =  convertView.findViewById(R.id.name_tv);
            TextView age_tv =  convertView.findViewById(R.id.age_tv);
            TextView gender_tv = convertView.findViewById(R.id.gender_tv);
            TextView email_tv = convertView.findViewById(R.id.email_tv);
            TextView phone_no_tv = convertView.findViewById(R.id.phone_no_tv);
            TextView profession_tv = convertView.findViewById(R.id.profession_tv);

            UserModel p = (UserModel)userModel.get(position);

            name_tv.setText(p.getName());
            age_tv.setText(p.getAge());
            gender_tv.setText(p.getGender());
            email_tv.setText(p.getEmail());
            phone_no_tv.setText(p.getPhoneNumber());
            profession_tv.setText(p.getProfession());

            return convertView;


        }
    }

}