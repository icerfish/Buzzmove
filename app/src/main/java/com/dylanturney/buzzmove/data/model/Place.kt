package com.dylanturney.buzzmove.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


open class Place {

    @SerializedName("formatted_address")
    @Expose
    var formattedAddress: String? = null
    @SerializedName("geometry")
    @Expose
    var geometry: Geometry? = null
    @SerializedName("icon")
    @Expose
    var icon: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("place_id")
    @Expose
    var placeId: String? = null
    @SerializedName("reference")
    @Expose
    var reference: String? = null
    @SerializedName("types")
    @Expose
    var types: List<String>? = null

}