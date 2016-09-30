package com.kjsce.hackathon.medicinereminder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;



public class SetMealTimeFragment extends Fragment {
    private Bundle args;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        args = getArguments();
        DialogFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        fragment.show(getFragmentManager(), "timePicker");
        super.onCreate(savedInstanceState);

    }
}
