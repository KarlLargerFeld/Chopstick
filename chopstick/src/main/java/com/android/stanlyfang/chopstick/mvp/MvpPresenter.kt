package com.android.stanlyfang.chopstick.mvp

import android.support.annotation.UiThread

/**
 * Presenter的基础类
 */
interface MvpPresenter < V : MvpView>{

    @UiThread fun  attchView(view :V)

    @UiThread fun detachView()
}