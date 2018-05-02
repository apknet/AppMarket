package com.example.as.appmarket_test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_2 extends Fragment {

    private List<HeadItem> headList = new ArrayList<>();
    private List<HeadItem> gameList = new ArrayList<>();
    private ListView listView, listView_2;
    private HeadAdapter adapter, adapter_2;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, null);


        if (headList.size() == 0) {
            initIMg();
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new HeadAdapter(getContext(), R.layout.head_item, headList);
        adapter_2 = new HeadAdapter(getContext(), R.layout.head_item, gameList);
        listView = getActivity().findViewById(R.id.list_head);
        listView_2 = getActivity().findViewById(R.id.game_list);
        listView.setAdapter(adapter);
        listView_2.setAdapter(adapter_2);
    }

    public void initIMg(){
        HeadItem head_1 = new HeadItem("Media ", R.drawable.media);
        headList.add(head_1);
        HeadItem head_2 = new HeadItem("Tool ", R.drawable.tools );
        headList.add(head_2);
        HeadItem head_3 = new HeadItem("Communication ", R.drawable.communication );
        headList.add(head_3);
        HeadItem head_4 = new HeadItem("News ", R.drawable.news );
        headList.add(head_4);
        HeadItem head_5 = new HeadItem("Photography ", R.drawable.photography );
        headList.add(head_5);
        HeadItem head_6 = new HeadItem("Education ", R.drawable.education );
        headList.add(head_6);
        HeadItem head_7 = new HeadItem("Shopping ", R.drawable.shopping );
        headList.add(head_7);
        HeadItem head_8 = new HeadItem("Business ", R.drawable.business );
        headList.add(head_8);
        HeadItem head_9 = new HeadItem("Sport ", R.drawable.sport );
        headList.add(head_9);

        HeadItem game_1 = new HeadItem("Leisure Game ", R.drawable.leisure );
        gameList.add(game_1);
        HeadItem game_2 = new HeadItem("Role-playing Game ", R.drawable.role_playing );
        gameList.add(game_2);
        HeadItem game_3 = new HeadItem("Action Game ", R.drawable.action );
        gameList.add(game_3);
        HeadItem game_4 = new HeadItem("Board Game ", R.drawable.board );
        gameList.add(game_4);
        HeadItem game_5 = new HeadItem("Sport Game ", R.drawable.sport_game );
        gameList.add(game_5);
        HeadItem game_6 = new HeadItem("Speed Game ", R.drawable.speed );
        gameList.add(game_6);
        HeadItem game_7 = new HeadItem("Shoot Game ", R.drawable.shoot );
        gameList.add(game_7);

    }
}
