package com.mindorks.framework.mvp.ui.feed.blog

import android.support.v7.widget.LinearLayoutManager
import com.mindorks.framework.mvp.ui.feed.blog.interactor.PlacesInteractor
import com.mindorks.framework.mvp.ui.feed.blog.interactor.PlacesMVPInteractor
import com.mindorks.framework.mvp.ui.feed.blog.presenter.PlacesMVPPresenter
import com.mindorks.framework.mvp.ui.feed.blog.presenter.PlacesPresenter
import com.mindorks.framework.mvp.ui.feed.blog.view.PlacesAdapter
import com.mindorks.framework.mvp.ui.feed.blog.view.PlacesFragment
import com.mindorks.framework.mvp.ui.feed.blog.view.PlacesMVPView
import dagger.Module
import dagger.Provides
import java.util.*

@Module
class PlacesFragmentModule {

    @Provides
    internal fun providePlacesInteractor(interactor: PlacesInteractor): PlacesMVPInteractor = interactor

    @Provides
    internal fun providePlacesPresenter(presenter: PlacesPresenter<PlacesMVPView, PlacesMVPInteractor>)
            : PlacesMVPPresenter<PlacesMVPView, PlacesMVPInteractor> = presenter

    @Provides
    internal fun providePlacesAdapter(): PlacesAdapter = PlacesAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: PlacesFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)

}