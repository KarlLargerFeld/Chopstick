package com.android.stanlyfang.chopstick.sample.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.android.stanlyfang.chopstick.sample.R;
import com.android.stanlyfang.chopstick.sample.data.SecondRepository;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class SecondActivity extends AppCompatActivity {


    @Inject
    SecondRepository mSecondRepository;




    public static void launch(Context context){
        Intent it = new Intent(context,SecondActivity.class);
        context.startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_second);



        System.out.println(mSecondRepository);
    }
}
