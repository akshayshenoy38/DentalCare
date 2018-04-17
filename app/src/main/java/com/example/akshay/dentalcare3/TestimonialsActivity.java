package com.example.akshay.dentalcare3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TestimonialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testimonials);

        getSupportActionBar().setTitle("Testimonials");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
