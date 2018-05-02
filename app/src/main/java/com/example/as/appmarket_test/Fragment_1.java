package com.example.as.appmarket_test;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.content.ContentValues.TAG;
import static com.example.as.appmarket_test.CustomViewPager.isCanScroll;
import static com.example.as.appmarket_test.NetworkThread.mapAppName;
import static com.example.as.appmarket_test.NetworkThread.mapAppName_2;
import static com.example.as.appmarket_test.NetworkThread.mapAppSize;
import static com.example.as.appmarket_test.NetworkThread.mapAppSize_2;
import static com.example.as.appmarket_test.NetworkThread.mapAppUrl;
import static com.example.as.appmarket_test.NetworkThread.mapAppUrl_2;

public class Fragment_1 extends Fragment {
    ViewPagerClass viewPagerClass;
    List<View> views = new ArrayList<>();
    RecyclerView recyclerView, recyclerView_2, recyclerView_3, recyclerView_4;

    List<AppHor> appHorList = new ArrayList<>();
    List<AppHor> appHorList_2 = new ArrayList<>();

    LinearLayoutManager layoutManager, layoutManager_2, layoutManager_3, layoutManager_4;
    AppHorAdapter adapter, adapter_2, adapter_3, adapter_4;

    MyChangeScrollView myScroll;
    LinearLayout layout;

    static ImageView img;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, null);

        if (mapAppName.isEmpty()) {
            new NetworkThread().start();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        init();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        img = getActivity().findViewById(R.id.fab);
//        img.setVisibility(View.GONE);

        layout = getActivity().findViewById(R.id.tab_title_layout);
        myScroll = getActivity().findViewById(R.id.myscroll);
        myScroll.setupTitleView(layout);


        //onCreateView中会出错
        viewPagerClass = getActivity().findViewById(R.id.viewPager);
        viewPagerClass.setViewPagerViews(views);

        recyclerView = getActivity().findViewById(R.id.recycler);
        recyclerView_2 = getActivity().findViewById(R.id.recycler_2);
        recyclerView_3 = getActivity().findViewById(R.id.recycler_3);
        recyclerView_4 = getActivity().findViewById(R.id.recycler_4);

        layoutManager = new LinearLayoutManager(getContext());
        layoutManager_2 = new LinearLayoutManager(getContext());
        layoutManager_3 = new LinearLayoutManager(getContext());
        layoutManager_4 = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager_2.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager_3.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager_4.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView_2.setLayoutManager(layoutManager_2);
        recyclerView_3.setLayoutManager(layoutManager_3);
        recyclerView_4.setLayoutManager(layoutManager_4);
        recyclerView.setAdapter(adapter);
        recyclerView_2.setAdapter(adapter_2);
        recyclerView_3.setAdapter(adapter_3);
        recyclerView_4.setAdapter(adapter_4);



     /*   recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.e(TAG, "TEST  onScrolled.................." );

                int lastItem = layoutManager.findLastCompletelyVisibleItemPosition();
                int curLastItem = layoutManager.findLastVisibleItemPosition();
                if((lastItem == curLastItem) && dx > 0){
//                    isCanScroll = false;
                }else{
                   // isCanScroll = true;
                }

            }
        });*/

    }
    public void init(){
        if (appHorList.isEmpty()) {

            ImageView img_1 = new ImageView(getContext());
            ImageView img_2 = new ImageView(getContext());
            ImageView img_3 = new ImageView(getContext());
            ImageView img_4 = new ImageView(getContext());
            ImageView img_5 = new ImageView(getContext());
            ImageView img_6 = new ImageView(getContext());

            img_1.setBackgroundResource(R.drawable.a1);
            views.add(img_1);
            img_2.setBackgroundResource(R.drawable.a2);
            views.add(img_2);
            img_3.setBackgroundResource(R.drawable.a3);
            views.add(img_3);
            img_4.setBackgroundResource(R.drawable.a4);
            views.add(img_4);
            img_5.setBackgroundResource(R.drawable.a5);
            views.add(img_5);
            img_6.setBackgroundResource(R.drawable.a6);
            views.add(img_6);

            Log.e(TAG, "onActivityCreated:  Begin...............");

            for (int i = 0; i < 19; i++) {
                Log.e(TAG, mapAppName.get(i) + mapAppUrl.get(i) + mapAppSize.get(i));
                AppHor appHor = new AppHor(mapAppName.get(i), mapAppUrl.get(i), mapAppSize.get(i));
                appHorList.add(appHor);
                //  AppHor appHor = new AppHor("葫芦娃", "http://android-artworks.25pp.com/fs08/2017/05/24/1/106_c3650a5f31c1c0e806f236b3170785fc_con_130x130.png", "38.5 MB");
            }
            for (int i = 0; i < 18; i++) {
//                Log.e(TAG, mapAppName.get(i) + mapAppUrl.get(i) + mapAppSize.get(i));
                AppHor appHor = new AppHor(mapAppName_2.get(i), mapAppUrl_2.get(i), mapAppSize_2.get(i));
                appHorList_2.add(appHor);
            }

            //onActivityCreated中出错
            adapter = new AppHorAdapter(appHorList);
            adapter_2 = new AppHorAdapter(appHorList_2);
            adapter_3 = new AppHorAdapter(appHorList);
            adapter_4 = new AppHorAdapter(appHorList_2);


        }
    }
}
