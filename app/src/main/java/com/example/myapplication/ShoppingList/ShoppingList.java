package com.example.myapplication.ShoppingList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
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

import com.example.myapplication.R;

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

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                removeItem((long) viewHolder.itemView.getTag());
            }
        }).attachToRecyclerView(recyclerView);

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
    private void removeItem(long id){
        DATABASE.delete(ShoppingContract.ShoppingEntry.TABLE_NAME,
                ShoppingContract.ShoppingEntry._ID + "=" + id,null);
                ADAPTER.swapCursor(getAllItems());
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

        cv.put(ShoppingContract.ShoppingEntry.COLUMN_NAME,name);
        cv.put(ShoppingContract.ShoppingEntry.COLUMN_AMOUNT,mAmount);

        DATABASE.insert(ShoppingContract.ShoppingEntry.TABLE_NAME,null, cv);
        ADAPTER.swapCursor(getAllItems());
        inputData.getText().clear();


    }
    private Cursor getAllItems(){
        return DATABASE.query(
                ShoppingContract.ShoppingEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                ShoppingContract.ShoppingEntry.COLUMN_TIMESTAMP+" DESC"
        );
    }
}
