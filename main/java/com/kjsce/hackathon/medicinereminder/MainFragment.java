package com.kjsce.hackathon.medicinereminder;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kjsce.hackathon.medicinereminder.medicine.Medicine;
import com.kjsce.hackathon.medicinereminder.medicine.MedicineAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_add_remove_main, container, true);

        recyclerView = (RecyclerView) container.findViewById(R.id.recycler_view);

        mAdapter = new MedicineAdapter(getActivity() ,medicinesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareDepartmentData();

        TextView addView = (TextView) rootView.findViewById(R.id.add_medicine);
        addView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), AddMedicineActivity.class);
                        startActivity(intent);
                    }
                }
        );

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    private List<Medicine> medicinesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MedicineAdapter mAdapter;

    @Override
    public void onResume() {
        prepareDepartmentData();
        recyclerView.swapAdapter(new MedicineAdapter(getActivity(), medicinesList),true);
        super.onResume();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void prepareDepartmentData() {
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        if(medicinesList.size()>0){
            medicinesList = new ArrayList<>();
        }
        medicinesList.addAll(dbHelper.getAllStats());
        mAdapter.notifyDataSetChanged();
    }





}
