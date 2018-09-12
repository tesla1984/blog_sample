package com.github.liang.viewpagerdemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.liang.viewpagerdemo.view.NoScrollViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;

/**
 * User: liang.li
 * Date: 2018-09-12
 * Time: 11:01
 */
public class TwoFragment extends Fragment {

    private ViewPager mViewPager;
    private MagicIndicator magicIndicator;

    private List<String> tabsList;
    private MyAdapter mAdapter;

    public static Fragment newInstance() {
        return new TwoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tabsList = new ArrayList<>();
        tabsList.add("One");
        tabsList.add("Two");
        tabsList.add("Three");
        tabsList.add("Four");
        tabsList.add("Five");

        mViewPager = (ViewPager) view.findViewById(R.id.pager_view);
        magicIndicator = (MagicIndicator) view.findViewById(R.id.magic_indicator);

        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return tabsList == null ? 0 : tabsList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.GRAY);
                colorTransitionPagerTitleView.setSelectedColor(Color.BLACK);
                colorTransitionPagerTitleView.setText(tabsList.get(index));
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);

        mAdapter = new MyAdapter(getActivity());
        mViewPager.setAdapter(mAdapter);
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }

    class MyAdapter extends PagerAdapter {
        Context context;

        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return tabsList == null ? 0 : tabsList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public TextView instantiateItem(ViewGroup container, int position) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
            textView.setText(tabsList.get(position));
            container.addView(textView);
            return textView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            TextView imageView = (TextView) object;
            container.removeView(imageView);
        }
    }
}
