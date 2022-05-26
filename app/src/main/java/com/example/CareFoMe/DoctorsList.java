package com.example.CareFoMe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DoctorsList extends AppCompatActivity {

    RecyclerView recyclerView;
    DBHelper dbHelper;
    CustomAdapter adapter;
    String username,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);
        List<String[]> returnList = new ArrayList();
        returnList=ReadCSV();//data cua bac si
        Intent getlogindata = getIntent();

        username =getlogindata.getStringExtra("username");
        email =getlogindata.getStringExtra("Email");


       // Toast.makeText(getApplicationContext(),Name,Toast.LENGTH_LONG).show();

        dbHelper = new DBHelper(this);
        // ListView lv = findViewById(R.id.ListViewDoc);


        for (int i =1; i < returnList.size(); i++)
        {
            UserData userData = new UserData();//doi tuong user
            //gan gia tri nhap vao cho cac thuoc tinh cua user
            userData.id = Integer.parseInt(returnList.get(i)[0]);
            userData.name= returnList.get(i)[1];
            userData.speciality = returnList.get(i)[2];
            userData.phone = returnList.get(i)[3];

            //luu vao db vao bang doctors
            dbHelper.insertDocDetail(userData);

        }

        //List<String[]> MyDBItems = dbHelper.getAllUser();
        // lv.setAdapter(new CustomAdapter(MyDBItems));

//        RecyclerView recyclerView = findViewById(R.id.RecyclerViewDocList);
        recyclerView = findViewById(R.id.RecyclerViewDocList);

        adapter = new CustomAdapter(this, dbHelper.getAllDoc(),username,email);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }


    //Doc file excel
    public List<String[]> ReadCSV()
    {


        List<String[]> resultList = new ArrayList();
        InputStream inputStream = getResources().openRawResource(R.raw.doctors);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try
        {
            String CSVline;
            while ((CSVline = reader.readLine()) != null)
            {
                String[] row = CSVline.split(",");
                resultList.add(row);
            }
        }
        catch (IOException ex)
        {
            //Log.e("DB demo" , ex.getMessage());
            throw new RuntimeException("Error reading a CSV File" + ex);
        }
        finally {
            try
            {
                inputStream.close();
            }
            catch (IOException ex)
            {
                throw new RuntimeException("Error in Closing the Stream" + ex);
            }
        }
        return resultList; //important to remember
    }


}
