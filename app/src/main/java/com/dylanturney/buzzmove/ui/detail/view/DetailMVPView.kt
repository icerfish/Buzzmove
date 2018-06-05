package com.dylanturney.buzzmove.ui.detail.view

import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.ui.base.view.MVPView

interface DetailMVPView : MVPView {

    fun displayPlace(place: Place): Unit?

}