package com.dylanturney.buzzmove.data.model

import android.arch.persistence.room.Embedded
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Geometry {

    @Embedded(prefix = "location_")
    @SerializedName("location")
    @Expose
    var location: Location? = null
    @Embedded(prefix = "viewport_")
    @SerializedName("viewport")
    @Expose
    var viewport: Viewport? = null

}