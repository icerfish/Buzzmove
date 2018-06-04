package com.dylanturney.buzzmove.ui.main.presenter

import com.dylanturney.buzzmove.ui.base.presenter.MVPPresenter
import com.dylanturney.buzzmove.ui.main.interactor.SearchMVPInteractor
import com.dylanturney.buzzmove.ui.main.view.SearchMVPView

interface SearchMVPPresenter<V : SearchMVPView, I : SearchMVPInteractor> : MVPPresenter<V, I> {

}