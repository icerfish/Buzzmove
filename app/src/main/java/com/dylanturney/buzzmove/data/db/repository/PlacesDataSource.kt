package com.dylanturney.buzzmove.data.db.repository

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.dylanturney.buzzmove.data.db.dao.PlacesDao
import com.dylanturney.buzzmove.data.model.Place
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


open class PlacesDataSource : AndroidViewModel, PlacesRepository {

    var placesDao: PlacesDao
    var allPlaces: LiveData<List<Place>>

    constructor(application: Application, placesDao: PlacesDao) : super(application) {
        this.placesDao = placesDao
        this.allPlaces= placesDao.getAll()
    }

    override fun getAll(): LiveData<List<Place>> = allPlaces

    override fun insertAll(places: List<Place>) {
        insertPlacesObservable(places)
                .observeOn(Schedulers.io())
                .subscribe()
    }

    override fun clearTable() = this.placesDao.clearTable()

    private fun insertPlacesObservable(places: List<Place>) = Observable.create<List<Place>> {
        try {
            this.placesDao.insertAll(places)
            it.onNext(places)
        } finally {
            it.onComplete()
        }
    }
}