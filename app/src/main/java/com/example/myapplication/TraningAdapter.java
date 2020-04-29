package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TraningAdapter extends RecyclerView.Adapter<TraningAdapter.TraningViewHolder> {
    private ArrayList<TraningItem> mTraningItems;

    @NonNull
    @Override
    public TraningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.traning_item, parent, false);
        TraningViewHolder tvh = new TraningViewHolder(v);
        return tvh;
    }

    public TraningAdapter(ArrayList<TraningItem> traningItems){
        mTraningItems = traningItems;
    }

    @Override
    public void onBindViewHolder(@NonNull TraningViewHolder holder, int position) {
            TraningItem currentItem = mTraningItems.get(position);

            holder.mLogo.setImageResource(currentItem.getmImageId());
            holder.mName.setText(currentItem.getTraningName());
            holder.mType.setText(currentItem.getTraningType());
            holder.mDate.setText(currentItem.getTraningDate());
    }

    @Override
    public int getItemCount() {
        return mTraningItems.size();
    }

    public static class TraningViewHolder extends RecyclerView.ViewHolder{
            ImageView mLogo;
            TextView mName;
            TextView mType;
            TextView mDate;

        public TraningViewHolder(@NonNull View itemView) {
            super(itemView);
            mLogo = itemView.findViewById(R.id.logoView);
            mName = itemView.findViewById(R.id.traning_name);
            mType = itemView.findViewById(R.id.traning_type);
            mDate = itemView.findViewById(R.id.dateView);
        }
    }
}
