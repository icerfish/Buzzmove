package com.dylanturney.buzzmove.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.dylanturney.buzzmove.data.db.converter.StringListConverter
import com.dylanturney.buzzmove.data.db.dao.PlacesDao
import com.dylanturney.buzzmove.data.model.Place

@Database(entities = [(Place::class)], version = 1)
@TypeConverters(StringListConverter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun placesDao(): PlacesDao

}