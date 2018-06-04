package com.mindorks.framework.mvp.ui.feed.blog.presenter

import com.dylanturney.buzzmove.ui.base.presenter.BasePresenter
import com.dylanturney.buzzmove.util.SchedulerProvider
import com.mindorks.framework.mvp.ui.feed.blog.interactor.PlacesMVPInteractor
import com.mindorks.framework.mvp.ui.feed.blog.view.PlacesMVPView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PlacesPresenter<V : PlacesMVPView, I : PlacesMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), PlacesMVPPresenter<V, I> {

    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {

        }
    }
}