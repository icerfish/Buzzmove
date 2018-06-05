package com.dylanturney.buzzmove.ui.main.view

import com.dylanturney.buzzmove.ui.base.view.MVPView
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

interface MainMVPView : MVPView {

    fun displayPlaces(places: List<MarkerOptions>?, latLngBounds: LatLngBounds) : Unit?

}