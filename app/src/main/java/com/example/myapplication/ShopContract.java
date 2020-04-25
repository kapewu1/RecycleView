package com.example.myapplication;

import android.provider.BaseColumns;

public class ShopContract {

    private ShopContract(){}

    public static final class ShopEntry implements BaseColumns{
        public static final String TABLE_NAME = "groceryList";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_TIMESTAMP = "timestamp";

    }


}
