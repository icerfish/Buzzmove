package com.dylanturney.buzzmove.ui.detail.interactor

import com.dylanturney.buzzmove.data.network.ApiService
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class DetailInteractor @Inject internal constructor(apiService: ApiService) : BaseInteractor(apiService = apiService), DetailMVPInteractor {

}