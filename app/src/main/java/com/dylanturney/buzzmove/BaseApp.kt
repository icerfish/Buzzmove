package com.dylanturney.buzzmove

import android.app.Activity
import android.app.Application
import com.dylanturney.buzzmove.di.component.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BaseApp: Application(), HasActivityInjector  {

    @Inject
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)

        Fresco.initialize(this)
    }
}