package com.android.stanlyfang.chopstick.sample.di.module;


import com.android.stanlyfang.chopstick.sample.ui.main.MainActivity;
import com.android.stanlyfang.chopstick.sample.ui.SecondActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

//    @Binds
//    @IntoMap
//    @ActivityKey(MainActivity.class)
//    abstract AndroidInjector.Factory<? extends Activity>
//    bindActivityInjectorFactory(MainActivitySubComponent.Builder builder);


    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity contributeMainActivityInjector();


    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract SecondActivity contributeSecondActivityInjector();

}
