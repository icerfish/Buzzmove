package com.dylanturney.buzzmove.ui.main.interactor

import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.data.model.Response
import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface MainMVPInteractor : MVPInteractor {

    fun getSearchQueryCall(query: String): Observable<Response<Place>>

}