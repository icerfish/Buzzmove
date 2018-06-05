package com.mindorks.framework.mvp.ui.feed.blog.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dylanturney.buzzmove.data.model.Place
import com.dylanturney.buzzmove.databinding.ItemPlaceListBinding

class PlacesAdapter(private val places: MutableList<Place>) : RecyclerView.Adapter<PlacesAdapter.PlaceViewHolder>() {

    override fun getItemCount() = this.places.size

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) = holder.onBind(this.places[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder = PlaceViewHolder(
            ItemPlaceListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    internal fun updatePlaces(blogs: List<Place>) {
        this.places.clear()
        this.places.addAll(blogs)
        notifyDataSetChanged()
    }

    inner class PlaceViewHolder(private val binding: ItemPlaceListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(place: Place) {
            binding.place = place
        }
    }
}
