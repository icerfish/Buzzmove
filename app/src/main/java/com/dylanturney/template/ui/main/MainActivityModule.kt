package com.dylanturney.template.ui.main

import com.dylanturney.template.ui.main.interactor.MainInteractor
import com.dylanturney.template.ui.main.interactor.MainMVPInteractor
import com.dylanturney.template.ui.main.presenter.MainMVPPresenter
import com.dylanturney.template.ui.main.presenter.MainPresenter
import com.dylanturney.template.ui.main.view.MainMVPView
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