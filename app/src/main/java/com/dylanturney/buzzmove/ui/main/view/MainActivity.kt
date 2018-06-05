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
import com.dylanturney.buzzmove.ui.base.view.BaseActivity
import com.dylanturney.buzzmove.ui.detail.view.DetailActivity
import com.dylanturney.buzzmove.ui.main.interactor.MainMVPInteractor
import com.dylanturney.buzzmove.ui.main.presenter.MainMVPPresenter
import com.dylanturney.buzzmove.util.KeyUtil
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), MainMVPView, HasSupportFragmentInjector, OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>

    var mapFragment: SupportMapFragment? = null
    var googleMap: GoogleMap? = null

    var markers: List<Marker> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        map.view?.visibility = View.GONE

        mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment?.getMapAsync(this)

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

        map.view?.visibility = if (visible) View.INVISIBLE else View.VISIBLE
        places_fragment.view?.visibility = if (visible) View.VISIBLE else View.INVISIBLE
        switch_layout.setImageResource(if (visible) R.drawable.ic_list else R.drawable.ic_map)
    }

    override fun displayPlaces(places: List<Pair<MarkerOptions, String>>?, latLngBounds: LatLngBounds) {
        markers.forEach {
            it.remove()
        }
        markers = places?.mapNotNull {
            val marker = googleMap?.addMarker(it.first)
            marker?.tag = it.second
            marker
        } ?: arrayListOf()

        if (map.isVisible) {
            googleMap?.animateCamera(
                    CameraUpdateFactory.newLatLngBounds(latLngBounds, resources.getDimensionPixelSize(R.dimen.padding)))
        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        this.googleMap = googleMap
        googleMap?.setOnMarkerClickListener(this)
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        if (marker?.tag is String) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(KeyUtil.placeId, marker.tag!! as String)
            startActivity(intent)
        }
        return true
    }
}
