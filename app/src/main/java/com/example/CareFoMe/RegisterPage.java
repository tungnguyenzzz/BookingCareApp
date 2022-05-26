package com.example.CareFoMe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        final DBHelper d1=new DBHelper(this);
        final Intent mainPage=new Intent(RegisterPage.this,MainPage.class);//khoi tao Intent de chay Mainpage

        final TextView n1=findViewById(R.id.Name);
        final  TextView e1=findViewById(R.id.EmailId);
        final   TextView p1=findViewById(R.id.Password);
        final  TextView ph1=findViewById(R.id.AptTime);

     final   Button b1=findViewById(R.id.button2);
        //final   Button b2=findViewById(R.id.buttonalLogin);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pd=ph1.getText().toString();
                String Email=e1.getText().toString();
                String Name=n1.getText().toString();
                String Password=p1.getText().toString();


                // int ph=Integer.valueOf(pd);
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                    Toast.makeText(getApplicationContext(), "please enter valid Email ", Toast.LENGTH_LONG).show();

                }
                else if(d1.checkUser(e1.getText().toString())){
                    Toast.makeText(getApplicationContext(), "user is already exits! ", Toast.LENGTH_LONG).show();

                }else{
                    d1.DataInsert(n1.getText().toString(), pd, p1.getText().toString(), e1.getText().toString());
                    Toast.makeText(getApplicationContext(), "Register Succesful Please Login", Toast.LENGTH_LONG).show();
                    startActivity(mainPage);//Start Mainpage Activity
                    n1.setText("");
                    e1.setText("");
                    ph1.setText("");
                }




            }
        });









    }
}
