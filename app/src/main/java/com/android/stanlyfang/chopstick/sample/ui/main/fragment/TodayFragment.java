package com.android.stanlyfang.chopstick.sample.ui.main.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.stanlyfang.chopstick.sample.R;

public class TodayFragment extends Fragment {


    public TodayFragment() {
        // Required empty public constructor
    }

    public static TodayFragment getInstance(){
        return new TodayFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today, container, false);
    }


}
