package com.android.stanlyfang.chopstick.sample.di.component;

import com.android.stanlyfang.chopstick.sample.App;
import com.android.stanlyfang.chopstick.sample.di.module.ActivityModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AndroidInjectionModule.class,
        ActivityModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent{

    void inject(App instance);
}
