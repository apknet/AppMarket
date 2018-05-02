package com.example.as.appmarket_test;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.as.appmarket_test.MainActivity.myViewPager;
import static com.example.as.appmarket_test.MainActivity.tab_title_1;
import static com.example.as.appmarket_test.MainActivity.tab_title_2;
import static com.example.as.appmarket_test.MainActivity.tab_title_3;
import static com.example.as.appmarket_test.MainActivity.tab_title_4;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static TextView tab_title_1, tab_title_2, tab_title_3, tab_title_4;
    static ViewPager myViewPager;
    static ImageView tab_line;
    static final int TAB_0 = 0;
    static final int TAB_1 = 1;
    static final int TAB_2 = 2;
    static final int TAB_3 = 3;
    static int tab_index = TAB_0;

    int line_width;
    static int offset = 0;

    List<Fragment> list;
    TabFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |  View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_main);

        tab_title_1 = findViewById(R.id.tab_title_1);
        tab_title_2 = findViewById(R.id.tab_title_2);
        tab_title_3 = findViewById(R.id.tab_title_3);
        tab_title_4 = findViewById(R.id.tab_title_4);
        myViewPager = findViewById(R.id.myViewPage);
        tab_line = findViewById(R.id.tab_line);

        initImageView();

        tab_title_1.setOnClickListener(this);
        tab_title_2.setOnClickListener(this);
        tab_title_3.setOnClickListener(this);
        tab_title_4.setOnClickListener(this);
        myViewPager.setOnPageChangeListener(new MyPagerChangeListener());
        list = new ArrayList<>();
        list.add(new Fragment_1());
        list.add(new Fragment_2());
        list.add(new Fragment_3());
        list.add(new Fragment_4());

        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list);
        myViewPager.setAdapter(adapter);
        myViewPager.setCurrentItem(0);
      //  tab_title_1.setBackgroundColor(Color.BLUE);
    }
    private void initImageView() {
        line_width = BitmapFactory.decodeResource(getResources(), R.drawable.tab_line).getWidth();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (screenW / 4 - line_width) / 2;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        tab_line.setImageMatrix(matrix);
    }


    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.tab_title_4:
            /*    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    getWindow().setStatusBarColor(getColor(R.color.colorPrimaryDark));
                }*/
                myViewPager.setCurrentItem(3, true);
                tab_title_1.setBackgroundColor(Color.WHITE);
                tab_title_2.setBackgroundColor(Color.WHITE);
                tab_title_3.setBackgroundColor(Color.WHITE);
//                tab_title_4.setBackgroundColor(Color.BLUE);
                tab_title_4.setTextColor(getResources().getColor(R.color.colorTabTitle));
                tab_index = TAB_3;
                break;
            case R.id.tab_title_3:
         /*       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    getWindow().setStatusBarColor(getColor(R.color.colorPrimaryDark));
                }*/
                myViewPager.setCurrentItem(2, true);
                tab_title_1.setBackgroundColor(Color.WHITE);
                tab_title_2.setBackgroundColor(Color.WHITE);
                tab_title_3.setTextColor(getResources().getColor(R.color.colorTabTitle));
                tab_title_4.setBackgroundColor(Color.WHITE);
                tab_index = TAB_2;
                //   tab_title_3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                break;
            case R.id.tab_title_2:
 /*               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    getWindow().setStatusBarColor(getColor(R.color.colorPrimaryDark));
                }*/
                myViewPager.setCurrentItem(1, true);
                tab_title_1.setBackgroundColor(Color.WHITE);
                tab_title_2.setTextColor(getResources().getColor(R.color.colorTabTitle));
                tab_title_3.setBackgroundColor(Color.WHITE);
                tab_title_4.setBackgroundColor(Color.WHITE);
                tab_index = TAB_1;
                break;
            case R.id.tab_title_1:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                }
                myViewPager.setCurrentItem(0, true);
                tab_title_1.setBackground(getResources().getDrawable(R.drawable.tab_title));
                tab_title_1.setTextColor(Color.WHITE);
                tab_title_2.setBackground(getResources().getDrawable(R.drawable.tab_title));
                tab_title_2.setTextColor(Color.WHITE);
                tab_title_3.setBackground(getResources().getDrawable(R.drawable.tab_title));
                tab_title_3.setTextColor(Color.WHITE);
                tab_title_4.setBackground(getResources().getDrawable(R.drawable.tab_title));
                tab_title_4.setTextColor(Color.WHITE);
                tab_index = TAB_0;
                break;
        }
    }



    class MyPagerChangeListener  implements ViewPager.OnPageChangeListener {

        int one = offset * 2 + line_width;
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            float fromX = one * tab_index;
            float toX = one * position;
            Animation animation = new TranslateAnimation(fromX, toX, 0, 0);
            animation.setFillAfter(true);
            animation.setDuration(300);
            tab_line.startAnimation(animation);
            switch(position){
                case 0:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                }
                    tab_title_1.setBackgroundResource(R.drawable.tab_title);
                    tab_title_1.setTextColor(Color.WHITE);
                    tab_title_2.setBackgroundResource(R.drawable.tab_title);
                    tab_title_2.setTextColor(Color.WHITE);
                    tab_title_3.setBackgroundResource(R.drawable.tab_title);
                    tab_title_3.setTextColor(Color.WHITE);
                    tab_title_4.setBackgroundResource(R.drawable.tab_title);
                    tab_title_4.setTextColor(Color.WHITE);
                    tab_index = TAB_0;
                    break;
                case 1:
                    tab_title_1.setBackgroundColor(Color.WHITE);
                    tab_title_1.setTextColor(Color.BLACK);
                    tab_title_2.setTextColor(getResources().getColor(R.color.colorTabTitle));
                    tab_title_3.setBackgroundColor(Color.WHITE);
                    tab_title_3.setTextColor(Color.BLACK);
                    tab_title_4.setBackgroundColor(Color.WHITE);
                    tab_title_4.setTextColor(Color.BLACK);

                    tab_index = TAB_1;
                    break;
                case 2:
                    tab_title_1.setBackgroundColor(Color.WHITE);
                    tab_title_1.setTextColor(Color.BLACK);
                    tab_title_2.setBackgroundColor(Color.WHITE);
                    tab_title_2.setTextColor(Color.BLACK);
                    tab_title_3.setTextColor(getResources().getColor(R.color.colorTabTitle));
                    tab_title_4.setBackgroundColor(Color.WHITE);
                    tab_title_4.setTextColor(Color.BLACK);
                    tab_index = TAB_2;
                    break;
                case 3:
                    tab_title_1.setBackgroundColor(Color.WHITE);
                    tab_title_1.setTextColor(Color.BLACK);
                    tab_title_2.setBackgroundColor(Color.WHITE);
                    tab_title_2.setTextColor(Color.BLACK);
                    tab_title_3.setBackgroundColor(Color.WHITE);
                    tab_title_3.setTextColor(Color.BLACK);
                    tab_title_4.setTextColor(getResources().getColor(R.color.colorTabTitle));
                    tab_index = TAB_3;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
