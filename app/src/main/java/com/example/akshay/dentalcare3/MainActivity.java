package com.example.akshay.dentalcare3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TabLayout tlTabLayout;
    private AppBarLayout alAppbarLayout;
    private ViewPager vpViewPager;

    private SharedPreferenceConfig preferenceConfig;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlTabLayout = (TabLayout) findViewById(R.id.tlTabLayout);
        alAppbarLayout = (AppBarLayout) findViewById(R.id.alAppBar);
        vpViewPager = (ViewPager) findViewById(R.id.vpViewPager);

        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());


        if (preferenceConfig.readLoginStatus()){
            startActivity(new Intent(this,MainPageActivity.class));
            finish();
        }

        // now sign up






        //Firebase





        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentSignIn(),"Sign in");
        adapter.addFragment(new FragmentSignUp(),"Sign Up");
        vpViewPager.setAdapter(adapter);
        tlTabLayout.setupWithViewPager(vpViewPager);















    }







}
