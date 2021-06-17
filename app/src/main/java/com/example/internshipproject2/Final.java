package com.example.internshipproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
    ArrayList list = new ArrayList();
    final ExecutorService executorService = Executors.newSingleThreadExecutor();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        list_view = findViewById(R.id.list_view);
        //adapter = new CustomAdapter();

        userModel = new ArrayList<>();
        Intent i = getIntent();
        url = i.getStringExtra("URL");
        Log.d("url", "URL: " + url);
        //retrieve();

         userModel.add(new UserModel("Namita Shah","18","F", "namitashah42@gmail.com",  "6352007588", "IT"));
        userModel.add(new UserModel("Nandini Shah","18","F", "nandinishah88@gmail.com","8780237219","IT"));

        list_view.setAdapter(adapter);

    }

    void retrieve() {


        executorService.execute(new Runnable() {  //data retrieve
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
                       // p.setAge(jsonObj.getString("age"));
                        //p.setGender(jsonObj.getString("gender"));
                        //p.setProfession(jsonObj.getString("profession"));
                        //p.setPhoneNumber(jsonObj.getString("phone_number"));
                        //p.setEmail(jsonObj.getString("email"));
                        list.add(p);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        runOnUiThread(new Runnable() {  //set
                @Override
                public void run() {
                     Log.d("100",list.size()+"");


                    adapter = new CustomAdapter(Final.this,list);
                    list_view.setAdapter(adapter);

                }
            });

        }
    




    class CustomAdapter extends BaseAdapter {
        private Context context; //context
        private ArrayList list;
         public CustomAdapter(Context context,ArrayList list)
         {
             this.context=context;
             this.list=list;
             Log.d("PC",list.size()+"") ;
         }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int abc) {
            return list.get(abc);
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

            UserModel p = (UserModel)list.get(position);
             Log.d("151",p.getEmail()) ;
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