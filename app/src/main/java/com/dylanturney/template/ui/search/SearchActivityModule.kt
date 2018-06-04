package com.dylanturney.template.ui.main

import com.dylanturney.template.ui.main.interactor.SearchInteractor
import com.dylanturney.template.ui.main.interactor.SearchMVPInteractor
import com.dylanturney.template.ui.main.presenter.SearchMVPPresenter
import com.dylanturney.template.ui.main.presenter.SearchPresenter
import com.dylanturney.template.ui.main.view.SearchMVPView
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