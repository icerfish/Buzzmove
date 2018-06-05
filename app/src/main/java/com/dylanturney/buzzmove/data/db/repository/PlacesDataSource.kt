package com.dylanturney.buzzmove.data.db.repository

import android.arch.lifecycle.LiveData
import com.dylanturney.buzzmove.data.db.dao.PlacesDao
import com.dylanturney.buzzmove.data.model.Place
import javax.inject.Inject



class PlacesDataSource: PlacesRepository {

    private val placeDao: PlacesDao

    @Inject
    constructor(placeDao: PlacesDao) {
        this.placeDao = placeDao
    }

    override fun getAll(): LiveData<List<Place>> {
        return this.placeDao.getAll()
    }

    override fun insertAll(places: List<Place>) {
        this.placeDao.insertAll(places)
    }

    override fun clearTable() {
        this.placeDao.clearTable()
    }
}