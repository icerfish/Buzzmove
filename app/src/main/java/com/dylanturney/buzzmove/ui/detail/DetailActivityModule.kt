package com.dylanturney.buzzmove.ui.detail

import com.dylanturney.buzzmove.ui.detail.interactor.DetailInteractor
import com.dylanturney.buzzmove.ui.detail.interactor.DetailMVPInteractor
import com.dylanturney.buzzmove.ui.detail.presenter.DetailMVPPresenter
import com.dylanturney.buzzmove.ui.detail.presenter.DetailPresenter
import com.dylanturney.buzzmove.ui.detail.view.DetailMVPView
import dagger.Module
import dagger.Provides

@Module
class DetailActivityModule {

    @Provides
    internal fun provideDetailInteractor(detailInteractor: DetailInteractor): DetailMVPInteractor = detailInteractor

    @Provides
    internal fun provideDetailPresenter(mainPresenter: DetailPresenter<DetailMVPView, DetailMVPInteractor>)
            : DetailMVPPresenter<DetailMVPView, DetailMVPInteractor> = mainPresenter

}