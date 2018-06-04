package com.dylanturney.template.ui.base.presenter

import com.dylanturney.template.ui.base.view.MVPView
import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor

interface MVPPresenter <V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}