package com.dylanturney.buzzmove.ui.detail.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.dylanturney.buzzmove.R
import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.databinding.ActivityDetailBinding
import com.dylanturney.buzzmove.ui.base.view.BaseActivity
import com.dylanturney.buzzmove.ui.detail.interactor.DetailMVPInteractor
import com.dylanturney.buzzmove.ui.detail.presenter.DetailMVPPresenter
import com.dylanturney.buzzmove.util.KeyUtil
import javax.inject.Inject


class DetailActivity : BaseActivity(), DetailMVPView {

    @Inject
    internal lateinit var presenter: DetailMVPPresenter<DetailMVPView, DetailMVPInteractor>

    internal lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        presenter.onAttach(this)

        val placeId = intent.getStringExtra(KeyUtil.placeId)
        presenter.getPlace(placeId)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun displayPlace(place: Place) {
        binding.item.place = place
    }
}
