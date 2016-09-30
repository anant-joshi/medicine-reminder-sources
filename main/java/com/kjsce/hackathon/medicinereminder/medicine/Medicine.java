package com.kjsce.hackathon.medicinereminder.medicine;

import java.util.Calendar;

/**
 * Created by anant on 30/9/16.
 */

public class Medicine {
    private String name;
    private int dinner;
    private int breakfast;
    private int lunch;
    private DaysOfWeek daysOfWeek;


    public Medicine(){

    }

    public Medicine(String mMedName, int mBreakfast,int mLunch, int mDinner){
        name = mMedName;
        breakfast = mBreakfast;
        lunch = mLunch;
        dinner = mDinner;
    }



    public int getDaysOfWeek(){
        return daysOfWeek.getDaysOfWeek();
    }

    public int getBreakfast() {
        return breakfast;
    }

    public String getName() {
        return name;
    }

    public int getDinner() {
        return dinner;
    }

    public int getLunch() {
        return lunch;
    }

    public void setBreakfast(int breakfast) {
        this.breakfast = breakfast;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLunch(int lunch) {
        this.lunch = lunch;
    }

    public void setDinner(int dinner) {
        this.dinner = dinner;
    }

    public void setDaysOfWeek(boolean[] days) {
        daysOfWeek = new DaysOfWeek(days);
    }

    public void setDaysOfWeek(int days) {
        daysOfWeek = new DaysOfWeek(days);
    }
    public static boolean isTakenToday(int daysOfWeek){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int today = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        for (int i = 6; i>=0; i--){
            if (i == today){
                if(daysOfWeek >= Math.pow(2, today)){
                    return true;
                }else{
                    return false;
                }
            }else{
                int pow = (int )Math.pow(2,i);
                if(daysOfWeek >= pow){
                    daysOfWeek -= pow;
                }
            }
        }
        return false;
    }
}

