package com.example.as.appmarket_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class InfoAdapter extends ArrayAdapter<InfoItem> {

    public InfoAdapter(Context context, int resource, List<InfoItem> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        InfoItem infoItem = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.info_item, parent, false);
        TextView infoName = view.findViewById(R.id.infoName);
        infoName.setText(infoItem.getName());
        return view;
    }
}
