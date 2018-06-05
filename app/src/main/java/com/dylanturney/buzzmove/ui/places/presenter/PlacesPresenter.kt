package com.mindorks.framework.mvp.ui.feed.blog.presenter

import android.arch.lifecycle.Observer
import com.dylanturney.buzzmove.data.db.repository.PlacesRepository
import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.ui.base.presenter.BasePresenter
import com.dylanturney.buzzmove.ui.places.view.PlacesFragment
import com.dylanturney.buzzmove.util.SchedulerProvider
import com.mindorks.framework.mvp.ui.feed.blog.interactor.PlacesMVPInteractor
import com.mindorks.framework.mvp.ui.feed.blog.view.PlacesMVPView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class PlacesPresenter<V : PlacesMVPView, I : PlacesMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable, private val placesFragment: PlacesFragment, private val placesRepository: PlacesRepository) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), PlacesMVPPresenter<V, I> {

    override fun onViewPrepared() {
        placesRepository.getAll().observe(placesFragment, Observer<List<Place>> {
            it?.let {
                getView()?.displayPlacesList(it)
            }
        })
    }
}