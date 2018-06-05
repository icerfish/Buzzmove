package com.dylanturney.buzzmove.ui.places.view

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dylanturney.buzzmove.R
import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.ui.base.view.BaseFragment
import com.mindorks.framework.mvp.ui.feed.blog.interactor.PlacesMVPInteractor
import com.mindorks.framework.mvp.ui.feed.blog.presenter.PlacesMVPPresenter
import com.mindorks.framework.mvp.ui.feed.blog.view.PlacesAdapter
import com.mindorks.framework.mvp.ui.feed.blog.view.PlacesMVPView
import kotlinx.android.synthetic.main.fragment_places.*
import javax.inject.Inject


class PlacesFragment : BaseFragment(), PlacesMVPView {

    companion object {

        fun newInstance(): PlacesFragment {
            return PlacesFragment()
        }
    }

    @Inject
    internal lateinit var placesAdapter: PlacesAdapter
    @Inject
    internal lateinit var layoutManager: LinearLayoutManager
    @Inject
    internal lateinit var presenter: PlacesMVPPresenter<PlacesMVPView, PlacesMVPInteractor>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_places, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setup() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        places_recycler_view.layoutManager = layoutManager
        places_recycler_view.itemAnimator = DefaultItemAnimator()
        places_recycler_view.adapter = placesAdapter
        presenter.onViewPrepared()
    }

    override fun displayPlacesList(places: List<Place>?) = places?.let {
        placesAdapter.updatePlaces(it)
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }
}