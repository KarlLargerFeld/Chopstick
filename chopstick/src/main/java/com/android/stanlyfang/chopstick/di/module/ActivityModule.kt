package com.android.stanlyfang.chopstick.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeActivityInjector()
}