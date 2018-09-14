package com.android.stanlyfang.chopstick.di.component

import com.android.stanlyfang.chopstick.BaseApplication
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [(AndroidInjectionModule::class)])
interface AppComponent{
    fun inject(instance : BaseApplication)
}