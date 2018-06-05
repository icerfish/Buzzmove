package com.dylanturney.buzzmove.di.module

import android.app.Application
import android.arch.persistence.room.Room
import com.dylanturney.buzzmove.data.db.AppDatabase
import com.dylanturney.buzzmove.data.db.dao.PlacesDao
import com.dylanturney.buzzmove.data.db.repository.PlacesDataSource
import com.dylanturney.buzzmove.data.db.repository.PlacesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Singleton
    @Provides
    fun providesRoomDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "places-db").build()
    }

    @Singleton
    @Provides
    fun providesPlaceDao(appDatabase: AppDatabase): PlacesDao {
        return appDatabase.placesDao()
    }

    @Singleton
    @Provides
    fun placeRepository(application: Application, placesDao: PlacesDao): PlacesRepository {
        return PlacesDataSource(application, placesDao)
    }
}