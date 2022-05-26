package com.example.CareFoMe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_display);

        final EditText PName=findViewById(R.id.Name);
        final EditText ApTime=findViewById(R.id.AptTime);
        final EditText PEmail=findViewById(R.id.EmailId);
        final TextView AppointmentDate= findViewById(R.id.textViewDateDisplay);
        final TextView DName=findViewById(R.id.FormDoctorName);

       final Bundle bundle = getIntent().getExtras();
     //  final Bundle bundleAppointment=getIntent().getExtras();


            String NameP = bundle.getString("username");
            String EmailP = bundle.getString("Email");
            String dname = bundle.getString("Doctor");
            String DateA = bundle.getString("AppointmentDate");
            String AptTime = bundle.getString("AppointmentTime");
            PName.setText(NameP);
            PEmail.setText(EmailP);
            ApTime.setText(AptTime);
            AppointmentDate.setText(DateA);
            DName.setText(dname);

        Button home = findViewById(R.id.buttonHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormDisplay.this, NavigationDrawer.class));
                Toast.makeText(FormDisplay.this, "Thank you", Toast.LENGTH_SHORT).show();
            }
        });






    }
}
