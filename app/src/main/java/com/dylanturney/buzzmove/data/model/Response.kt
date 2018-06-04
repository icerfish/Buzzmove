package com.dylanturney.buzzmove.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


open class Response<T> {

    @SerializedName("results")
    @Expose
    private val results: List<T>? = null
    @SerializedName("status")
    @Expose
    private val status: String? = null

}