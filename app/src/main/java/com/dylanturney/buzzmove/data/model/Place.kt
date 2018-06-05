package com.dylanturney.buzzmove.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "place_table")
open class Place {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("formatted_address")
    @ColumnInfo(name = "formatted_address")
    @Expose
    var formattedAddress: String? = null
    @Embedded
    @SerializedName("geometry")
    @Expose
    var geometry: Geometry? = null
    @SerializedName("icon")
    @Expose
    var icon: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @ColumnInfo(name = "place_id")
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