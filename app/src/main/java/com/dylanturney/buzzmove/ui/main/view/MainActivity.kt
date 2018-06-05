package com.dylanturney.buzzmove.ui.main.view

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.View
import android.widget.SearchView
import com.dylanturney.buzzmove.R
import com.dylanturney.buzzmove.data.db.repository.PlacesRepository
import com.dylanturney.buzzmove.ui.base.view.BaseActivity
import com.dylanturney.buzzmove.ui.main.interactor.MainMVPInteractor
import com.dylanturney.buzzmove.ui.main.presenter.MainMVPPresenter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), MainMVPView, HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>
    @Inject
    internal lateinit var placesRepository: PlacesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        map.view?.visibility = View.GONE

        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)

        // Associate searchable configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(componentName))

        return true
    }

    override fun onNewIntent(intent: Intent) {
        setIntent(intent)
        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            presenter.applySearch(query)
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

    fun switchLayouts(view: View) {
        val visible = map.view?.visibility == View.VISIBLE

        map.view?.visibility = if (visible) View.GONE else View.VISIBLE
        places_fragment.view?.visibility = if (visible) View.VISIBLE else View.GONE
        switch_layout.setImageResource(if (visible) R.drawable.ic_list else R.drawable.ic_map)
    }

}
