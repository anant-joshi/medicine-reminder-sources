package com.kjsce.hackathon.medicinereminder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.kjsce.hackathon.medicinereminder.setting_meals.SetMealsFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String MEAL_TIME_FRAGMENT_TAG = "MTFT";
    private static final String MAIN_FRAGMENT_TAG = "MFT";

    String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean breakfast, lunch, dinner;
        breakfast = preferences.contains("breakfast");
        lunch = preferences.contains("lunch");
        dinner = preferences.contains("dinner");

        final Fragment fragment;

        if(breakfast && lunch && dinner){
            fragment = new MainFragment();
            tag = MAIN_FRAGMENT_TAG;
            if(findViewById(R.id.activity_main)!=null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main, fragment, tag)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();
            }
        }else{
            fragment = new SetMealsFragment();
            tag = MEAL_TIME_FRAGMENT_TAG;
            if(findViewById(R.id.activity_main)!=null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main, fragment, tag)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }

        }
    }

    @Override
    public void onBackPressed() {
        if(Objects.equals(tag, MEAL_TIME_FRAGMENT_TAG))
        {

            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
            if(relativeLayout != null) relativeLayout.removeAllViews();

            tag = MAIN_FRAGMENT_TAG;
            if(findViewById(R.id.activity_main) != null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main, new MainFragment(), tag)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();
            }
        }else{
            super.onBackPressed();
            finish();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment = new SetMealsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit();

        return true;
    }
}