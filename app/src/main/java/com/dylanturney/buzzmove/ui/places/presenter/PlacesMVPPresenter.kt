package com.mindorks.framework.mvp.ui.feed.blog.presenter

import com.dylanturney.buzzmove.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.feed.blog.interactor.PlacesMVPInteractor
import com.mindorks.framework.mvp.ui.feed.blog.view.PlacesMVPView

interface PlacesMVPPresenter<V : PlacesMVPView, I : PlacesMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared()
}