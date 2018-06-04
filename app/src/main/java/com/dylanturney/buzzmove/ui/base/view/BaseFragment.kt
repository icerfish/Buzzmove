package com.dylanturney.buzzmove.ui.base.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import dagger.android.support.AndroidSupportInjection


abstract class BaseFragment : Fragment(), MVPView {

    private var parentActivity: BaseActivity? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.parentActivity = activity
            activity?.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDependencyInjection()
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    override fun hideProgress() {

    }

    override fun showProgress() {
        hideProgress()
    }

    fun getBaseActivity() = parentActivity

    private fun performDependencyInjection() = AndroidSupportInjection.inject(this)

    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

    abstract fun setup()
}