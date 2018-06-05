package com.dylanturney.buzzmove.ui.detail.presenter

import android.arch.lifecycle.Observer
import com.dylanturney.buzzmove.data.db.repository.PlacesRepository
import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.ui.base.presenter.BasePresenter
import com.dylanturney.buzzmove.ui.detail.interactor.DetailMVPInteractor
import com.dylanturney.buzzmove.ui.detail.view.DetailActivity
import com.dylanturney.buzzmove.ui.detail.view.DetailMVPView
import com.dylanturney.buzzmove.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class DetailPresenter<V : DetailMVPView, I : DetailMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable, private val placesRepository: PlacesRepository, private val detailActivity: DetailActivity) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), DetailMVPPresenter<V, I> {

    override fun getPlace(id: String) {
        placesRepository.getPlace(id).observe(detailActivity, Observer<Place> {
            it?.let {
                getView()?.displayPlace(it)
            }
        })
    }
}