package com.kjsce.hackathon.medicinereminder;

import java.util.Calendar;

public class MealTimes {
    private static Calendar breakfast;
    private static Calendar lunch;
    private static Calendar dinner;
    public static Calendar getBreakfast() {
        return breakfast;
    }

    public static void setBreakfast(int hourOfDay) {
        Calendar breakfast = Calendar.getInstance();
    }

    public static Calendar getDinner() {
        return dinner;
    }

    public static void setDinner(Calendar dinner) {
        MealTimes.dinner = dinner;
    }

    public static Calendar getLunch() {
        return lunch;
    }

    public static void setLunch(Calendar lunch) {
        MealTimes.lunch = lunch;
    }
}
