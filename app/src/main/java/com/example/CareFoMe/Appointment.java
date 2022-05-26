package com.example.CareFoMe;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Calendar;

public class Appointment extends AppCompatActivity {
     Calendar myCalendar;
     DatePickerDialog DateSelector;

    NotificationManager NM;


    TextView Displaydate;
    String DateD;
    Button DatePickbtn;
    Button BookAP;
    Button TimeSlotBtn;
    String username,email,doc_name;
    DBHelper d3=new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);



        Displaydate=(TextView) findViewById(R.id.textViewDateDisplay);

        final TextView PName=findViewById(R.id.textViewName);

        final TextView PEmail=findViewById(R.id.textViewEmail);
        final TextView docc_name =findViewById(R.id.textViewdocname);
        //final Bundle bundle = getIntent().getExtras();
        final RadioButton R1=findViewById(R.id.radioButton);
        final RadioButton R2=findViewById(R.id.radioButton2);
        final RadioButton R3=findViewById(R.id.radioButton3);
        final RadioButton R4=findViewById(R.id.radioButton4);
        final RadioButton R5=findViewById(R.id.radioButton5);
        final RadioButton R6=findViewById(R.id.radioButton6);
        final RadioButton R7=findViewById(R.id.radioButton7);
        Intent getlogindata = getIntent();
        username =getlogindata.getStringExtra("username");
        email =getlogindata.getStringExtra("Email");
        doc_name=getlogindata.getStringExtra("Doc Name");



        PName.setText(username);
        PEmail.setText(email);

        docc_name.setText(doc_name);
        DatePickbtn=(Button)findViewById(R.id.buttonPickDate);
        DatePickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCalendar = Calendar.getInstance();
                int Year=myCalendar.get(Calendar.YEAR);
                int month=myCalendar.get(Calendar.MONTH);
                int day=myCalendar.get(Calendar.DAY_OF_MONTH);






                DateSelector= new DatePickerDialog(Appointment.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int myear, int mMonth, int mDay) {

                        Displaydate.setText(mDay+"/"+mMonth+"/"+myear);
                        DateD=Displaydate.getText().toString();

                    }
                },day,month,Year
                );
                DateSelector.getDatePicker().setMinDate(System.currentTimeMillis());



                DateSelector.show();




                DatePickbtn.setText("Choose Another date");



            }
        });
         TimeSlotBtn=(Button) findViewById(R.id.buttonTimeSlot);
        TimeSlotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PEmail.setVisibility(View.VISIBLE);

                PName.setVisibility(View.VISIBLE);
                BookAP.setVisibility(View.VISIBLE);

                if (d3.checkUserAppointment(DateD,"9:30 - 10:30",docc_name.getText().toString()) == false) {
                   // Toast.makeText(getApplicationContext(), "No ", Toast.LENGTH_LONG).show();
                    R1.setVisibility(View.VISIBLE);

                }
                if (d3.checkUserAppointment(DateD,"10:30 - 11:30",docc_name.getText().toString()) == false) {
                   //// Toast.makeText(getApplicationContext(), "No ", Toast.LENGTH_LONG).show();
                    R2.setVisibility(View.VISIBLE);

                }if (d3.checkUserAppointment(DateD,"11:30 - 12:30",docc_name.getText().toString()) == false) {
                   // Toast.makeText(getApplicationContext(), "No ", Toast.LENGTH_LONG).show();
                    R3.setVisibility(View.VISIBLE);

                }if (d3.checkUserAppointment(DateD,"2:00 - 3:00",docc_name.getText().toString()) == false) {
               // Toast.makeText(getApplicationContext(), "No ", Toast.LENGTH_LONG).show();
                    R4.setVisibility(View.VISIBLE);

                }if (d3.checkUserAppointment(DateD,"3:00 - 4:00",docc_name.getText().toString()) == false) {
                 //   Toast.makeText(getApplicationContext(), "No ", Toast.LENGTH_LONG).show();
                    R5.setVisibility(View.VISIBLE);

                }if (d3.checkUserAppointment(DateD,"4:00 - 5:00",docc_name.getText().toString()) == false) {
                 //   Toast.makeText(getApplicationContext(), "No ", Toast.LENGTH_LONG).show();
                    R6.setVisibility(View.VISIBLE);

                } if (d3.checkUserAppointment(DateD,"5:00 - 6:00",docc_name.getText().toString()) == false) {
                  //      Toast.makeText(getApplicationContext(), "No ", Toast.LENGTH_LONG).show();
                    R7.setVisibility(View.VISIBLE);

                }




            }
        });





        BookAP=(Button) findViewById(R.id.buttonBookA);
        BookAP.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {


                String ApTime ="";
                if(R1.isChecked()){
                   ApTime="9:30 - 10:30";
                   d3.DataInsert2(PName.getText().toString(),"",doc_name,PEmail.getText().toString(),DateD,ApTime);


                }if(R2.isChecked()){
                    ApTime="10:30 - 11:30";
                    d3.DataInsert2(PName.getText().toString(),"",doc_name,PEmail.getText().toString(),DateD,ApTime);


                }if(R3.isChecked()){
                    ApTime="11:30 - 12:30";
                    d3.DataInsert2(PName.getText().toString(),"",doc_name,PEmail.getText().toString(),DateD,ApTime);


                }if(R4.isChecked()){
                    ApTime="2:00 - 3:00";
                    d3.DataInsert2(PName.getText().toString(),"",doc_name,PEmail.getText().toString(),DateD,ApTime);


                }if(R5.isChecked()){
                    ApTime="3:00 - 4:00";
                    d3.DataInsert2(PName.getText().toString(),"",doc_name,PEmail.getText().toString(),DateD,ApTime);


                }if(R6.isChecked()){
                    ApTime="4:00 - 5:00";
                    d3.DataInsert2(PName.getText().toString(),"",doc_name,PEmail.getText().toString(),DateD,ApTime);


                }if(R7.isChecked()){
                    ApTime="5:00 - 6:00";
                    d3.DataInsert2(PName.getText().toString(),"",doc_name,PEmail.getText().toString(),DateD,ApTime);


                }

                Intent Form = new Intent(Appointment.this,FormDisplay.class);
                Form.putExtra("username",PName.getText().toString());
                Form.putExtra("Email",PEmail.getText().toString());
                Form.putExtra("AppointmentTime",ApTime);
                Form.putExtra("AppointmentDate",DateD);
                Form.putExtra("Doctor",doc_name);

                startActivity(Form);



            }
        });











    }


}
