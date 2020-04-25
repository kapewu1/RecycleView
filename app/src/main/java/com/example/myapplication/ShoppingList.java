package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ShoppingList extends AppCompatActivity {
   private SQLiteDatabase DATABASE;
    private ShoppingAdapter ADAPTER;
    private EditText inputData;
    private TextView textAmount;
    private int mAmount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list);

        ShoppingDBHelper dbHelper = new ShoppingDBHelper(this);
        DATABASE = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = findViewById(R.id.shop_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ADAPTER = new ShoppingAdapter(this,getAllItems());
        recyclerView.setAdapter(ADAPTER);

        inputData = findViewById(R.id.edittext_name);
        textAmount = findViewById(R.id.textview_amount);



        Button buttonAdd = findViewById(R.id.button_add);

        ImageView increaseBtn = findViewById(R.id.button_increase);
        ImageView decreaseBtn = findViewById(R.id.button_decrease);

        increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });
        decreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

    }
    private void increase() {
        mAmount++;
        textAmount.setText(String.valueOf(mAmount));
    }

    private void decrease() {
        if (mAmount > 0) {
            mAmount--;
            textAmount.setText(String.valueOf(mAmount));
        }
    }
    public void addItem(){
        if(inputData.getText().toString().trim().length() == 0 || mAmount == 0) return;

        String name = inputData.getText().toString();
        ContentValues cv = new ContentValues();

        cv.put(ShopContract.ShopEntry.COLUMN_NAME,name);
        cv.put(ShopContract.ShopEntry.COLUMN_AMOUNT,mAmount);

        DATABASE.insert(ShopContract.ShopEntry.TABLE_NAME,null, cv);
        ADAPTER.swapCursor(getAllItems());
        inputData.getText().clear();


    }
    private Cursor getAllItems(){
        return DATABASE.query(
                ShopContract.ShopEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                ShopContract.ShopEntry.COLUMN_TIMESTAMP+" DESC"
        );
    }
}
