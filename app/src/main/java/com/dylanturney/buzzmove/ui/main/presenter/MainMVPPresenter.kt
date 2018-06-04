package com.dylanturney.buzzmove.ui.main.presenter

import com.dylanturney.buzzmove.ui.base.presenter.MVPPresenter
import com.dylanturney.buzzmove.ui.main.interactor.MainMVPInteractor
import com.dylanturney.buzzmove.ui.main.view.MainMVPView

interface MainMVPPresenter<V : MainMVPView, I : MainMVPInteractor> : MVPPresenter<V, I> {

}