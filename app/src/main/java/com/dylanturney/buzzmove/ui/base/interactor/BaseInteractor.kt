package com.mindorks.framework.mvp.ui.base.interactor

import com.dylanturney.buzzmove.data.network.ApiService

open class BaseInteractor() : MVPInteractor {

    protected lateinit var apiService: ApiService

    constructor(apiService: ApiService) : this() {
        this.apiService = apiService
    }

}