package com.android.stanlyfang.chopstick.mvp

import java.lang.ref.WeakReference

abstract class BasePresenter<V : MvpView> : MvpPresenter<V> {

    private var weakReference: WeakReference<V>? = null

    override fun attchView(view: V) {
        checkNotNull(view)
        weakReference = WeakReference(view)
    }

    override fun detachView() {
        weakReference?.clear()
        weakReference = null
    }

    fun getMvpView() : V? {
        if(isAttached()){
            return weakReference?.get()
        }else{
            throw NullPointerException("have you ever called attachView() in BasePresenter")
        }
    }

    private fun isAttached(): Boolean {
        return weakReference != null
    }

    fun checkViewAttached(){
        if(!isAttached()) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException(val exception:String = "Please call Presenter.attachView(MvpView) before requesting data to the Presenter") : RuntimeException(exception){
        //val exception:String = "Please call Presenter.attachView(MvpView) before requesting data to the Presenter"
    }

}