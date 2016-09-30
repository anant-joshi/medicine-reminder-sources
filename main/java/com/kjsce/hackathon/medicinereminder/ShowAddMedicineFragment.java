package com.kjsce.hackathon.medicinereminder;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anant on 30/9/16.
 */

public class ShowAddMedicineFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_medicine_show, container, true);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
