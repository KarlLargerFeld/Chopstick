package com.android.stanlyfang.chopstick.sample.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.stanlyfang.chopstick.sample.R;

import dagger.android.AndroidInjection;

public abstract class BaseActivity extends AppCompatActivity {



    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);

        setContentView(getLayoutResId());

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setTitle("首页");
        setSupportActionBar(mToolbar);

    }

    public abstract int getLayoutResId();
}
