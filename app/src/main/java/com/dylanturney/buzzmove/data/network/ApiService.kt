package com.dylanturney.buzzmove.data.network

import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.data.model.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("textsearch/json")
    fun textSearch(
            @Query("query") query: String
    ): Observable<Response<Place>>

}