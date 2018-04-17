package com.example.akshay.dentalcare3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainPageActivity extends AppCompatActivity {
    Button btnAboutUs;
    private FirebaseAuth firebaseAuth;
    private SharedPreferenceConfig preferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        btnAboutUs = (Button) findViewById(R.id.btnAboutUs);
        firebaseAuth = FirebaseAuth.getInstance();

        //shared preference
        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());




    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuLogout:
                firebaseAuth.signOut();
                toastMessage("Logout Successful");
                preferenceConfig.writeLoginStatus(false);
                finish();
                startActivity(new Intent(MainPageActivity.this,MainActivity.class));
                break;


        }

        return true;
    }


    private void toastMessage(String s) {
        Toast.makeText(MainPageActivity.this,s,Toast.LENGTH_SHORT).show();
    }


    public void showAboutUs(View view) {
        startActivity(new Intent(MainPageActivity.this,AboutUsActivity.class));
    }

    public void showServices(View view) {
        startActivity(new Intent(MainPageActivity.this,ServicesActivity.class));
    }

    public void showBookAppointment(View view) {
        startActivity(new Intent(MainPageActivity.this,BookingAppointmentActivity.class));
    }

    public void showDocBlog(View view) {
        startActivity(new Intent(MainPageActivity.this,DocBlogActivity.class));
    }

    public void showTestimonials(View view) {
        startActivity(new Intent(MainPageActivity.this,TestimonialsActivity.class));
    }
    public void showAvailablityActivity(View view) {
        startActivity(new Intent(MainPageActivity.this,AvailablityActivity.class));
    }
}
