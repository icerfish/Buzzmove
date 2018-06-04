package com.dylanturney.template.ui.main.view

import android.os.Bundle
import com.dylanturney.buzzmove.R
import com.dylanturney.template.ui.base.view.BaseActivity
import com.dylanturney.template.ui.main.interactor.SearchMVPInteractor
import com.dylanturney.template.ui.main.presenter.SearchMVPPresenter
import javax.inject.Inject


class SearchActivity : BaseActivity(), SearchMVPView {

    @Inject
    internal lateinit var presenter: SearchMVPPresenter<SearchMVPView, SearchMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

}
