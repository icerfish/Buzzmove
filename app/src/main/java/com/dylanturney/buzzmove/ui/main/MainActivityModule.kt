package com.dylanturney.buzzmove.ui.main

import com.dylanturney.buzzmove.ui.main.interactor.MainInteractor
import com.dylanturney.buzzmove.ui.main.interactor.MainMVPInteractor
import com.dylanturney.buzzmove.ui.main.presenter.MainMVPPresenter
import com.dylanturney.buzzmove.ui.main.presenter.MainPresenter
import com.dylanturney.buzzmove.ui.main.view.MainMVPView
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMVPInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMVPView, MainMVPInteractor>)
            : MainMVPPresenter<MainMVPView, MainMVPInteractor> = mainPresenter

}