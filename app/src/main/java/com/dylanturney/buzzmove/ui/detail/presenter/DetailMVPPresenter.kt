package com.dylanturney.buzzmove.ui.detail.presenter

import com.dylanturney.buzzmove.ui.base.presenter.MVPPresenter
import com.dylanturney.buzzmove.ui.detail.interactor.DetailMVPInteractor
import com.dylanturney.buzzmove.ui.detail.view.DetailMVPView

interface DetailMVPPresenter<V : DetailMVPView, I : DetailMVPInteractor> : MVPPresenter<V, I> {

    fun getPlace(id: String)
}