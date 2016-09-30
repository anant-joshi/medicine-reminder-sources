package com.kjsce.hackathon.medicinereminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MEDICINE";

    private static final String KEY_ID = "id";
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
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_MEDICINE + " TEXT DEFAULT '',"
                + KEY_BREAKFAST + " INTEGER DEFAULT 0,"
                + KEY_LUNCH + "INTEGER DEFAULT 0,"
                + KEY_DINNER + "INTEGER DEFAULT 0,"
                + KEY_DAYS + "INTEGER DEFAULT 0," + ")";

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
}
