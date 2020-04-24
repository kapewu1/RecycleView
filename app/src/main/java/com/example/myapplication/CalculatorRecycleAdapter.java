package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CalculatorRecycleAdapter extends RecyclerView.Adapter<CalculatorRecycleAdapter.ViewHolder> {
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    ArrayList<MainModel> calcObjects;
    Context context;

    public CalculatorRecycleAdapter(Context context, ArrayList<MainModel> calcObjects) {
        this.context = context;
        this.calcObjects = calcObjects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calc_row_item, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Set Logo to ImageView
        holder.calcImg.setImageResource(calcObjects.get(position).getActivLogo());
        //Set Name to TextView;
        holder.calcName.setText(calcObjects.get(position).getActivName());

    }

    @Override
    public int getItemCount() {
        return calcObjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initialize Variable
        ImageView calcImg;
        TextView calcName;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener clickListener) {
            super(itemView);
            calcImg = itemView.findViewById(R.id.calc_img);
            calcName = itemView.findViewById(R.id.calc_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(clickListener != null) {
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            clickListener.onItemClick(position);
                        }
                    }

                }
            });
        }
    }
}
