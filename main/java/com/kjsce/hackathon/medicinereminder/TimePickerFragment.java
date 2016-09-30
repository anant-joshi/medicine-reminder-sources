package com.kjsce.hackathon.medicinereminder;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by anant on 30/9/16.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    public static final String PREFS_NAME = "mealtime_preference";
    SharedPreferences preferences = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        preferences = getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar defaultCalendar = Calendar.getInstance();
        int hours = defaultCalendar.get(Calendar.HOUR_OF_DAY);
        int minutes = defaultCalendar.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hours, minutes, DateFormat.is24HourFormat(getContext()));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        String mealName = getPreferenceFromArguments();
        String mealTime = ""+hourOfDay+"-"+minute;
        preferences.edit().putString(mealName, mealTime).apply();
    }

    private String getPreferenceFromArguments(){
        return getArguments().getString("meal_name");
    }
}
