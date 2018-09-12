package com.github.liang.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * User: liang.li
 * Date: 2018-09-12
 * Time: 11:00
 *
 */
public class OneFragment extends Fragment{

    public static Fragment newInstance() {
        return new OneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }
}
