package com.kjsce.hackathon.medicinereminder.alarm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kjsce.hackathon.medicinereminder.DatabaseHelper;
import com.kjsce.hackathon.medicinereminder.R;
import com.kjsce.hackathon.medicinereminder.medicine.Medicine;

import java.util.ArrayList;
import java.util.List;


public class ShowMealTimeMedicinesFragment extends Fragment {


    private List<Medicine> medicinesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ShowMedicinesAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_show_meal_time_medicines, container, true);
        recyclerView = (RecyclerView) container.findViewById(R.id.show_medicine_recycler);

        mAdapter = new ShowMedicinesAdapter(getActivity() ,medicinesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareDepartmentData();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void prepareDepartmentData() {
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        List<Medicine> newList = new ArrayList<>();
        medicinesList.addAll(dbHelper.getAllStats());
        for(int i = 0; i<medicinesList.size(); i++){
            if(Medicine.isTakenToday(medicinesList.get(i).getDaysOfWeek())){
                newList.add(medicinesList.get(i));
            }
        }
        medicinesList = null;
        medicinesList = newList;
        mAdapter.notifyDataSetChanged();
    }



}
