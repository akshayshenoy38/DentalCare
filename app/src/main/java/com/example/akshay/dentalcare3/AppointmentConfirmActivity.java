package com.example.akshay.dentalcare3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;

public class AppointmentConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_confirm);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Confirm Appointment </font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
