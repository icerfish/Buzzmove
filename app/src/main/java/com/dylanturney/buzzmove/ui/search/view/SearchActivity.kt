package com.dylanturney.buzzmove.ui.main.view

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import com.dylanturney.buzzmove.R
import com.dylanturney.buzzmove.ui.base.view.BaseActivity
import com.dylanturney.buzzmove.ui.main.interactor.SearchMVPInteractor
import com.dylanturney.buzzmove.ui.main.presenter.SearchMVPPresenter
import javax.inject.Inject


class SearchActivity : BaseActivity(), SearchMVPView {

    @Inject
    internal lateinit var presenter: SearchMVPPresenter<SearchMVPView, SearchMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        presenter.onAttach(this)

        handleIntent(intent)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onNewIntent(intent: Intent) {
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {

        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            //use the query to search your data somehow
        }
    }

}
