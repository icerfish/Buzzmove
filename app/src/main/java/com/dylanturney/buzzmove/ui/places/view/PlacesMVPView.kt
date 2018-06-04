package com.mindorks.framework.mvp.ui.feed.blog.view

import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.ui.base.view.MVPView

interface PlacesMVPView : MVPView {

    fun displayPlacesList(places: List<Place>?) : Unit?

}