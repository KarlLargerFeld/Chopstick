package com.android.stanlyfang.chopstick.sample.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.stanlyfang.chopstick.mvp.lce.LceView;
import com.android.stanlyfang.chopstick.mvp.lce.LoadView;
import com.android.stanlyfang.chopstick.sample.R;
import com.android.stanlyfang.chopstick.sample.data.SecondRepository;
import com.android.stanlyfang.chopstick.sample.data.UserRepository;
import com.android.stanlyfang.chopstick.sample.ui.base.BaseActivity;
import com.android.stanlyfang.chopstick.sample.ui.main.fragment.CategoryFragment;
import com.android.stanlyfang.chopstick.sample.ui.main.fragment.TodayFragment;
import com.android.stanlyfang.chopstick.sample.ui.main.fragment.adapter.MainFragmentAdapter;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;


public class MainActivity extends BaseActivity implements HasSupportFragmentInjector {


    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


    List<Fragment> mFragmentList = new ArrayList<>();

    String[] titles = {"今天", "类别"};

    MainFragmentAdapter mainFragmentAdapter;

    BottomBar mBottomBar;

    private  Fragment  currentFragment=new Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mBottomBar = findViewById(R.id.bottombar);
        final TodayFragment todayFragment =   TodayFragment.getInstance();
        final CategoryFragment categoryFragment = CategoryFragment.getInstance();
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
//                switchFragment(tabId);
                switch (tabId){
                    case R.id.tab_category:
                        switchFragment(categoryFragment);
                        break;
                    case R.id.tab_today:
                        switchFragment(todayFragment);
                        break;
                }
            }
        });

        mBottomBar.setDefaultTab(R.id.tab_today);




    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }



    private FragmentTransaction switchFragment(Fragment targetFragment) {

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.contentLayout, targetFragment,targetFragment.getClass().getName());

        } else {
            transaction.hide(currentFragment).show(targetFragment);
        }
        currentFragment = targetFragment;
        return transaction;
    }



    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
