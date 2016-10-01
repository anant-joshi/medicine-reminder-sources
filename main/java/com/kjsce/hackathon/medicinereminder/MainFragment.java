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

import java.util.LinkedList;
import java.util.List;


public class MainFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_add_remove_main, container, true);

        RecyclerView recyclerView = (RecyclerView) container.findViewById(R.id.recycler_view);
        TextView addButton = (TextView) container.findViewById(R.id.add);

        mAdapter = new MedicineAdapter(getActivity() ,medicinesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareDepartmentData();
        addListenerToAddButton(addButton);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void addListenerToAddButton(View v) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddMedicineActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Medicine> medicinesList = new LinkedList<>();
    private MedicineAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void prepareDepartmentData() {
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        medicinesList.addAll(dbHelper.getAllStats());
        mAdapter.notifyDataSetChanged();
    }

}
