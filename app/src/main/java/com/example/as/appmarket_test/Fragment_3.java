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

public class Fragment_3 extends Fragment {
    List<InfoItem> infoList = new ArrayList<>();
    List<InfoItem> infoList_2 = new ArrayList<>();
    ListView infoView, infoView_2;
    InfoAdapter adapter, adapter_2;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, null);


        if (infoList.isEmpty()) {
            initInfo();
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        infoView = getActivity().findViewById(R.id.manage_list);
        adapter = new InfoAdapter(getContext(), R.layout.info_item, infoList);
        infoView.setAdapter(adapter);

        infoView_2 = getActivity().findViewById(R.id.manage_list_2);
        adapter_2 = new InfoAdapter(getContext(), R.layout.info_item, infoList_2);
        infoView_2.setAdapter(adapter_2);

    }

    public void initInfo(){
        infoList.add(new InfoItem("Updates "));

        infoList_2.add(new InfoItem("Installation manager "));
        infoList_2.add(new InfoItem("Installation packages "));
        infoList_2.add(new InfoItem("Storage cleaner "));

    }
}
