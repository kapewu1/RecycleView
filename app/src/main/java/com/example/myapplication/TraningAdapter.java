package com.example.myapplication;

import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TraningAdapter extends RecyclerView.Adapter<TraningAdapter.TraningViewHolder> {
    private ArrayList<TraningItem> mTraningItems;
    private OnItemClickListener mListener;
    private int state = 0;

    public interface OnItemClickListener{
        void onItemClick(int position, View v);

    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public TraningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.traning_item, parent, false);

        collapse(v,2000,250);
        TraningViewHolder tvh = new TraningViewHolder(v,mListener);
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

        public TraningViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mLogo = itemView.findViewById(R.id.logoView);
            mName = itemView.findViewById(R.id.traning_name);
            mType = itemView.findViewById(R.id.traning_type);
            mDate = itemView.findViewById(R.id.dateView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position,v);
                        }

                    }
                }
            });
        }
    }
    public void collapse(final View v, int duration, int targetHeight) {
        int prevHeight  = v.getHeight();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                v.getLayoutParams().height = (int) animation.getAnimatedValue();
                v.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.start();
    }
}
