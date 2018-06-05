package com.dylanturney.buzzmove.data.db.repository

import android.arch.lifecycle.LiveData
import com.dylanturney.buzzmove.data.db.dao.PlacesDao
import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.util.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class PlacesDataSource : PlacesRepository {

    @Inject
    lateinit var schedulerProvider: SchedulerProvider

    private val placeDao: PlacesDao

    @Inject
    constructor(placeDao: PlacesDao) {
        this.placeDao = placeDao
    }

    override fun getAll(): LiveData<List<Place>> {
        return this.placeDao.getAll()
    }

    override fun insertAll(places: List<Place>) {
        insertPlacesObservable(places)
                .observeOn(Schedulers.io())
                .subscribe()
    }

    override fun clearTable() {
        this.placeDao.clearTable()
    }

    private fun insertPlacesObservable(places: List<Place>) = Observable.create<List<Place>> {
        try {
            this.placeDao.insertAll(places)
            it.onNext(places)
        } finally {
            it.onComplete()
        }
    }
}