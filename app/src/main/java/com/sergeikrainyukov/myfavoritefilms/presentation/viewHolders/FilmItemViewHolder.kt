package com.sergeikrainyukov.myfavoritefilms.presentation.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sergeikrainyukov.myfavoritefilms.R
import com.sergeikrainyukov.myfavoritefilms.presentation.model.FilmListItem

class FilmItemViewHolder(
    private val view: View,
    private val addToFavoritesAction: (Int) -> Unit,
    private val openFilmDescriptionAction: (Int) -> Unit
) :
    RecyclerView.ViewHolder(view) {
    fun bind(filmListItem: FilmListItem) {
        with(view) {
            findViewById<TextView>(R.id.title).text = filmListItem.name
            findViewById<TextView>(R.id.year).text = filmListItem.year
            if (filmListItem.image.isNotBlank()) Glide.with(itemView.context)
                .load(filmListItem.image)
                .into(findViewById(R.id.film_image))
            setOnClickListener {
                openFilmDescriptionAction.invoke(filmListItem.id)
            }
            setOnLongClickListener {
                addToFavoritesAction.invoke(filmListItem.id)
                true
            }
        }
    }
}