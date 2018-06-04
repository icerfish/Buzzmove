package com.dylanturney.buzzmove.data.network

import com.dylanturney.buzzmove.data.model.Model
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("textsearch/")
    fun textSearch(
            @Query("query") query: String
    ): Observable<Model>

}