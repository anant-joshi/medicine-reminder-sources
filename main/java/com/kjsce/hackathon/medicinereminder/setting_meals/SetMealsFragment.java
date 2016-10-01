package com.kjsce.hackathon.medicinereminder.setting_meals;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kjsce.hackathon.medicinereminder.R;


public class SetMealsFragment extends Fragment {
    public static final String FRAGMENT_NAME = "set_meal_time";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_meals,container,true);

        CardView breakfastCard = (CardView) rootView.findViewById(R.id.breakfast_button_card);
        CardView lunchCard = (CardView) rootView.findViewById(R.id.lunch_button_card);
        CardView dinnerCard = (CardView) rootView.findViewById(R.id.dinner_button_card);

        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        //HACK
        boolean breakfast = preferences.contains("breakfast");
        boolean lunch = preferences.contains("lunch");
        boolean dinner = preferences.contains("dinner");
        if(breakfast) breakfastCard.setVisibility(View.GONE);
        if(lunch) lunchCard.setVisibility(View.GONE);
        if(dinner) dinnerCard.setVisibility(View.GONE);

        breakfastCard.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle args = new Bundle();
                        args.putString("meal_time","breakfast");
                        launchFragment(args);
                    }
                }
        );

        lunchCard.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle args = new Bundle();
                        args.putString("meal_time","lunch");
                        launchFragment(args);
                    }
                }
        );

        dinnerCard.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle args = new Bundle();
                        args.putString("meal_time","dinner");
                        launchFragment(args);
                    }
                }
        );

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    public void launchFragment(Bundle args){
        Fragment setMealTimeFragment = new SetMealTimeFragment();
        setMealTimeFragment.setArguments(args);
        getFragmentManager().beginTransaction().add(setMealTimeFragment, FRAGMENT_NAME).commit();
    }
}
