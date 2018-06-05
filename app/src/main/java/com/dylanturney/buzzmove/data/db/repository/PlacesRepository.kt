package com.dylanturney.buzzmove.data.db.repository

import android.arch.lifecycle.LiveData
import com.dylanturney.buzzmove.data.model.Place


interface PlacesRepository {

    fun getAll(): LiveData<List<Place>>

    fun getPlace(id: String): LiveData<Place>

    fun insertAll(places: List<Place>)

    fun clearTable()

}