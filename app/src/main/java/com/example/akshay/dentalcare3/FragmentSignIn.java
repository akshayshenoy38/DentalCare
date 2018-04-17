package com.example.akshay.dentalcare3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Akshay on 21-03-2018.
 */

public class FragmentSignIn extends Fragment {
    View view;
    Button btnRegisterNow,btnLogin;
    private SharedPreferenceConfig preferenceConfig;

    EditText etLoginEmail,etLoginPassword;
    ViewPager viewPager;
    public FragmentSignIn() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.signin_fragment,container,false);
        btnRegisterNow = (Button) view.findViewById(R.id.btnRegisterNow);
        viewPager = (ViewPager) getActivity().findViewById(R.id.vpViewPager);

        preferenceConfig = new SharedPreferenceConfig(getActivity());

        etLoginEmail = (EditText) view.findViewById(R.id.etLoginEmail);
        etLoginPassword = (EditText) view.findViewById(R.id.etLoginPassword);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);

        final FirebaseAuth firebaseAuth;

        firebaseAuth = FirebaseAuth.getInstance();

        btnRegisterNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()){
                    // upload data to database

                    String user_email = etLoginEmail.getText().toString().trim();
                    String user_password = etLoginPassword.getText().toString().trim();

                    firebaseAuth.signInWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                toastMessage("Sign in Successful");
                                preferenceConfig.writeLoginStatus(true);
                                startActivity(new Intent(getActivity(),MainPageActivity.class));
                            } else {
                                toastMessage("Sign in  Failed");
                            }
                        }
                    });

                }
            }
        });





        return view;
    }


    private boolean validate(){
        boolean result = false;

        String email = etLoginEmail.getText().toString();
        String password = etLoginPassword.getText().toString();

        if (email.isEmpty() && password.isEmpty()){
            toastMessage("Please enter all details");
        } else {
            result = true;
        }

        return result;
    }






    private void toastMessage(String s) {
        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
    }
}
