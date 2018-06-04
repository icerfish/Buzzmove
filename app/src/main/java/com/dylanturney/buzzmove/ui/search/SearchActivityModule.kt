package com.dylanturney.buzzmove.ui.main

import com.dylanturney.buzzmove.ui.main.interactor.SearchInteractor
import com.dylanturney.buzzmove.ui.main.interactor.SearchMVPInteractor
import com.dylanturney.buzzmove.ui.main.presenter.SearchMVPPresenter
import com.dylanturney.buzzmove.ui.main.presenter.SearchPresenter
import com.dylanturney.buzzmove.ui.main.view.SearchMVPView
import dagger.Module
import dagger.Provides

@Module
class SearchActivityModule {

    @Provides
    internal fun provideSearchInteractor(searchInteractor: SearchInteractor): SearchMVPInteractor = searchInteractor

    @Provides
    internal fun provideSearchPresenter(searchPresenter: SearchPresenter<SearchMVPView, SearchMVPInteractor>)
            : SearchMVPPresenter<SearchMVPView, SearchMVPInteractor> = searchPresenter

}