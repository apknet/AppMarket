package com.example.as.appmarket_test;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomRecycler extends RecyclerView{
    boolean isIntecept;

    public CustomRecycler(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(isIntecept);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        isIntecept = dy <= dx;

    }
}
