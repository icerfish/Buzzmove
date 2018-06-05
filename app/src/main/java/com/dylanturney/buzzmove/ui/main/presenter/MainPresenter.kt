package com.dylanturney.buzzmove.ui.main.presenter

import android.arch.lifecycle.Observer
import com.dylanturney.buzzmove.data.db.repository.PlacesRepository
import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.ui.base.presenter.BasePresenter
import com.dylanturney.buzzmove.ui.main.interactor.MainMVPInteractor
import com.dylanturney.buzzmove.ui.main.view.MainActivity
import com.dylanturney.buzzmove.ui.main.view.MainMVPView
import com.dylanturney.buzzmove.util.SchedulerProvider
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable, private val placesRepository: PlacesRepository, private val mainActivity: MainActivity) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), MainMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)

        placesRepository.getAll().observe(mainActivity, Observer<List<Place>> {
            it?.let {
                if (it.isEmpty())
                    return@let
                val markers = createMarkersAndBounds(it)
                getView()?.displayPlaces(markers.first, markers.second)
            }
        })
    }

    fun createMarkersAndBounds(places: List<Place>): Pair<List<MarkerOptions>, LatLngBounds> {
        val latLngBoundsBuilder = LatLngBounds.Builder()
        val markers = places.map {
            val location = it.geometry?.location
            val latLng = LatLng(location?.lat ?: 0.0, location?.lng ?: 0.0)
            latLngBoundsBuilder.include(latLng)
            MarkerOptions().position(latLng)
        }

        return Pair(markers, latLngBoundsBuilder.build())
    }

    override fun applySearch(query: String?) {
        interactor?.let {
            if (query.isNullOrEmpty()) {

            } else {
                compositeDisposable.add(
                        it.getSearchQueryCall(query!!)
                                .subscribeOn(Schedulers.io())
                                .subscribe {
                                    placesRepository.clearTable()
                                    it.results?.let {
                                        placesRepository.insertAll(it)
                                    }
                                }
                )

            }
        }
    }
}