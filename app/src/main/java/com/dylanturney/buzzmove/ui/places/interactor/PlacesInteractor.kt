package com.mindorks.framework.mvp.ui.feed.blog.interactor

import com.dylanturney.buzzmove.data.network.ApiService
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class PlacesInteractor @Inject internal constructor(apiService: ApiService) : BaseInteractor(apiService), PlacesMVPInteractor {

}