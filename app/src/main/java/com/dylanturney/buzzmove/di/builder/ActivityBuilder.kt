package com.dylanturney.buzzmove.di.builder

import com.dylanturney.buzzmove.ui.main.MainActivityModule
import com.dylanturney.buzzmove.ui.main.view.MainActivity
import com.mindorks.framework.mvp.ui.feed.blog.PlacesFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (PlacesFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

}