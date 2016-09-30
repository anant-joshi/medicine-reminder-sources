package com.kjsce.hackathon.medicinereminder;

/**
 * Created by anant on 30/9/16.
 */

public class DaysOfWeek {
    private int daysOfWeek;
    private boolean[] daysOfWeekArray;

    public DaysOfWeek(int daysOfWeek){
        this.daysOfWeek = daysOfWeek;
        this.daysOfWeekArray = setDaysOfWeekArray(daysOfWeek);

    }

    public DaysOfWeek(boolean[] daysOfWeekArray){
        this.daysOfWeekArray = daysOfWeekArray;
        this.daysOfWeek = setDaysOfWeek(daysOfWeekArray);
    }

    public int getDaysOfWeek() {
        return daysOfWeek;
    }

    public boolean[] getDaysOfWeekArray() {
        return daysOfWeekArray;
    }

    private boolean[] setDaysOfWeekArray(int daysOfWeek){
        return getDaysOfWeekArray(daysOfWeek);
    }

    private int setDaysOfWeek(boolean[] daysOfWeekArray){
        return getDaysOfWeek(daysOfWeekArray);
    }

    public static boolean[] getDaysOfWeekArray(int daysOfWeek){
        boolean[] arr = new boolean[7];
        for (int i = 6; i >= 0; i--) {
            arr[i] = (daysOfWeek & (1 << i)) != 0;
        }
        return arr;
    }

    private static int getDaysOfWeek(boolean[] daysOfWeekArray){
        int daysOfWeek = 0;
        for (int i = daysOfWeekArray.length - 1; i >=0 ; i--){
            daysOfWeek = (daysOfWeek << 1) | (daysOfWeekArray[i] ? 1 : 0);
        }
        return daysOfWeek;
    }
}

