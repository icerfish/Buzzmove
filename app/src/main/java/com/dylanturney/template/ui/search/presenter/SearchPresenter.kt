package com.dylanturney.template.ui.main.presenter

import com.dylanturney.template.ui.base.presenter.BasePresenter
import com.dylanturney.template.ui.main.interactor.SearchMVPInteractor
import com.dylanturney.template.ui.main.view.SearchMVPView
import com.dylanturney.template.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SearchPresenter<V : SearchMVPView, I : SearchMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), SearchMVPPresenter<V, I> {

}