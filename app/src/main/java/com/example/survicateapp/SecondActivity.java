package com.example.survicateapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.survicate.surveys.Survicate;
import com.survicate.surveys.SurvicateAnswer;
import com.survicate.surveys.SurvicateEventListener;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    public static final String SCREEN_KEY = "Second";
    public static final String appPackageName = "fi.eleima.leimakortti";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Survicate.init(this);
        Survicate.enterScreen(SCREEN_KEY);

        Survicate.setEventListener(new SurvicateEventListener() {
            @Override
            public void onSurveyDisplayed(@NonNull String surveyId) {
                //Toast.makeText(getApplicationContext(), "on survey displayed", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onQuestionAnswered(@NonNull String surveyId, long questionId, @NonNull SurvicateAnswer answer) {
                if(answer.getId() !=null) {
                    Long result = answer.getId();

                    if (result == 5257669) {
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                    }

                    Log.d("survey_id:", result.toString());
                    //Toast.makeText(getApplicationContext(), "result: " + result.toString(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onSurveyClosed(@NonNull String surveyId) {
                //Toast.makeText(getApplicationContext(), "on survey closed", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSurveyCompleted(@NonNull String surveyId) {
                //Toast.makeText(getApplicationContext(), "on survey completed", Toast.LENGTH_SHORT).show();
            }
        });

        //Button trigger = findViewById(R.id.buttonTrigger);

        /*trigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Survicate.invokeEvent("signup");
                Survicate.setEventListener(new SurvicateEventListener() {
                    @Override
                    public void onSurveyDisplayed(@NonNull String surveyId) {
                        //Toast.makeText(getApplicationContext(), "on survey displayed", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onQuestionAnswered(@NonNull String surveyId, long questionId, @NonNull SurvicateAnswer answer) {

                        String result = answer.getValue();

                        Toast.makeText(getApplicationContext(), "result: " + result, Toast.LENGTH_SHORT).show();

                    }
                    @Override
                    public void onSurveyClosed(@NonNull String surveyId) {
                        //Toast.makeText(getApplicationContext(), "on survey closed", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onSurveyCompleted(@NonNull String surveyId) {
                        //Toast.makeText(getApplicationContext(), "on survey completed", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });*/



    }



    @Override
    protected void onDestroy(){
        super.onDestroy();
        Survicate.leaveScreen(SCREEN_KEY);
        Survicate.reset();
    }
}