package com.kjsce.hackathon.medicinereminder.alarm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kjsce.hackathon.medicinereminder.R;


public class ShowMealTimeMedicinesFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_show_meal_time_medicines, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
