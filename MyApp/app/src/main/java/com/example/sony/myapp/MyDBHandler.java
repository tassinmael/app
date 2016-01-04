package com.example.sony.myapp;
 import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
 import android.content.ContentValues;
 import android.widget.Toast;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";
    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_BEERS = "beers";
    private static final String COLUMN_WHISKY = "whisky";
    private static final String COLUMN_WINE = "wine";
    private static final String COLUMN_vodka = "vodka";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE" + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_DATE + " TEXT," +
                COLUMN_BEERS + "INTEGER," +
                COLUMN_WHISKY + "INTEGER," +
                COLUMN_WINE + "INTEGER," +
                COLUMN_vodka + "INTEGER" +
                ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PRODUCTS);
        onCreate(db);

    }

    // add a new row the database
    public void addProduct(Products product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, product.get_date());
        values.put(COLUMN_BEERS, product.get_beers());
        values.put(COLUMN_WHISKY, product.get_whisky());
        values.put(COLUMN_WINE, product.get_wine());
        values.put(COLUMN_vodka, product.get_vodka());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }



    // print out the database as a string
    public String databaseToString () {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = " SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";

        // cursor points to a location in your results

        Cursor c = db.rawQuery(query, null);
        // move to the first row in the results
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("date")) != null) {
            dbString += c.getString(c.getColumnIndex("date"));
            dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }
}
