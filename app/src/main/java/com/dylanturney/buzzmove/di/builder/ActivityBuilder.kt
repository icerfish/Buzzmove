package com.dylanturney.buzzmove.di.builder

import com.dylanturney.buzzmove.ui.main.MainActivityModule
import com.dylanturney.buzzmove.ui.main.SearchActivityModule
import com.dylanturney.buzzmove.ui.main.view.MainActivity
import com.dylanturney.buzzmove.ui.main.view.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(SearchActivityModule::class)])
    abstract fun bindSearchActivity(): SearchActivity

}