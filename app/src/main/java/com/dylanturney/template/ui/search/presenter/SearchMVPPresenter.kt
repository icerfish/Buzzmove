package com.dylanturney.template.ui.main.presenter

import com.dylanturney.template.ui.base.presenter.MVPPresenter
import com.dylanturney.template.ui.main.interactor.SearchMVPInteractor
import com.dylanturney.template.ui.main.view.SearchMVPView

interface SearchMVPPresenter<V : SearchMVPView, I : SearchMVPInteractor> : MVPPresenter<V, I> {

}