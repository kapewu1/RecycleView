package com.example.myapplication.ShoppingList;

import android.provider.BaseColumns;

public class ShoppingContract {

    private ShoppingContract(){}

    public static final class ShoppingEntry implements BaseColumns{
        public static final String TABLE_NAME = "groceryList";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_TIMESTAMP = "timestamp";

    }


}
