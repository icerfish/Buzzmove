package com.dylanturney.buzzmove.ui.base.presenter

import com.dylanturney.buzzmove.ui.base.view.MVPView
import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor

interface MVPPresenter <V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}