package com.dylanturney.buzzmove.ui.detail.view

import android.os.Bundle
import com.dylanturney.buzzmove.R
import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.ui.base.view.BaseActivity
import com.dylanturney.buzzmove.ui.detail.interactor.DetailMVPInteractor
import com.dylanturney.buzzmove.ui.detail.presenter.DetailMVPPresenter
import com.dylanturney.buzzmove.util.KeyUtil
import javax.inject.Inject


class DetailActivity : BaseActivity(), DetailMVPView {

    @Inject
    internal lateinit var presenter: DetailMVPPresenter<DetailMVPView, DetailMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        presenter.onAttach(this)

        val placeId = intent.getStringExtra(KeyUtil.placeId)

    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun displayPlace(place: Place) {

    }
}
