package com.example.survicateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.survicate.surveys.Survicate;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String userName = "";
    String userPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextName = findViewById(R.id.editTextTextPersonName);
        EditText editTextPassword = findViewById(R.id.editTextTextPassword);
        Button buttonSignUp = findViewById(R.id.buttonSignUp);



        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = editTextName.getText().toString();
                userPassword = editTextPassword.getText().toString();

                if (Objects.equals(userName, "kadir@gmail.com") && userPassword.equals("123456")){
                    Intent i = new Intent(getApplicationContext(),SecondActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Username or Password is wrong", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}