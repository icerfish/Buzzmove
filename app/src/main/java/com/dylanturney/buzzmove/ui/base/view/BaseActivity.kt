package com.dylanturney.buzzmove.ui.base.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

open class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.Callback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    override fun hideProgress() {
    }

    override fun showProgress() {
        hideProgress()

    }

    private fun performDI() = AndroidInjection.inject(this)

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }
}