package com.dylanturney.template.ui.main.view

import android.os.Bundle
import com.dylanturney.template.R
import com.dylanturney.template.ui.base.view.BaseActivity
import com.dylanturney.template.ui.main.interactor.MainMVPInteractor
import com.dylanturney.template.ui.main.presenter.MainMVPPresenter

import javax.inject.Inject

class MainActivity : BaseActivity(), MainMVPView {


    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>

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
