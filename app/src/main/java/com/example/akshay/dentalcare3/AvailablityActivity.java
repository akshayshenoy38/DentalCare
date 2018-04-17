package com.example.akshay.dentalcare3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AvailablityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availablity);

        getSupportActionBar().setTitle("Availablity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    public void showBookAppointment(android.view.View view) {
        startActivity(new android.content.Intent(AvailablityActivity.this,BookingAppointmentActivity.class));
    }
}
