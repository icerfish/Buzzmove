package com.dylanturney.buzzmove.di.component

import android.app.Application
import com.dylanturney.buzzmove.BaseApp
import com.dylanturney.buzzmove.data.network.NetworkModule
import com.dylanturney.buzzmove.di.builder.ActivityBuilder
import com.dylanturney.buzzmove.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (NetworkModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApp)

}