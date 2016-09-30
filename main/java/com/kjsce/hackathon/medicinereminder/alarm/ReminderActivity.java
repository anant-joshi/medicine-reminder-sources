package com.kjsce.hackathon.medicinereminder.alarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kjsce.hackathon.medicinereminder.R;

public class ReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        if(findViewById(R.id.activity_reminder) != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.activity_reminder,new AlarmFragment())
                    .commit();
        }
    }
}
