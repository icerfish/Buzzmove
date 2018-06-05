package com.dylanturney.buzzmove.data.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.dylanturney.buzzmove.data.model.Place


@Dao
interface PlacesDao {

    @Query("SELECT * FROM place_table")
    fun getAll(): LiveData<List<Place>>

    @Query("SELECT * FROM place_table WHERE id = :id ")
    fun getPlace(id: String): LiveData<Place>

    @Insert
    fun insertAll(users: List<Place>)

    @Query("DELETE FROM place_table")
    fun clearTable()

}