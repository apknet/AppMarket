package com.example.as.appmarket_test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_4 extends Fragment {
    private ListView headView;
    private HeadAdapter adapter;
    private List<HeadItem> headList = new ArrayList<>();

    private ListView meView;
    private InfoAdapter infoAdapter;
    private List<InfoItem> infoItemList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_4, null);

        if (headList.size() == 0) {
            initImgs();
        }

        adapter = new HeadAdapter(getContext(), R.layout.head_item, headList);
        infoAdapter = new InfoAdapter(getContext(), R.layout.info_item, infoItemList);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //headView 初始化在 onCreateView()会空指针异常
        headView = getActivity().findViewById(R.id.head_line);
        meView = getActivity().findViewById(R.id.me_list);
        headView.setAdapter(adapter);
        meView.setAdapter(infoAdapter);
    }

    public void initImgs(){
        HeadItem headItem = new HeadItem("As_ ", R.drawable.head);
        headList.add(headItem);

        infoItemList.add(new InfoItem("Reserved "));
        infoItemList.add(new InfoItem("Purchase  history"));
        infoItemList.add(new InfoItem("Community "));
        infoItemList.add(new InfoItem("Settings "));
        infoItemList.add(new InfoItem("Help and customer service "));
        infoItemList.add(new InfoItem("Problems and suggestions "));
        infoItemList.add(new InfoItem("Check for updates "));
        infoItemList.add(new InfoItem("About "));

    }
}
