package com.example.akshay.dentalcare3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class BookingAppointmentActivity extends AppCompatActivity {
    Button btnSaveAndNextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_appointment);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Book Appointment </font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        initWidgets();


        btnSaveAndNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookingAppointmentActivity.this,AppointmentConfirmActivity.class));
            }
        });



        initCalender();







    }

    private void initWidgets() {
        btnSaveAndNextPage = (Button) findViewById(R.id.btnSaveAndNextPage);
    }


    public void initCalender(){


        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DAY_OF_MONTH, 0);

/* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);


        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();


        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

                String selectedDateStr = DateFormat.format("EEE, MMM d, yyyy", date).toString();
                Toast.makeText(BookingAppointmentActivity.this, selectedDateStr + " selected!", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onCalendarScroll(HorizontalCalendarView calendarView, int dx, int dy) {

            }


            @Override
            public boolean onDateLongClicked(Calendar date, int position) {
                return super.onDateLongClicked(date, position);
            }
        });



    }

    private void toastMessage(String s) {
        Toast.makeText(BookingAppointmentActivity.this,s,Toast.LENGTH_LONG).show();
    }




}
