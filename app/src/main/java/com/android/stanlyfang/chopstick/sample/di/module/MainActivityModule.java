package com.android.stanlyfang.chopstick.sample.di.module;

import android.widget.TextView;

import com.android.stanlyfang.chopstick.sample.data.SecondRepository;
import com.android.stanlyfang.chopstick.sample.data.UserRepository;
import com.android.stanlyfang.chopstick.sample.ui.main.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {


    @Provides
    UserRepository provideUserRepository(){

        return  new UserRepository();
    }


    @Provides
    SecondRepository provideSecondRepository(){
        return new SecondRepository();
    }


    @Provides
    TextView provideTextView(MainActivity activity){
        return new TextView(activity);
    }



}
