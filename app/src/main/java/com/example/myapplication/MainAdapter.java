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

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    ArrayList<MainModel> mainModels;
    Context context;

    public MainAdapter(Context context, ArrayList<MainModel> mainModels) {
        this.context = context;
        this.mainModels = mainModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Set Logo to ImageView
        holder.imageView.setImageResource(mainModels.get(position).getActivLogo());
        //Set Name to TextView;
        holder.textView.setText(mainModels.get(position).getActivName());
        //Set Decription to DescriptionView
        holder.descView.setText(mainModels.get(position).getActivDescription());

        //Set Animated Slide in RecycleViewer
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide);
        animation.setStartOffset(position);
        animation.setRepeatMode(position);
        holder.itemView.startAnimation(animation);


    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initialize Variable
        ImageView imageView;
        TextView textView;
        TextView descView;


        public ViewHolder(@NonNull View itemView, final OnItemClickListener clickListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
            descView = itemView.findViewById(R.id.description_view);

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