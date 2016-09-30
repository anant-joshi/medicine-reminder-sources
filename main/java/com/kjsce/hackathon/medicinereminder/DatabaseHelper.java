package com.kjsce.hackathon.medicinereminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MEDICINE";

    private static final String KEY_MEDICINE = "medicine_name";
    private static final String KEY_BREAKFAST = "med_breakfast";
    private static final String KEY_LUNCH = "med_lunch";
    private static final String KEY_DINNER = "med_dinner";
    private static final String KEY_DAYS = "med_days";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + DATABASE_NAME + "("
                + KEY_MEDICINE + " TEXT DEFAULT '', "
                + KEY_BREAKFAST + " INTEGER DEFAULT 0, "
                + KEY_LUNCH + " INTEGER DEFAULT 0, "
                + KEY_DINNER + " INTEGER DEFAULT 0, "
                + KEY_DAYS + " INTEGER DEFAULT 0 " + ")";

        Log.d("Table", CREATE_TABLE);

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
            onCreate(db);
        }
    }

    public void addEntry(Medicine m){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_MEDICINE, m.getName());
        values.put(KEY_BREAKFAST, m.getBreakfast());
        values.put(KEY_LUNCH, m.getLunch());
        values.put(KEY_DINNER, m.getDinner());
        values.put(KEY_DAYS, m.getDaysOfWeek());

        database.insertWithOnConflict(DATABASE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        database.close();
    }

    public void removeEntry(String medicineName){
        SQLiteDatabase database = this.getWritableDatabase();

        String DELETE_ENTRY = "DELETE FROM " + DATABASE_NAME +
                " WHERE " + KEY_MEDICINE + " = '" + medicineName +"'";

        database.execSQL(DELETE_ENTRY);
    }

    public List<Medicine> getAllStats(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Medicine> medicineList = new LinkedList<>();

        String selectQuery = "SELECT  * FROM " + DATABASE_NAME;

        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                if (cursor.moveToFirst()) {
                    do {
                        Medicine m = new Medicine();
                        m.setName(cursor.getString(cursor.getColumnIndex(KEY_MEDICINE)));
                        m.setBreakfast(cursor.getInt(cursor.getColumnIndex(KEY_BREAKFAST)));
                        m.setLunch(cursor.getInt(cursor.getColumnIndex(KEY_LUNCH)));
                        m.setDinner(cursor.getInt(cursor.getColumnIndex(KEY_DINNER)));
                        m.setDaysOfWeek(cursor.getInt(cursor.getColumnIndex(KEY_DAYS)));
                        medicineList.add(m);
                    } while (cursor.moveToNext());
                }

            } finally {
                try { cursor.close(); } catch (Exception ignore) {}
            }

        } finally {
            try { db.close(); } catch (Exception ignore) {}
        }

        return medicineList;
    }
}

