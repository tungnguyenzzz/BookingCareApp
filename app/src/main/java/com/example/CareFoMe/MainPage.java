package com.example.CareFoMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        Button btn_reg = findViewById(R.id.buttonReg);
        Button btn_log = findViewById(R.id.buttonLogin);



        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(MainPage.this,RegisterPage.class);
                startActivity(intent);




            }
        });
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(MainPage.this,LoginActivity.class);
                startActivity(intent);




            }
        });
    }
}
