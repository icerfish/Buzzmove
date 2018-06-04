package com.dylanturney.template.di.builder

import com.dylanturney.template.ui.main.MainActivityModule
import com.dylanturney.template.ui.main.SearchActivityModule
import com.dylanturney.template.ui.main.view.MainActivity
import com.dylanturney.template.ui.main.view.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(SearchActivityModule::class)])
    abstract fun bindSearchActivity(): SearchActivity

}