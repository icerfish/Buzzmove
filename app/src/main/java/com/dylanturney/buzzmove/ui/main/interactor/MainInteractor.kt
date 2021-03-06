package com.dylanturney.buzzmove.ui.main.interactor

import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.data.model.Response
import com.dylanturney.buzzmove.data.network.ApiService
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class MainInteractor @Inject internal constructor(apiService: ApiService) : BaseInteractor(apiService = apiService), MainMVPInteractor {

    override fun getSearchQueryCall(query: String): Observable<Response<Place>> = apiService.textSearch(query)

}