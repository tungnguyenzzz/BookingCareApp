package com.example.CareFoMe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ScheduleList extends AppCompatActivity {
    RecyclerView recyclerView;
    ScheduleAdapter adapter;
//    String username,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_list);

//        Intent getlogindata = getIntent();
//
//        username =getlogindata.getStringExtra("username");
//        email =getlogindata.getStringExtra("Email");
        recyclerView = findViewById(R.id.RecyclerViewScheduleList);
        DBHelper sqlHelper = new DBHelper(this);
        List<Schedule> scheduleList = sqlHelper.getAllSchedule();

        adapter = new ScheduleAdapter(ScheduleList.this,scheduleList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));



    }
}
