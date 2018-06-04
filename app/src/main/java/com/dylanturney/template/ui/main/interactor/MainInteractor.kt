package com.dylanturney.template.ui.main.interactor

import com.dylanturney.template.data.network.ApiService
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class MainInteractor @Inject internal constructor(apiService: ApiService) : BaseInteractor(apiService = apiService), MainMVPInteractor {

}