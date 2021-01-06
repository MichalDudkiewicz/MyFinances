package com.example.myfinances2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myfinances2.model.Category;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "categories";
    private static final String TABLE_NAME2 = "history";
    private static final String COL1 = "category";
    private static final String COL2 = "value";

    private static final String COL21 = "category";
    private static final String COL22 = "value";
    private static final String COL23 = "date";


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable1 = "CREATE TABLE " + TABLE_NAME + " ( " + COL1 + " VARCHAR(30) PRIMARY KEY, " +
                COL2 +" INTEGER)";
        db.execSQL(createTable1);
        String createTable2 = "CREATE TABLE " + TABLE_NAME2 + " ( " + COL21 + " VARCHAR(30), " +
                COL22 +" INTEGER, "+ COL23 +" DATETIME)";
        db.execSQL(createTable2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }

    public boolean addData(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, item);
        contentValues.put(COL2, 0);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns all the data from database
     * @return
     */
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getHistory(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME2 + " ORDER BY " + COL23 + " DESC";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getCategoryValue(String category){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL2 + " FROM " + TABLE_NAME +
                " WHERE " + COL1 + " = '" + category + "'";
        return db.rawQuery(query, null);
    }

    public void updateCategory(Category category){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = getCategoryValue(category.name());
        cursor.moveToFirst();
        Integer oldValue = cursor.getInt(cursor.getColumnIndex(COL2));
        cursor.close();
        Integer diff = category.value() - oldValue;
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + category.value() + "' WHERE " + COL1 + " = '" + category.name() + "'";
        Log.d(TAG, "updateName: query: " + query);
        db.execSQL(query);

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL21, category.name());
        contentValues.put(COL22, diff);
        String newstring = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        contentValues.put(COL23, newstring);

        Log.d(TAG, "addData: Adding " + category.name() + " to " + TABLE_NAME2);

        long result = db.insert(TABLE_NAME2, null, contentValues);
    }

    /**
     * Delete from database
     * @param id
     * @param name
     */
    public void deleteName(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }

    public Cursor getGroupedByMonthAndCateoory(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT strftime('%m-%Y', " + COL23 + "), " + COL21 + ", SUM(" + COL22 + ") FROM " + TABLE_NAME2 + " GROUP BY strftime('%m-%Y', " + COL23 + "), " + COL21 + " ORDER BY strftime('%m-%Y', " + COL23 + ");";
        return db.rawQuery(query, null);
    }


}
