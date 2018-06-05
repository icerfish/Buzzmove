package com.dylanturney.buzzmove.data.model

import android.arch.persistence.room.Embedded
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Viewport {

    @Embedded(prefix = "northeast_")
    @SerializedName("northeast")
    @Expose
    var northeast: Location? = null
    @Embedded(prefix = "southwest_")
    @SerializedName("southwest")
    @Expose
    var southwest: Location? = null

}