package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myapplication.ShopContract.*;
import androidx.annotation.Nullable;

public class ShoppingDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "shoppinglist.db";
    public static final int DATABASE_VERSION = 1;

    public ShoppingDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_SHOPPINGLIST_TABLE = "CREATE TABLE " +
                ShopEntry.TABLE_NAME + " (" +
                ShopEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ShopEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                ShopEntry.COLUMN_AMOUNT + " INTEGER NOT NULL, " +
                ShopEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";
            db.execSQL(SQL_CREATE_SHOPPINGLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ShopEntry.TABLE_NAME);
        onCreate(db);
    }
}
