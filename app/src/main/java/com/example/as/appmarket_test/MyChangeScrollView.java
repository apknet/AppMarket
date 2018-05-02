package com.example.as.appmarket_test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import android.widget.AbsListView.OnScrollListener;
import android.widget.ScrollView;

import static com.example.as.appmarket_test.Fragment_1.img;
import static com.example.as.appmarket_test.MainActivity.tab_title_1;
import static com.example.as.appmarket_test.MainActivity.tab_title_2;
import static com.example.as.appmarket_test.MainActivity.tab_title_3;
import static com.example.as.appmarket_test.MainActivity.tab_title_4;

@SuppressLint("NewApi")
public class MyChangeScrollView extends ScrollView {
	private View mByWhichView;
	private View mTitleView;
	private boolean shouldSlowlyChange = true;
	private OnScrollListener mListener;

	public MyChangeScrollView(Context context) {
		super(context);
	}

	public MyChangeScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyChangeScrollView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}



	public void setListener(OnScrollListener listener) {
		this.mListener = listener;
	}

	public void setShouldSlowlyChange(boolean slowlyChange) {
		this.shouldSlowlyChange = slowlyChange;
	}

	/**
	 * 设置透明度渐变的标题view
	 * 
	 * @param view
	 */
	public void setupTitleView(View view) {
		this.mTitleView = view;
	}

	/**
	 * 跟随的view
	 * 
	 * @param view
	 */
	public void setupByWhichView(View view) {
		mByWhichView = view;
	}

	@Override
	protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
			boolean clampedY) {
		super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);

		if(scrollY >= 300){
			tab_title_1.setTextColor(getResources().getColor(R.color.colorTabTitle));
			tab_title_2.setTextColor(Color.BLACK);
			tab_title_3.setTextColor(Color.BLACK);
			tab_title_4.setTextColor(Color.BLACK);

		}else{
			tab_title_1.setTextColor(Color.WHITE);
			tab_title_2.setTextColor(Color.WHITE);
			tab_title_3.setTextColor(Color.WHITE);
			tab_title_4.setTextColor(Color.WHITE);
		}

		if (scrollY >= 450) {
			mTitleView.setBackgroundColor(Color.WHITE);
			img.setVisibility(View.VISIBLE);

		} else if (scrollY >= 0) {
		    img.setVisibility(View.GONE);
			if (!shouldSlowlyChange) {//设置是否变色
				mTitleView.setBackgroundColor(Color.TRANSPARENT);
			} else {
				float persent = scrollY
						* 1f
						/ ((float)450.0);
				int alpha = (int) (255 * persent);
				int color = Color.argb(alpha, 255, 255, 255);
				Log.i("xiaoqiang","scrollY=="+ scrollY+".."+ 450 +"alpha="+alpha);
				mTitleView.setBackgroundColor(color);
			}
		}

		if (mListener != null) {
			mListener.onScroll(null, scrollX, scrollY, scrollY);
		}
	}
}