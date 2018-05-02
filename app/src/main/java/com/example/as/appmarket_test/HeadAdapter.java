package com.example.as.appmarket_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HeadAdapter extends ArrayAdapter<HeadItem> {

    private int resourceId;
    public HeadAdapter(Context context, int resource, List<HeadItem> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        HeadItem headItem = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.head_item, parent, false);
        ImageView headImage = view.findViewById(R.id.headImg);
        TextView headName = view.findViewById(R.id.headName);
        headImage.setImageResource(headItem.getImageId());
        headName.setText(headItem.getName());
        return view;
    }
}
