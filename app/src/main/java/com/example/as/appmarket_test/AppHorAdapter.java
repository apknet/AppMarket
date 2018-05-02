package com.example.as.appmarket_test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AppHorAdapter extends RecyclerView.Adapter<AppHorAdapter.ViewHolder> {

    private Context mContext;
    private List<AppHor> mAppHorList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView appImg;
        TextView appName;
        TextView appSize;
        public ViewHolder(View itemView) {
            super(itemView);
            appImg = itemView.findViewById(R.id.app_img_hor);
            appName = itemView.findViewById(R.id.app_name_hor);
            appSize = itemView.findViewById(R.id.app_size_hor);
        }
    }

    public AppHorAdapter(List<AppHor> appHorList){
        mAppHorList = appHorList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_item_hor, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AppHor appHor = mAppHorList.get(position);

        Glide.with(mContext).load(appHor.getImageUrl()).skipMemoryCache(false).into(holder.appImg);
        holder.appName.setText(appHor.getName());
        holder.appSize.setText(appHor.getSize());
    }

    @Override
    public int getItemCount() {
        return mAppHorList.size();
    }

}
