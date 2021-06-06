package com.example.internshipproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Final extends AppCompatActivity {
    
    ListView list_view;
    List<UserModel> userModel;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        list_view = findViewById(R.id.list_view);
        adapter = new CustomAdapter();

        userModel = new ArrayList<>();
        userModel.add(new UserModel("Namita Shah","18-45","IT"));
        userModel.add(new UserModel("Nandini Shah","18-45","IT"));

        list_view.setAdapter(adapter);
        
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return userModel.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.list_item,null);

            TextView name_tv = (TextView) convertView.findViewById(R.id.name_tv);
            TextView age_tv = (TextView) convertView.findViewById(R.id.age_tv);
            TextView profession_tv = convertView.findViewById(R.id.profession_tv);

            UserModel p = userModel.get(position);

            name_tv.setText(p.getName());
            age_tv.setText(p.getAge());
            profession_tv.setText(p.getProfession());

            return convertView;

        }
    }
    
}