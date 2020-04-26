package com.example.myapplication.ShoppingList;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ShoppingAdapter extends RecyclerView.Adapter <ShoppingAdapter.ShoppingViewHolder>{
   private Context mContext;
   private Cursor mCursor;

   public ShoppingAdapter (Context context, Cursor cursor){
       mContext = context;
       mCursor = cursor;
   }
    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view =  inflater.inflate(R.layout.shop_item, parent,false);
        return new ShoppingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
        if(!mCursor.moveToPosition(position)){return;}

        String name = mCursor.getString(mCursor.getColumnIndex(ShoppingContract.ShoppingEntry.COLUMN_NAME));
        int amount = mCursor.getInt(mCursor.getColumnIndex(ShoppingContract.ShoppingEntry.COLUMN_AMOUNT));
        long id = mCursor.getLong(mCursor.getColumnIndex(ShoppingContract.ShoppingEntry._ID));

        holder.nameText.setText(name);
        holder.countText.setText(String.valueOf(amount));
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
    public void swapCursor(Cursor newCursor){
       if(mCursor!=null) mCursor.close();

       mCursor = newCursor;

       if(newCursor != null) notifyDataSetChanged();

    }

    public class ShoppingViewHolder extends RecyclerView.ViewHolder{

       public TextView nameText;
       public TextView countText;

        public ShoppingViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.textview_name_item);
            countText = itemView.findViewById(R.id.textview_amount_item);
        }
    }
}
