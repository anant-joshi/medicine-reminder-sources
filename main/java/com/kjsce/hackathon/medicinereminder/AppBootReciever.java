package com.kjsce.hackathon.medicinereminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.kjsce.hackathon.medicinereminder.alarm.AlarmFragment;


public class AppBootReciever extends BroadcastReceiver {
    private SharedPreferences preferences;
    @Override
    public void onReceive(Context context, Intent intent) {

        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if(preferences.contains("breakfast")){
            setAlarmForMeal(context,"breakfast");
        }
        if(preferences.contains("lunch")){
            setAlarmForMeal(context,"lunch");
        }
        if(preferences.contains("dinner")){
            setAlarmForMeal(context,"dinner");
        }


    }
    private void setAlarmForMeal(Context context,String mealName){
        if (preferences == null) throw new AssertionError();
        String mealTime = preferences.getString(mealName, "nada");
        if( mealTime.equalsIgnoreCase("nada")) throw new AssertionError();
        int hours = Integer.parseInt(mealTime.substring(0,2));
        int minutes = Integer.parseInt(mealTime.substring(3,5));
        int mealCode = AlarmFragment.getMealCodeFromName(mealName);
        AlarmFragment.addAlarm(context, hours, minutes, mealCode);
    }



}
