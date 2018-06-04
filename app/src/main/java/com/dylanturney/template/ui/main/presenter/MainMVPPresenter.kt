package com.dylanturney.template.ui.main.presenter

import com.dylanturney.template.ui.base.presenter.MVPPresenter
import com.dylanturney.template.ui.main.interactor.MainMVPInteractor
import com.dylanturney.template.ui.main.view.MainMVPView

interface MainMVPPresenter<V : MainMVPView, I : MainMVPInteractor> : MVPPresenter<V, I> {

}