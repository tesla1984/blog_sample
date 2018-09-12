package com.github.liang.viewpagerdemo.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * User: liang.li
 * Date: 2018/9/11
 * Time: 20:44
 * canScroll=false 屏蔽掉子view滑动事件
 */
public class ScrollViewPager extends ViewPager {


    public ScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewPager(Context context) {
        super(context);
    }


    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        return false;
    }
}