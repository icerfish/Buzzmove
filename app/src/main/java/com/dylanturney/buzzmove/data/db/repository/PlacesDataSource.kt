package com.dylanturney.buzzmove.data.db.repository

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.dylanturney.buzzmove.data.db.dao.PlacesDao
import com.dylanturney.buzzmove.data.model.Place
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


class PlacesDataSource : AndroidViewModel, PlacesRepository {

    private val placeDao: PlacesDao
    private val allPlaces: LiveData<List<Place>>

    constructor(application: Application, placeDao: PlacesDao) : super(application) {
        this.placeDao = placeDao
        this.allPlaces = placeDao.getAll()
    }

    override fun getAll(): LiveData<List<Place>> = allPlaces

    override fun insertAll(places: List<Place>) {
        insertPlacesObservable(places)
                .observeOn(Schedulers.io())
                .subscribe()
    }

    override fun clearTable() = this.placeDao.clearTable()

    private fun insertPlacesObservable(places: List<Place>) = Observable.create<List<Place>> {
        try {
            this.placeDao.insertAll(places)
            it.onNext(places)
        } finally {
            it.onComplete()
        }
    }
}