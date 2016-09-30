package com.kjsce.hackathon.medicinereminder;

/**
 * Created by anant on 30/9/16.
 */

public class DaysOfWeek {
    private int daysOfWeek;
    private DaysOfWeek(){}
    public static void hello(){}

    public int getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(int daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }
    public static boolean[] getDaysOfWeekArray(int daysOfWeek){
        boolean[] arr =  new boolean[7];
        for(int i = 6; i>=0; i--){
            int power = (int) Math.pow(2,i);
            if(daysOfWeek>=power){
                arr[i] = true;
                daysOfWeek -= power;
            }
        }
        return arr;
    }
    public void setDaysOfWeek(boolean[] daysOfWeekArray){
        for (int i = 0; i< daysOfWeekArray.length; i++){
            daysOfWeek+=(daysOfWeekArray[i])?Math.pow(2,i):0;
        }
    }

    public static int getDaysOfWeek(boolean[] daysOfWeekArray){
        int daysOfWeek = 0;
        for (int i = 0; i< daysOfWeekArray.length; i++){
            daysOfWeek+=(daysOfWeekArray[i])?Math.pow(2,i):0;
        }
        return daysOfWeek;
    }
}
