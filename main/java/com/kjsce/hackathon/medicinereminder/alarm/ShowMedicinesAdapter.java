package com.kjsce.hackathon.medicinereminder.alarm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import com.kjsce.hackathon.medicinereminder.R;
import com.kjsce.hackathon.medicinereminder.medicine.Medicine;

import java.util.List;

/**
 * Created by anant on 1/10/16.
 */

public class ShowMedicinesAdapter extends RecyclerView.Adapter<ShowMedicinesAdapter.MedicineViewHolder> {
    List<Medicine> medicineList;
    Context mContext;

    public class MedicineViewHolder extends RecyclerView.ViewHolder{
        CheckedTextView medicineName;
        public MedicineViewHolder(View itemView) {
            super(itemView);
            medicineName = (CheckedTextView) itemView.findViewById(R.id.show_pill_name);
            medicineName.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            medicineName.toggle();
                        }
                    }
            );
        }
    }

    public ShowMedicinesAdapter(Context context, List<Medicine> medicineList) {
        this.medicineList = medicineList;
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return medicineList.size();
    }

    @Override
    public ShowMedicinesAdapter.MedicineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.show_meal_time_medicines_row, parent, false);

        return new MedicineViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ShowMedicinesAdapter.MedicineViewHolder holder, int position) {
        Medicine medicine = medicineList.get(position);
        holder.medicineName.setText(medicine.getName());
    }
}
