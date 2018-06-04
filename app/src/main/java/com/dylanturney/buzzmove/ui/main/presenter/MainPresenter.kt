package com.dylanturney.buzzmove.ui.main.presenter

import com.dylanturney.buzzmove.ui.base.presenter.BasePresenter
import com.dylanturney.buzzmove.ui.main.interactor.MainMVPInteractor
import com.dylanturney.buzzmove.ui.main.view.MainMVPView
import com.dylanturney.buzzmove.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), MainMVPPresenter<V, I> {

    override fun applySearch(query: String?) {
        interactor?.let {
            if (query.isNullOrEmpty()) {

            } else {
                compositeDisposable.add(
                        it.getSearchQueryCall(query!!)
                                .compose(schedulerProvider.ioToMainObservableScheduler())
                                .subscribe {

                                }
                )

            }
        }
    }
}