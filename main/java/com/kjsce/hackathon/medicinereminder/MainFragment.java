package com.kjsce.hackathon.medicinereminder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_remove_main, container, false);
    }
    private List<Medicine> medicinesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MedicineAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);

        mAdapter = new MedicineAdapter(getActivity() ,medicinesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareDepartmentData();

    }

    private void prepareDepartmentData() {

        medicinesList.add(new Medicine("Metacin",1,0,1));
        medicinesList.add(new Medicine("Anacin",1,0,1));
        medicinesList.add(new Medicine("Metacin",0,0,1));
        medicinesList.add(new Medicine("Metacin",0,1,1));
        medicinesList.add(new Medicine("Metacin",1,0,1));
        medicinesList.add(new Medicine("Metacin",0,0,1));
        medicinesList.add(new Medicine("Metacin",1,0,0));
        medicinesList.add(new Medicine("Metacin",1,1,1));
        mAdapter.notifyDataSetChanged();

    }

}
