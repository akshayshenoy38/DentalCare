package com.example.akshay.dentalcare3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
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

public class FragmentSignUp extends Fragment {
    private static final String TAG = "FragmentSignUp";
    View view;
    Button btnRegister;
    EditText etRegisterEmail,etRegisterPassword,etRegisrerFullName;
    ViewPager vp2ViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.signup_fragment,container,false);
        vp2ViewPager = (ViewPager) getActivity().findViewById(R.id.vpViewPager);
        btnRegister = view.findViewById(R.id.btnRegister);
        etRegisterEmail = (EditText) view.findViewById(R.id.etRegisterEmail);
        etRegisterPassword = (EditText) view.findViewById(R.id.etRegisterPassword);
        etRegisrerFullName = (EditText) view.findViewById(R.id.etRegisterFullName);
        Log.d(TAG, "onCreateView:  register");

        final FirebaseAuth firebaseAuth;

        firebaseAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()){
                    // upload data to database

                    String user_email = etRegisterEmail.getText().toString().trim();
                    String user_password = etRegisterPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                toastMessage("Registration Successful");
                                vp2ViewPager.setCurrentItem(0);
                                //startActivity(new Intent(getActivity(),MainPageActivity.class));
                            } else {
                                toastMessage("Registration Failed");
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

        String name = etRegisrerFullName.getText().toString();
        String email = etRegisterEmail.getText().toString();
        String password = etRegisterPassword.getText().toString();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
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
