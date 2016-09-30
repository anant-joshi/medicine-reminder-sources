package com.kjsce.hackathon.medicinereminder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String MEAL_TIME_FRAGMENT_TAG = "MTFT";
    public static final String PREFS_NAME = "mealtime_preference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = this.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
//        if(findViewById(R.id.activity_main)!=null){
//              getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.activity_main, new SetMealTimeFragment(), MEAL_TIME_FRAGMENT_TAG).commit();
//        }
        if(findViewById(R.id.activity_main) != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_main, new MainFragment()).commit();
        }
    }
}