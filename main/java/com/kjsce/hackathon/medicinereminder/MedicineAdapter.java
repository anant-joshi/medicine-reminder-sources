package com.kjsce.hackathon.medicinereminder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anant on 30/9/16.
 */
public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MyViewHolder> {

    private List<Medicine> medicinesList;
    private Context mcontext;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mMedName;
        public TextView mbreakfast;
        public TextView mLunch;
        public TextView mDinner;

        public MyViewHolder(View itemView) {
            super(itemView);
            mMedName = (TextView) itemView.findViewById(R.id.med_name);
            mbreakfast = (TextView) itemView.findViewById(R.id.breakfast);
            mLunch = (TextView) itemView.findViewById(R.id.lunch);
            mDinner = (TextView) itemView.findViewById(R.id.dinner);
        }
    }

    public MedicineAdapter(Context context, List<Medicine> medicinesList) {
        this.medicinesList = medicinesList;
        this.mcontext = context;
    }

    @Override
    public MedicineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medicine_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MedicineAdapter.MyViewHolder holder, int position) {
        Medicine medicines = medicinesList.get(position);
        holder.mMedName.setText(medicines.getName());
        String breakfast,lunch,dinner;
        breakfast=Integer.toString(medicines.getBreakfast());
        lunch = Integer.toString(medicines.getLunch());
        dinner = Integer.toString(medicines.getDinner());
        if(breakfast.equals("1"))
        {
            holder.mbreakfast.setText("After Breakfast");
            holder.mbreakfast.setVisibility(View.VISIBLE);
        }
        else if(breakfast.equals("-1"))
        {
            holder.mbreakfast.setText("Before Breakfast");
            holder.mbreakfast.setVisibility(View.VISIBLE);
        }

        if(lunch.equals("1"))
        {
            holder.mLunch.setText("After Lunch");
            holder.mLunch.setVisibility(View.VISIBLE);
        }
        else if(lunch.equals("-1"))
        {
            holder.mLunch.setText("Before Lunch");
            holder.mLunch.setVisibility(View.VISIBLE);
        }

        if(dinner.equals("1"))
        {
            holder.mDinner.setText("After Dinner");
            holder.mDinner.setVisibility(View.VISIBLE);
        }
        else if(dinner.equals("-1"))
        {
            holder.mDinner.setText("Before Dinner");
            holder.mDinner.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return medicinesList.size();
    }
}
