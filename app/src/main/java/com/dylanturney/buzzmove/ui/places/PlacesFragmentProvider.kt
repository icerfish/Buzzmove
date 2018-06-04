package com.mindorks.framework.mvp.ui.feed.blog

import com.mindorks.framework.mvp.ui.feed.blog.view.PlacesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class PlacesFragmentProvider {

    @ContributesAndroidInjector(modules = [PlacesFragmentModule::class])
    internal abstract fun providePlacesFragmentFactory(): PlacesFragment
}