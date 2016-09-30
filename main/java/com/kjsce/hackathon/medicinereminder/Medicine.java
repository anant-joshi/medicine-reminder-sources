package com.kjsce.hackathon.medicinereminder;

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
}

