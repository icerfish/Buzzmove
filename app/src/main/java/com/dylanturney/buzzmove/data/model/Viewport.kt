package com.dylanturney.buzzmove.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Viewport {

    @SerializedName("northeast")
    @Expose
    var northeast: Location? = null
    @SerializedName("southwest")
    @Expose
    var southwest: Location? = null

}