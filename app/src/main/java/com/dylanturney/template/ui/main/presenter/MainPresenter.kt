package com.dylanturney.template.ui.main.presenter

import com.dylanturney.template.ui.base.presenter.BasePresenter
import com.dylanturney.template.ui.main.interactor.MainMVPInteractor
import com.dylanturney.template.ui.main.view.MainMVPView
import com.dylanturney.template.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), MainMVPPresenter<V, I> {

}