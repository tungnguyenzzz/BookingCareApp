package com.example.CareFoMe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;


import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity

      {

    private DrawerLayout drawer;
    String username,email;
    String username1,Email1;
    FrameLayout frameLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);




        drawer = findViewById(R.id.drawer_layout);
        frameLayout = findViewById(R.id.fragment_container);//menubar
        Intent getlogindata = getIntent();//lay du lieu user tu thang login
       // Intent getlogindataFromhome=getIntent();
        username = getlogindata.getStringExtra("username");//lay ra username minh nhap
        email = getlogindata.getStringExtra("Email");//lay ra email minh nhap
        username1=username;
        Email1=email;

       // Toast.makeText(getApplicationContext(),username,Toast.LENGTH_LONG).show();



        //View headerView= navigationView.inflateHeaderView(R.layout.nav_header);






        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new Home()).commit();

                        break;

                    case R.id.nav_doc_List:

                        Intent doc = new Intent(NavigationDrawer.this, DoctorsList.class);
                        Intent home = new Intent(NavigationDrawer.this, Home.class);
                        doc.putExtra("username", username);
                        doc.putExtra("Email", email);
                        home.putExtra("username", username1);
                        home.putExtra("Email", Email1);
                        //Toast.makeText(getApplicationContext(),username,Toast.LENGTH_LONG).show();

                        startActivity(doc);
                        break;
                    case R.id.nav_schedule:
                        Intent schedule = new Intent(NavigationDrawer.this, ScheduleList.class);
                        schedule.putExtra("username", username);
                        schedule.putExtra("Email", email);
                        startActivity(schedule);
                        break;
                    case R.id.nav_pharmacy:
                        Intent pharm = new Intent(NavigationDrawer.this, Pharmacy_MapsActivity.class);
                        startActivity(pharm);

                        break;
                    case R.id.nav_logout:
                        Intent logt= new Intent(NavigationDrawer.this, LogoutActivity.class);
                        startActivity(logt);

                        break;

                }
                drawer.closeDrawer(GravityCompat.START);

                return true;
            }
        });
        //Hiện menu bar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Home()).commit();
            navigationView.setCheckedItem(R.id.nav_home);


        }}

        @Override// hàm này không cần thiết
        public void onBackPressed ()
        {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }



